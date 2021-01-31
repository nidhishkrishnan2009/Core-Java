package com.learning.multithreading;

public class ThreadPriority {
	public static void main(String[] args) {
	//3 Types of thread priority. Thread.MIN_PRIORITY,Thread.NORM_PRIORITY,Thread.MAX_PRIORITY.
		T3 t1=new T3();
		T3 t2=new T3();
		T3 t3=new T3();
	
		//changing the thread priorities
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("name ="+t1.getName()+" id ="+t1.getId()+" priority="+t1.getPriority());
		System.out.println("name ="+t2.getName()+" id ="+t2.getId()+" priority="+t2.getPriority());
		System.out.println("name ="+t3.getName()+" id ="+t3.getId()+" priority="+t3.getPriority());
	}
}
