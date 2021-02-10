package com.learning.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * 
 * @author Krishnan
 *The BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments.
 */
public class SimpleBinaryOperator {

	public static void main(String[] args) {
		BinaryOperator<Integer> addition=(a,b)->a+b;
		int addResult=addition.apply(3, 3);
		System.out.println("Addition result ====>"+addResult);
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,3);
		int listSumResult=computeListSum(Integer::sum, list, 0);
		System.out.println("listSumResult====>"+listSumResult);
	}
	
	public static <T> T computeListSum(BinaryOperator<T> func,List<T> list,T init)
	{
		T result=init;
		for(T d:list)
		{
			result=func.apply(result, d);
		}
		
		// Using reduce function
		T result1=init;
		result1=list.stream().reduce(result1, func);
		
		return result1;
	}
}
