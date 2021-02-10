package com.learning.interview.concurrency;

public class ThreadEx1 {

	public static void main(String[] args) {
		DeadLock d=new DeadLock();
		String resource1=d.s1;
		String resource2=d.s2;
		Thread deadlockT1=new Thread() {
			@Override
			public void run() {
				synchronized (resource1) {
					System.out.println("deadlockT1 acting on"+resource1);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

					synchronized (resource2) {
						System.out.println("deadlockT1 acting on "+resource2);
					}
				}
				
			}
		};
		
		Thread deadLockT2=new Thread() {
			@Override
			public void run()
			{
				synchronized (resource2) {
					System.out.println("deadLockT2 acting on "+resource2);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (resource1) {
						System.out.println("deadLockT2 acting on "+resource1);
					}
				}
				
		
			}
		};
		
		deadlockT1.start();
		deadLockT2.start();
	}
}


class DeadLock{
	String s1="Nidish";
	String s2="Naija";
	
}
