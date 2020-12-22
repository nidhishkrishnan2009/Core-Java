package com.learning.oops;

public class FinalClass {
public static void main(String[] args) {
	Student2 st=new Student2("NaijaNidish",29);
	st.welcome();
	System.out.println(st.name+" "+st.age);
}
}

final class Student2
{
	String name;
	int age;
	static final String COLLEGE;
	
	static {
		COLLEGE="ITS";
	}
	
	public Student2(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	final void welcome()
	{
		System.out.println("Welcome to College");
	}
}