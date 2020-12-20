package com.learning.oops;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorExample {
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Class conClass=Class.forName("com.learning.oops.Student1");
	Constructor[] conArray=conClass.getConstructors();
	Arrays.stream(conArray).forEach(cons->{
		System.out.println(cons.getName());
	});
	
	// Instantiating object from Constructor
	Constructor constructor=Student1.class.getConstructor(String.class,Integer.class);
	Student1 st=(Student1) constructor.newInstance("NaijaNidish",28);
	System.out.println(st.name+ " "+st.age);
}
}

class Student1{
	String name;
	Integer age;
	public Student1(String name,Integer age)
	{
		this.name=name;
		this.age=age;
	}
	
}