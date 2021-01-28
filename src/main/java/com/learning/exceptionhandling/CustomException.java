package com.learning.exceptionhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CustomException {

	public static void main(String[] args) {
		try {
			checkAgeValidity(16);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			checkFileExtension();
		} catch (InvalidFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
   static void checkAgeValidity(int age) throws InvalidAgeException
	{
	   if(age<18){
			throw new InvalidAgeException("Not valid age");
		}
	}
   
   static void checkFileExtension() throws InvalidFileException  {
	   try {
		FileInputStream in=new FileInputStream("noFile");
	} catch (FileNotFoundException e) {
		throw new InvalidFileException("File Not Found!", e);
	}
   }
}

class InvalidAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731987251532047014L;

	public InvalidAgeException(String s)
	{
		super(s);
	}
}

class InvalidFileException extends Exception{
	
	public InvalidFileException(String msg,Throwable ex) {
		super(msg, ex);
	}
}