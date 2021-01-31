package com.learning.multithreading;

public class ThreadSleep {

	public static void main(String[] args) {
		SleepThread t1=new SleepThread();
		SleepThread t2=new SleepThread();
		t1.start();
		t2.start();
	}
}

class SleepThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}