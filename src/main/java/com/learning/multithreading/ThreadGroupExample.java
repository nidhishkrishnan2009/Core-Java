package com.learning.multithreading;

/**
 * 
 * @author Krishnan
 * ThreadGroup will contains set of user threads. This will allow us suspend ,resume or interrupt group of threads by calling 
 * a single method in Thread Group. Thread Group can contain another thread Group also.
 */
public class ThreadGroupExample {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup tg=new ThreadGroup("My Group");
		Runnable threadRunner=new ThreadGroupRunnable();
		Thread t1=new Thread(tg,threadRunner,"mythread1");
		Thread t2=new Thread(tg, threadRunner, "mythread2");
		Thread t3=new Thread(tg, threadRunner, "mythread3");
		tg.interrupt();
		Thread.sleep(1000);
		t1.start();

		t2.start();
		t3.start();
		tg.list();
		

	}
}

class ThreadGroupRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("current runing thread =  "+Thread.currentThread().getName());
		
	}
	
}