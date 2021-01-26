package com.learning.interview;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		final PC pc=new PC();
		Thread producerThread=new Thread(){
			@Override
			public void run()
			{
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread consumerThread=new Thread(){
			@Override
			public void run()
			{
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		producerThread.start();
		consumerThread.start();
		producerThread.join();
		consumerThread.join();
	}
}

class PC{
	int capacity=2;
	LinkedList<Integer> list=new LinkedList<Integer>();
	int value=0;
	public void produce() throws InterruptedException {
		while(true)
		{
			synchronized (this) {
				while(list.size()==capacity)
					wait();
				System.out.println("producer produced "+value);
				list.add(value++);
				notify();
				Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException{
		while(true)
		{
			synchronized (this) {
				while(list.size()==0)
					wait();
				System.out.println("Consumer consumed "+list.removeFirst());
				notify();
				Thread.sleep(1000);
			}
		}
	}
}