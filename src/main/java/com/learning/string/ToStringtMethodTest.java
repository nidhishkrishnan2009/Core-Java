package com.learning.string;

public class ToStringtMethodTest {
public static void main(String[] args) {
	Student s1=new Student("Abhi", 10);
	Employee e1=new Employee(747433, "Nidish");
	System.out.println(s1);
	System.out.println(e1);
}
}

class Student{
	private String name;
	private int rollNo;
	public Student(String name,int rollNo)
	{
		this.name=name;
		this.rollNo=rollNo;
	}
	
}

class Employee{
	private int empId;
	private String empName;
	public Employee(int empId,String empName)
	{
		this.empId=empId;
		this.empName=empName;
	}
	
	
  public String toString() {
		return empId + " "+empName; 
	}
}