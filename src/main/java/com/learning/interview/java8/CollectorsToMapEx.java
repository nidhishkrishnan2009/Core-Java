package com.learning.interview.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToMapEx {
	public static void main(String[] args) {
		List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
		String s =listWithDuplicates.stream().collect(StringBuilder::new,(x,y)->x.append(y),StringBuilder::append).toString();
		try {
			Map<String, Integer> m2=listWithDuplicates.stream().collect(Collectors.toMap(d->d, String::length));
		} catch (IllegalStateException e) {
			System.out.println("Exception is handled "+e.getMessage());
		}
		//toMap => keyMapper(Function),ValueMapper(Function),merge(BinaryOPerator)
		Map<String, Integer> m3=listWithDuplicates.stream().collect(Collectors.toMap(d->d, String::length,(f,l)->f));
		m3.put("c", 1);
		System.out.println(m3);
		
		
		//collectingAndThen
		
		ArrayList<String> cnT=listWithDuplicates.stream()
				.collect(Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), d->{
					ArrayList<String> list=new ArrayList<>(d);
					list.add("Nidish");
					return list;
				}));
		
		System.out.println("cnT==>"+cnT);
		
		//Summarizing double
		DoubleSummaryStatistics d=listWithDuplicates.stream().collect(Collectors.summarizingDouble(String::length));
		System.out.println(d.toString());
		
		int sum= listWithDuplicates.stream().collect(Collectors.summingInt(str->str.length()));
		System.out.println("sum==>"+sum);
		
		//partitionBy- it takes predicate as argument,returns a map with key as boolean and value as List
		
		Map<Boolean, List<String>> partitioning=listWithDuplicates.stream().collect(Collectors.partitioningBy(p->p.length()>1));
		
		System.out.println("Partitioning==>"+partitioning);
		
		List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
		
		ExecutorService executors=Executors.newWorkStealingPool();
	}
}
