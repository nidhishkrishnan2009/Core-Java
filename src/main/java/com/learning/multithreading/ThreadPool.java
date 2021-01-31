package com.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Krishnan
 *Thread pool is a concept of creating pool of worker threads from which threads will be picked by thread scheduler for jobs.
 *After finishing the job thread will come back to the pool hence it could be re used for another job.
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool=Executors.newFixedThreadPool(5);
		for(int i=0;i<6;i++)
		{
			Runnable WorkerThread=new WorkerThread(""+i);
			threadPool.execute(WorkerThread);
		}
		
		threadPool.shutdown();
		
	}
}

class WorkerThread implements Runnable{

	private String message;
	public WorkerThread(String message) {
		this.message=message;
	}
	@Override
	public void run() {
		System.out.println("Starting the thread "+Thread.currentThread().getName()+" with message = "+message);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ending the thread "+Thread.currentThread().getName());
	}
	
}