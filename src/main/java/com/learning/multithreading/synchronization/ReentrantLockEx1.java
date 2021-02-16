package com.learning.multithreading.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockEx1 {
	public static void main(String[] args) {
		final ReentrantLock r=new ReentrantLock();
		Runnable worker1=new R1(r, "job1");
		Runnable worker2=new R1(r,"job2");
		Runnable worker3=new R1(r, "job3");
		ExecutorService executor=Executors.newFixedThreadPool(5);
		executor.execute(worker1);
		executor.execute(worker2);
		executor.execute(worker3);
	}
}

class R1 implements Runnable{

	private ReentrantLock r;
	private String name;
	public R1(ReentrantLock r,String name)
	{
		this.r=r;
		this.name=name;
	}
	@Override
	public void run() {
			
			//boolean isLocked=r.tryLock();
			r.lock();
			if(r.isLocked())
			{
				try {
					Thread.sleep(1500);
					System.out.println("Task name "+name+" has acquired outerlocked");
					try {
						r.lock();
						System.out.println("Task name "+name+" has acquired inner lock");
						Thread.sleep(1500);
					} finally {
						r.unlock();
						System.out.println("Task name "+name+" has released inner lock");
					}
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally {
					r.unlock();
					System.out.println("Task name "+name+" has released outerlocked");
				}
			}
	//	}
		
	}
	
}