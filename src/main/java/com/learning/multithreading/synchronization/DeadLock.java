package com.learning.multithreading.synchronization;

/**
 * 
 * @author Krishnan Deadlock is a situation in which one thread1 acquires lock
 *         on an object for resource and waits for lock on another resource to
 *         complete while thread2 acquires the lock which thread1 is waiting and
 *         waits for lock on the resource which thread1 is holding in order to
 *         complete execution.
 */

public class DeadLock {
	public static void main(String[] args) {
		final Task3 task = new Task3();
		final String resource1 = task.name1;
		final String resource2 = task.name2;
		Thread t1 = new Thread() {
			@Override
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1 is acting upon " + resource1);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (resource2) {
						System.out.println("Thread 1 is acting upon " + resource2);
					}
				}
			}		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2 is acting upon " + resource2);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (resource1) {
						System.out.println("Thread 2 is acting upon " + resource1);
					}

				}
			}
		};

		t1.start();
		t2.start();
	}
}

class Task3 {
	String name1 = "Naija";
	String name2 = "Nidish";
}