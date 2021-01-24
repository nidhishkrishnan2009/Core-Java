package com.learning.oops;

public class InstanceInitializerExample {
	public static void main(String[] args) {
		IIB i=new IIB();
		System.out.println(i.i);
		System.out.println(i.j);
	}
	
}

class IIB{
	int i;
	int j;
	{
		System.out.println("Inside instance initializer block");
		i=5;
		j=10;
	}
}
