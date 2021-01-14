package com.learning.oops;

public class StrictFPTest {

	public strictfp void test()
	{
		double a=1.5;
		double b=2.5;
		double result=a+b;
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		StrictFPTest s=new StrictFPTest();
		s.test();
	}
}
