package com.learning.multithreading;

public class ThreadMethods {

	public static void main(String[] args) {
		T3 t1=new T3();
		T3 t2=new T3();
		T3 t3=new T3();
		t1.start();
		System.out.println("get thread name by getName() property ->"+t1.getName());
		t2.start();
		t3.start();
		
		//setting thread name
		t1.setName("NidishThread1");
		t2.setName("NidishThread2");
		t3.setName("NidishThread3");
		System.out.println("name ="+t1.getName()+" id ="+t1.getId()+" priority="+t1.getPriority());
		System.out.println("name ="+t2.getName()+" id ="+t2.getId()+" priority="+t2.getPriority());
		System.out.println("name ="+t3.getName()+" id ="+t3.getId()+" priority="+t3.getPriority());
		
		//Name thread using constructor
		T3 t4=new T3("NidishThread4");
		t4.setPriority(2);
		System.out.println("name ="+t4.getName()+" id ="+t4.getId()+" priority="+t4.getPriority());
		
	}
}

class T3 extends Thread{
	 public T3() {
		
	}
	 
	 public T3(String name)
	 {
		 super(name);
	 }
	@Override
	public void run()
	{
		System.out.println("Current executing thread ="+Thread.currentThread().getName());
	}
}