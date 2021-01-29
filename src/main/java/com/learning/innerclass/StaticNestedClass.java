package com.learning.innerclass;

public class StaticNestedClass {

	public static void main(String[] args) {
		StaticNestedOuterClass.staticNestedInnerClass inn=new StaticNestedOuterClass.staticNestedInnerClass();
		inn.test1();

	}
}

/**
 * 
 * @author Krishnan
 *Only condition for static class is it cannot access non static outer class variable. But it can access 
 *non-static methods.  
 */
class StaticNestedOuterClass{
	private static int d1=12;
	int d2=14;
	private int d3=16;
	
	static void staticOuterClass()
	{
		System.out.println("Testing static outer class");
	}
	
	static void nonStaticOuterClass()
	{
		System.out.println("Testing non-static outer class");
	}
	
	static class staticNestedInnerClass{
		private int i1=14;
		private static int i2=15;
		 void test1() {
			System.out.println("Testing non-static method ");
			System.out.println(i1);
			System.out.println(i2);
			System.out.println(d1);
			//outer class  variable members should be static
			//System.out.println(d2);
			//System.out.println(d3);
			staticOuterClass();
			nonStaticOuterClass();
			test2();
			test3();
		}
		 
		 void test3() {
			 
		 }
		
		static void test2() {
			
			System.out.println("Testing static method");
			//Compile time error since static class data members should be static inorder to access.
			//System.out.println(i1);
			System.out.println(i2);
			System.out.println(d1);
			//outer class members should be static
			//System.out.println(d2);
			//System.out.println(d3);
			
		}
	}
}