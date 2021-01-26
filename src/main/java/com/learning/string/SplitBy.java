package com.learning.string;

import java.util.Arrays;

public class SplitBy {

	public static void main(String[] args) {
		  String s1="Hello how are you";
		    String[] s2=s1.split(" ");
		    Arrays.stream(s2).forEach(d->System.out.println(d));
		    
		    System.out.println("By passing regex");
		    String[] s3=s1.split("\\s");
		    Arrays.stream(s3).forEach(System.out::println);
		    
		    System.out.println("with only 1 split");
		    String[] s4=s1.split("\\s",1);
		    Arrays.stream(s4).forEach(System.out::println);
		    
		    System.out.println("with only 2 split");
		    String[] s5=s1.split("\\s",2);
		    Arrays.stream(s5).forEach(System.out::println);
	}
}
