package com.learning.interview;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
	
	public static void main(String[] args) {
		List<String> list=Arrays.asList("apple","banana","orange");
		TestEx1 t=new TestEx1();
	//	Map<String, Integer> result=compute(t::getLength, list);
	//	System.out.println(result);
		//Map<String, Integer> filterMapByLength=filterbyLength(t::filterbyLength, result, 5);
	//	System.out.println("filterMapByLength===>"+filterMapByLength);
	}

	public static <A1,I,K> Map<K, I> compute(Function<K, I> func,List<K> list)
	{
	
		return list.stream().collect(Collectors.toMap(d->d, d->func.apply(d)));
		
	}
	
	public static <K,I> Map<K, Integer> filterbyLength(BiFunction<Integer,Integer, Boolean> func,
			Map<K, Integer> input,int limit)
	{
		return input.entrySet().stream().filter(d->func.apply(d.getValue(), limit))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
	}
}

class Test{
	public int getLength(String s)
	{
		return s.length();
	}
	
	public boolean filterbyLength(int size , int limit)
	{
		return size>limit;
	}
}