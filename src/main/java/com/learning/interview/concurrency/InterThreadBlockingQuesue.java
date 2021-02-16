package com.learning.interview.concurrency;

import java.util.ArrayList;
import java.util.List;

public class InterThreadBlockingQuesue {
	static BlockingQueue<Integer> blockingQueue=new BlockingQueue();
	public static void main(String[] args) throws InterruptedException {
		Thread producer1=new Thread() {
			@Override
			public void run()
			{
				for(int i=1;i<6;i++)
				{
					try {
						blockingQueue.put(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		producer1.start();
		
		Thread consumer1=new Thread() {
			@Override
			public void run()
			{
				for(int i=1;i<10;i++)
				{
					try {
						blockingQueue.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		consumer1.start();
		
		Thread producer2=new Thread() {
			@Override
			public void run() {
				for(int i=6;i<12;i++)
				{
					try {
						blockingQueue.put(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread.sleep(1000);
		producer2.start();
	}
	
}

class BlockingQueue<T>{
	List<T> queue=new ArrayList<>();
	private static final int LIMIT=5;
	public synchronized void put(T t) throws InterruptedException {
		while(queue.size()==LIMIT)
		{
			wait();
		}
			
		
		if(queue.isEmpty())
		{
			notify();
		}
		
		queue.add(t);
		System.out.println("Producer adds "+t);
	}
	
	public synchronized void take() throws InterruptedException {
		while(queue.isEmpty())
		{
			wait();
		}
			
		if(queue.size()==LIMIT)
			notifyAll();
		T t=queue.remove(0);
		System.out.println("Consumer consumes "+t);
	}
}