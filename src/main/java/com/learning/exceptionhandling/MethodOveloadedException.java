package com.learning.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MethodOveloadedException {
	
}

class A{
	void a() throws FileNotFoundException {
		
	}
	
	void b()
	{
		
	}
	
	  void c() {
		  
	  }
	  
	  void d() throws IOException
	  {
		  
	  }
}

class B extends A{
	
	  void a() throws FileNotFoundException {
	  FileOutputStream out=new
	  FileOutputStream("data");
	  }
	  
	  /**
	   * if the parent class method doesn't declare exception then its overridden methods in subclass cannot throws/declare
	   * checked exception but it can declare unchecked exception if needed.
	   */
	  
	/*  void b() throws FileNotFoundException
	  {
		  FileOutputStream out=new
				  FileOutputStream("data");
	  }
	*/ 
	  
	  void c() throws ArithmeticException{
		  
	  }
	  
	  /**
	   * If parent class method declare exception then the child class overridden method can either declare zero exception
	   * or if declaring exception it should be the similar type of parent method or the sub class exception of parent type. 
	   	It must not be the parent class exception of what it is declared in parent class method.
	   */
	  /*void d() throws Exception
	  {
		  
	  }
	  */
	  
	  void d() throws FileNotFoundException{
		  
	  }
}