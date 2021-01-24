package com.learning.string;

public class LastIndex {

	public static void main(String[] args) {
		String s1="Rahul dravid";
		System.out.println(s1.lastIndexOf("d"));
		System.out.println(s1.lastIndexOf("d", 7));
		System.out.println(s1.lastIndexOf("d", s1.length()-1));
		System.out.println(s1.lastIndexOf("dravid"));
       
	}
}
