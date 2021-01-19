package com.learning.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
public static void main(String[] args) {

	List<Student> stList=new ArrayList<Student>();
	stList.add(new Student("Sachin", 15));
	stList.add(new Student("Rahul", 12));
	stList.add(new Student("Timon", 20));
	
	System.out.println("Student names in Ascending order - Old way");
	Collections.sort(stList, new StudentNameComparator());
	System.out.println(stList);
	
	System.out.println("Student Roll No in Descending order -Old way");
	Collections.sort(stList,new RollNoComparator().reversed());
	System.out.println(stList);
	
	System.out.println("Student names in Ascending order - New way");
	stList.sort((o1,o2)->o1.name.compareTo(o2.name));
	System.out.println(stList);
	System.out.println("Student Roll No in Descending order -New way");
	stList.sort((o1,o2)->o2.rollNo-o1.rollNo);
	System.out.println(stList);
}
}

class Student{
	String name;
     int rollNo;
	public Student(String name,int rollNo)
	{
		this.name=name;
		this.rollNo=rollNo;
	}
	
	@Override
	public String toString()
	{
		return name+" "+rollNo;
	}
}

class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.name.compareTo(o2.name);
	}
	
}

class RollNoComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.rollNo-o2.rollNo;
	}
	
}