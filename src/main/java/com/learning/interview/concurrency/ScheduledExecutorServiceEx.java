package com.learning.interview.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx {
	public static void main(String[] args) {
		ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
		Runnable runnableTask=()->System.out.println("Schedule at fixed delay");
		Runnable runnableTask2=()->System.out.println("Schedule at fixed rate");
		Callable<String> callableTask=()->"new callable task";
		//executor.schedule(runnableTask, 100, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(runnableTask2, 100, 100, TimeUnit.MILLISECONDS);
		executor.scheduleWithFixedDelay(runnableTask, 100, 500, TimeUnit.MILLISECONDS);
		
	}
}
