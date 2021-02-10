package com.learning.multithreading.synchronization;

/**
 * 
 * @author Krishnan
 *synchronized method or synchronized block regions are known as Monitor. ReentrantMonitor is 
 *Monitor of one synchronized method could be reused for another synchronized method.
 */
public class ReentrantMonitor {

	
	public static void main(String[] args) {
		final Task4 task=new Task4();
		Thread t1=new Thread() {
			public void run()
			{
				task.m();
			}
		};
		
		Thread t2=new Thread() {
			public void run()
			{
				task.m();
			}
		};
		
		t1.start();
		t2.start();
	}
	
}

class Task4{
	public synchronized void m()
	{
		System.out.println("m is called");
		n();
	}
	
	public synchronized void n() {
		System.out.println("n is called");
	}
}