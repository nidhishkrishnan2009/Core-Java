package com.learning.multithreading;

/**
 * 
 * @author Krishnan
 *Each thread starts with new call stack. When we call run method directly the call will go into main thread call stack.
 *Hence thread objects are considered as normal java objects rather than thread objects thus no context switching between threads
 *will happen which means no parallel execution of threads 
 */
public class RunMethodDirectly {

	public static void main(String[] args) {
		T1 t1=new T1();
		T1 t2=new T1();
		t1.run();
		t2.run();
	}
}

class T1 extends Thread{
	
	@Override
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
		}
	}
}