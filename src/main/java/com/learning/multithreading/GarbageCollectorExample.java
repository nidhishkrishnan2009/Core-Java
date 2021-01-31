package com.learning.multithreading;

import com.learning.exceptionhandling.FinalFinalizefinally;

/**
 * 
 * @author Krishnan
 * Garbage collector will remove unreferenced objects from the heap memory and thus helps in efficient 
 * management of memory. JVM calls aGarbage collector automatically. Garbage collector will collect 
 * only those unreferenced objects created using new keyword. Other objects should be removed
 * as part of clean up operation under finalize method.  
 */
public class GarbageCollectorExample {

	public static void main(String[] args) throws InterruptedException {

		// JVM treats object be unreferenced and eligible for garbage collection based on 3 situation mentioned below.
		Employee e1=new Employee();
		System.out.println("reference for e1 ="+e1.toString());
		Employee e2=new Employee();
		System.out.println("reference for e2 ="+e2.toString());
		//one method copying the reference of one object to another. Here object of e1 will be unreferenced and garbage collected.
		e1=e2;
		Employee e3=new Employee();
		System.out.println("reference of e3 ="+e3.toString());
		//by nullify the object reference so taht its actual object will be ungreferenced and thus garbage collected
		e3=null;
		//anonymous objects , object with no reference variable are alson garbage collected.
		new Employee();
		System.gc();
		Thread.sleep(2000);
	}
}

class Employee{
	@Override
	public void finalize() {
		System.out.println("Garbage collector invoked"+this.toString());
	}
}
