package com.learning.string;

public class IsEmptyIsBlank {

	public static void main(String[] args) {
		String s1="";
		String s2=" ";
		System.out.println("Testing is Empty");
		System.out.println(s1.isEmpty());
		System.out.println(s2.isEmpty());
		System.out.println("Testing is Blank");
		System.out.println(s1.isBlank());
		System.out.println(s2.isBlank());
	}
}
