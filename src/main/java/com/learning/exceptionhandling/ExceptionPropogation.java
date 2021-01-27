package com.learning.exceptionhandling;

import java.io.IOException;

/**
 * 
 * @author Krishnan
 * When an exception is occured and it is not handled , it will drop down to its very next calling method in the call trace 
 * and if it is not handled there as well it will be propagated to next calling method in the call trace and so on
 */
public class ExceptionPropogation {

	
	public static void main(String[] args) {
		try {
			m();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		try {
			checkEligiblityCaller(16);
		} catch (ArithmeticException e) {
			System.out.println("Inside confirm unchecked exceptions are not propogated");
			System.out.println(e.getMessage());
		}
	}
	
	static void m()
	{
	  n();	
	}
	
	static void n()
	{
		int i=50/0;
	}
	
	// checked exceptions are not propogated
	
	static void o()
	{
		
	}
	
	static void p(String fileName)
	{
		String[] fileNameSplit=fileName.split(".");

		// When tried to propagate checked exception , we will get compile time error.
		
//		if(!fileNameSplit[fileName.length()-1].equals("txt"))
//			throw new IOException("Invalid file");
			
		
	}
	
	static void checkEligiblityCaller(int age)
	{
		checkEligiblity(age);
	}
	
	//Arithmetic exception is unchecked exception so it is prpagated.
	static void checkEligiblity(int age){
		if(age<18)
			throw new ArithmeticException("Not Eligible for voting");
	}
}
