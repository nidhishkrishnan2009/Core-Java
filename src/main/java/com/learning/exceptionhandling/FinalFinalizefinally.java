package com.learning.exceptionhandling;

public class FinalFinalizefinally {

	@Override
	public void finalize()
	{
		System.out.println("Finalize method is called");
	}
	
	public static void main(String[] args) throws InterruptedException {
		FinalFinalizefinally f1=new FinalFinalizefinally();
		f1=null;
		//Finalize method is called just before JVM executes garbage collector
		System.gc();
		Thread.sleep(1000);
		final String i="k";
		//compile time error since final variable cannot be reassigned
		//i="n";
		try
		{
			
		}
		finally {
			System.out.println("finally block is executed");
		}
				
	}
}
