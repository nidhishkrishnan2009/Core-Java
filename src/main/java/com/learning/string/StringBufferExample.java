package com.learning.string;

public class StringBufferExample {
public static void main(String[] args) {
	StringBuffer s1=new StringBuffer();
	StringBuffer s2=new StringBuffer("Dravid");
	s1.append("Rah");
	s1.insert(3, "ul");
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s1.append(s2));
	System.out.println(s1.capacity());
	System.out.println(s2.capacity());
	System.out.println(s1.charAt(2));
	System.out.println(s1.substring(5));
	System.out.println(s1.substring(0, 5));
	System.out.println(s1.delete(5,s1.length()));
	System.out.println(s1.reverse());
	System.out.println(s1.capacity());
	s1.ensureCapacity(50);
	System.out.println(s1.capacity());
}
}
