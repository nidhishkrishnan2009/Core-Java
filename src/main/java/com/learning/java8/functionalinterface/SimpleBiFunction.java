package com.learning.java8.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SimpleBiFunction {

	public static void main(String[] args) {
		// chain Bifunction with function
		BiFunction<Integer,Integer, Double> mathPow=(a,b)->Math.pow(a, b);
		Function<Double, Integer> multiplyResult=a->a.intValue()*3;
		int result=mathPow.andThen(multiplyResult).apply(2, 3);
		System.out.println(result);
	}
}

