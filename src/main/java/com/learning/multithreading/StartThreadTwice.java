package com.learning.multithreading;

/**
 * 
 * @author Krishnan
 * We cannot start a thread twice if we start a thread second time IllegalThreadStateException  is thrown.
 */
public class StartThreadTwice {

	public static void main(String[] args) {
		Thread t1=new Thread() {
			@Override
			public void run() {
				System.out.println("testing starting a thread twice");
			}
		};
		
		t1.start();
		t1.start();
	}
}
