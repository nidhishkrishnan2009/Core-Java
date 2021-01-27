package com.learning.exceptionhandling;

public class ThrowKeyword {
	public static void main(String[] args) {
	    try {
			checkEligiblityForVoting(16);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	    System.out.println("Rest of the code");
	}
	
	public static boolean checkEligiblityForVoting(int age) throws ArithmeticException
	{
		boolean isEligible=false;
		if(age<18)
			throw new ArithmeticException("Not eligible for voting");
		return isEligible;
	}
}
