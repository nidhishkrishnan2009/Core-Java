package com.learning.string;

public class StringCompareTest {
public static void main(String[] args) {
	String s1="Nidish";
	String s2="Raj";
	String s3=new String("Nidish");
	
	System.out.println(s1.equals(s3));
	System.out.println(s1==s3);
	System.out.println(s1.compareTo(s2));
	System.out.println(s1.compareTo(s3));
}
}
