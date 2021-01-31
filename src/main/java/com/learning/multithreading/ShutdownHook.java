package com.learning.multithreading;

//Shutdown hook helps to run any clean up tasks just before JVM terminates. It is invoked either JVM terminates normal or abnormal.
public class ShutdownHook {
	public static void main(String[] args) throws InterruptedException {
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Thread hook called");
			}
		});
		
		T3 t1=new T3();
		t1.start();
		for(int i=1;i<10;i++)
		{
			Thread.sleep(2000);
			System.out.println(i);
		}
		
	}
}
