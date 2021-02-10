package com.learning.interview.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorService1 {
	static final int CALLABLE_TIMEOUT=1000;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable runnableTask=()->{
			System.out.println("Runable task is running");
		};
		
		Callable<String> callableTask=()->{
			Thread.sleep(CALLABLE_TIMEOUT);
			return "Callable task is running";
		};
		
		List<Callable<String>> callableList=new ArrayList<Callable<String>>();
		callableList.add(callableTask);
		callableList.add(callableTask);
		ExecutorService executor=Executors.newFixedThreadPool(2);
		// Executor submit
		Future<String> callableFuture= executor.submit(callableTask);
		try {
			System.out.println("submit result===>"+callableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// InvokeAny
		
		try {
			String invokeAnyResult= executor.invokeAny(callableList);
			System.out.println("Invoke Any result===>"+invokeAnyResult);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Invoke All
		
		try {
			List<Future<String>> invokeAllResult=executor.invokeAll(callableList);
			System.out.println("InvokeAll Result====>");
			invokeAllResult.stream().forEach(result->{
				try {
					System.out.println(result.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Shut Down - it waits for all runnable state threads to complete before shutdown. It will not accept new threads
		 * shutDownNow() - It shutdown the executor service immediately with out waiting for runnable state threads to complete.
		 * awaitTermination- this will wait for specified time before shutting down the service.
		 */
		
		Callable<String> callableWait=()->{
			Thread.sleep(10000);
			return "Callable statement going to wait";
		};
		
//		try {
//			callableWait.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Future<String> callableWaitFuture= executor.submit(callableWait);
		
		Future<?> runnableFuture= executor.submit(runnableTask);
		runnableFuture.get();
		
		System.out.println(callableWaitFuture.get());
		if(!executor.awaitTermination(CALLABLE_TIMEOUT, TimeUnit.MILLISECONDS))
			executor.shutdownNow();
	}
}
