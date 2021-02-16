package com.learning.multithreading;

public class ThreadYield {

	public static void main(String[] args) {
		Thread t1=new Thread() {
			@Override
			public void run() {
				for(int i=1;i<101;i++)
				{
					System.out.println(i);
				}
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				for(int i=101;i<106;i++)
				{
					System.out.println(i);
				}
			}
		};
		
		t1.start();
		Thread.yield();
		t2.start();
	}
}
