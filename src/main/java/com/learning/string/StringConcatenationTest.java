package com.learning.string;

public class StringConcatenationTest {
public static void main(String[] args) {
	String s1="Rahul";
	String s2="Dravid";
	String s3=s1+s2;
	System.out.println(s3);
	// + concatenation will be internally converted to below String Builder code by JVM
	System.out.println(new StringBuilder().append(s1).append(s2));
	// Using concat method
	System.out.println(s1.concat(s2));
}
}
