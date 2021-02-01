package com.learning.synchronization;

public class WithoutSynchronization {
	public static void main(String[] args) {
		Task t=new Task();
		Thread t1=new Thread() {
			@Override
			public void run() {
				t.print(5);
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run()
			{
				t.print(100);
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Task{
	public void print(int n) {
		for(int i=0;i<5;i++)
		{
			System.out.println("Printing "+i*n);
		}
	}
}