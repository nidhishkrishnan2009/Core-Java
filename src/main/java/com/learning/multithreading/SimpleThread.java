package com.learning.multithreading;

public class SimpleThread {
	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		Thread2 r1=new Thread2();
		Thread t2=new Thread(r1);

		
		//Creating thread using anonymous inner class extending thread class
		Thread t3=new Thread() {
			@Override
			public void run() {
				System.out.println("Running the thread created using anonymous inner class by extending thread class");
			}
		};
		
		Runnable r2=new Runnable() {
			public void run() {
				System.out.println("Running the thread created using anonymous inner class by implementing runnable intereface");
			}
		};
		
		Thread t4=new Thread(r2);
		t3.run();
		t4.run();
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread{
	
	@Override
	public void run(){
		System.out.println("Thread running by extending Thread class");
	}
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread running by implementing runnable interface");
		
	}
	
}