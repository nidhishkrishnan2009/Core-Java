package com.learning.java8.functionalinterface;

import java.util.function.Function;

public class SimpleFunction {

	public static void main(String[] args) {
		Function<String, Integer> findStrLen=s->s.length();
		System.out.println(findStrLen.apply("Naija"));
		
		//Chaining Function
		
		Function<Integer, Integer> multiplyLength=i->i*3;
		
		int l=findStrLen.andThen(multiplyLength).apply("Nidish");
		System.out.println("multiplyLength===>"+l);
	}
}
