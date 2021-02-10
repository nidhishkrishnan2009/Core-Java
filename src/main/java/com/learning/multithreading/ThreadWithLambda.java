package com.learning.multithreading;

public class ThreadWithLambda {
/**
 * Runnable interface is a functional interface so it can be passed as lambda expression.
 *
 */
	
	public static void main(String[] args) {
		Thread t1=new Thread(()->System.out.println("Starting thread "+Thread.currentThread().getName() +""
				+ " using lambda expression"),"lambda thread");
		t1.start();
	}
}
