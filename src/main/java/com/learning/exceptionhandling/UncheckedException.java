package com.learning.exceptionhandling;



public class UncheckedException {

	public static void main(String[] args) {
		// Arithmetic Exception
		try {
			int i=10/0;
			System.out.println("Code after exception");
		} catch (ArithmeticException e) {
			System.out.println("Inside Arithmetic exception");
		}
		
		 
		 int[] arr= new int[5];
		 try {
			 arr[6]=8;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Inside array index out of bound exception");
		}
		 
		 String s="Hello Naija how are you ?";
		 try {
			 System.out.println(s.charAt(6));
			 System.out.println(s.charAt(30));
		 }
		 
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Inside String out of bound exception");
		}
		 
		 
		 finally {
			System.out.println("Finally block is executed");
		}
		 
		 /** FInally block will not be executed 
		  * after System.exit
		  */
		 try {
			 //System.exit(0);
				System.out.println("After system exit");
		} catch (Exception e) {
			// TODO: handle exception
		}
		 finally {
			System.out.println("Finally After System exit");
		}
	}
}
