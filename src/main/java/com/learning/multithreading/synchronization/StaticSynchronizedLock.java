package com.learning.multithreading.synchronization;

/**
 * 
 * @author Krishnan
 *Suppose if we have synchronization for a method using either synchronized block or synchronized method. Consider we have 
 *2 objects (i.e) obj1 & obj2 for the same class and consider t1,t2,t3,t4 are 4 threads where t1 & t2 are acting upon obj1
 * while t3 & t4 are acting upon obj2. In this situation synchronized block or synchronized method guarantees there will be
 * no interference between t1 & t2 or t3 & t4 but it doesn't guarantee there will no interference between t1 & t4 or t2 & t3
 * so on. For solving this situation we have StaticSynchronizedblock. 
 * In StaticSynchronizedBlock lock is for the class not for the object.
 */
public class StaticSynchronizedLock {
	public static void main(String[] args) {
		
		Thread t1=new Thread() {
			@Override
			public void run() {
				Task2.print(1);
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				Task2.print(10);
			}
		};
		
		Thread t3=new Thread() {
			@Override
			public void run() {
				Task2.print(100);
			}
		};
		
		Thread t4=new Thread() {
			@Override
			public void run() {
				Task2.print(1000);
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Task2{
	synchronized static void print(int n)
	{
		for(int i=1;i<6;i++)
		{
			System.out.println(i*n);
		}
	}
}