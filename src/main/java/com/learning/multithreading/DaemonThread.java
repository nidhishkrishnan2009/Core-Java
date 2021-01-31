package com.learning.multithreading;

/**
 * 
 * @author Krishnan
 *  Daemon thread acts as kind of service provider for user threads for doing background tasks.
 *  Its life cycle depends on user threads. when all the user threads are terminated then, 
 *  JVM will automatically terminates Daemon threads.  
 */
public class DaemonThread {

	public static void main(String[] args) {
		T4 t1=new T4();
		T4 t2=new T4();
		t1.setDaemon(true);
		t1.start();
		t2.start();
		
		// If a user thread is set as Daemon thread after calling start() then IllegalThreadSTateException is thrown
		
		T4 t3=new T4();
		t3.start();
		t3.setDaemon(true);
	}
}

class T4 extends Thread{
	public void run()
	{
		if(Thread.currentThread().isDaemon())
			System.out.println("Daeomon thread is running");
		else
			System.out.println("Normal thread is running");
	}
}