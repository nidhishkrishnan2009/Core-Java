package com.learning.multithreading.synchronization;

import com.learning.multithreading.Constants;

/**
 * 
 * @author Krishnan
 *Synchronized block is used to synchronize part of code inside a method. Suppose if you have
 *50 lines of code inside a method void print() if you want to synchronize only 5 lines of code then
 *we can use synchronized block. 
 *
 *- Synchronized block objects for a specific resource
 *- synchronized has smaller scope than method
 */
public class SynchronizedBlockExample {

	public static void main(String[] args) {
		final Task1 t=new Task1();
		Thread t1=new Thread() {
			@Override
			public void run() {
				t.print(5);
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				t.print(100);
			}
		};
		t1.start();
		t2.start();
	}
}

class Task1{
	
	void print(int n) {
		synchronized (this) {
			for(int i=0;i<5;i++)
			{
				System.out.println(i*n);
			}
		}
		
		Constants.CHAR_LIST.stream().forEach(d->{
			System.out.println(d+""+n);
		});
	}
}