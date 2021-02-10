package com.learning.multithreading.synchronization;

public class SynchronizedMethod {
	public static void main(String[] args) {
		Printer p=new Printer();
		Thread t1=new Thread() {
			
			@Override
			public void run() {
				p.print(5);
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run()
			{
				p.print(100);
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Printer{
	synchronized void print(int n)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("printing "+i*n);
		}
	}
}