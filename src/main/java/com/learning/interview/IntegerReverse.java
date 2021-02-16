package com.learning.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerReverse {
public static void main(String[] args) {
	int i=3451230;
	StringBuilder s=new StringBuilder(String.valueOf(i));
	System.out.println(Integer.parseInt(s.reverse().toString()));
	
	String[] cArr=String.valueOf(i).split("");
	System.out.println("CArr==>"+cArr);
	
	Arrays.asList(cArr).stream()
			.collect(LinkedList::new,(x,y)->x.add(0,y),LinkedList::add).forEach(d->{
				System.out.println("number===>"+d);
			});
	
	String v=Arrays.asList(cArr).stream()
	.collect(LinkedList::new,(x,y)->x.add(0,y),LinkedList::add)
	.stream().map(String::valueOf).collect(Collectors.joining());
	System.out.println("reversed integer String===>"+v);
	//System.out.println(s1);
			
			   Integer valueInteger = 244890;
			   //collect =>
		        String hello = Stream.of((valueInteger.toString()).split(""))
		                .collect(StringBuffer::new, (x, y) -> x.insert(0, y), StringBuffer::append).toString();
		        System.out.println(hello);
		        
		       // collect- supplier,BiConsumer,BiConsumer
		        String hello1 = Stream.of((valueInteger.toString()).split(""))
		                .collect(StringBuffer::new, (x, y) -> x.insert(0, y), (x,y)->x.append(y)).toString();
		        
		        System.out.println("hello1==>"+hello1);
		        
		        int[] intArr = {2, 1, 5, 3,6};
		        
		        IntStream.of(intArr).collect(ArrayList::new,(x,y)->x.add(0,y),ArrayList::add)
		        .stream().forEach(System.out::println);
		        
		        IntStream.rangeClosed(0, 10).forEach(System.out::println);
		        
		        System.out.println("Is prime===>"+isPrime(10));
		        
		       List<Integer> filteredArr= IntStream.of(intArr).filter(n->!isPrime(n)).boxed().collect(Collectors.toList());
		       System.out.println("Filtered Array===>"+filteredArr);
}

	public static boolean isPrime(int n)
	{
		if(n==1)
			return false;
		if(n==2)
			return true;
		return IntStream.rangeClosed(2,n/2 ).noneMatch(i->n%i==0);
	}
}
