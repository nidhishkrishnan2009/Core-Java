package com.learning.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuntionalProgrammingExample {

	private static final int THRESHOLD=5;
	public static void main(String[] args) {
		List<Integer> values=new ArrayList<Integer>(List.of(2,6,3,8,1));
		System.out.println("Imperative result = "+Arrays.toString(getGreaterArrayOld(values)));
		System.out.println("Declarative Result");
		System.out.println(Arrays.toString(getGreaterArrayNew(values)));
		System.out.println("Result of pure function = "+pureFuntion());
		System.out.println("Result of impure function = "+impureFunction());
	}
	
	//Imperative approach -old way. says how to do a a problem and in which order
	public static Integer[] getGreaterArrayOld(List<Integer> values)
	{
		List<Integer> greaterArray=new ArrayList<Integer>();

		for(int v:values)
		{
			if(v>THRESHOLD)
			{
				greaterArray.add(v);
			}
				
		}
		
		return greaterArray.toArray(new Integer[greaterArray.size()]);
	}
	
	//Declarative approach-new way which says what to do
	public static Integer[] getGreaterArrayNew(List<Integer> values)
	{
		Predicate<Integer>condition=v->v<THRESHOLD; 
		values.removeIf(condition);
		return values.toArray(new Integer[values.size()]);
	}
	
	//If computation depends on external variable 
	public static float impureFunction()
	{
		float externalVariable=10.2f;
		final Function<Integer, Float> f1=t->t+externalVariable;
		return f1.apply(5);
	}
	
	public static int pureFuntion() {
		BiFunction<Integer, Integer, Integer> f=(a,b)->a+b;
		return f.apply(10, 20);
	}
}
