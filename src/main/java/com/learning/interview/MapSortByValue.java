package com.learning.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSortByValue {
public static void main(String[] args) {
	Map<String, String> m=new HashMap<String, String>();
	m.put("a", "Apple");
	m.put("d", "Donkey");
	m.put("c", "Cat");
	
	// In Ascending order
	System.out.println("Printing in Ascending order of values");
	m.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(d->{
		System.out.println(d.getKey());
		System.out.println(d.getValue());
	});
	
	//In Descending order
	System.out.println("Printing in Descending order of values");
	m.entrySet().stream()
	.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	.forEachOrdered(d->{
		System.out.println(d.getKey());
		System.out.println(d.getValue());
	});
	
	Map<String, String> reverseMap=m.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
									.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n)->n,LinkedHashMap::new));
	System.out.println(reverseMap);
	
	List<String> items =
            Arrays.asList("apple", "apple", "banana",
                    "apple", "orange", "banana", "papaya");
	
	Map<String, Long> m1=items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(m1);
	
	String[] sArr= {"Sachin Tendulkar","Ramesh Tendulkar","Rahul Dravid","Rahul","Sachin Ramesh Tendulkar"};
	
	Map<String, Long> sMap= Stream.of(sArr).map(s->s.split(" "))
					.filter(s->s.length>1)
					.map(s->s[s.length-1])
					.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
					.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n)->n,LinkedHashMap::new));
	
	//collectingandThen - Collectors,Function
	HashMap<String, Long> nMAp=Stream.of(sArr).map(s->s.split(" ")).map(s->s[s.length-1])
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream().sorted(Map.Entry.comparingByValue())
			.collect(Collectors.collectingAndThen(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
					, HashMap::new));
								
	System.out.println("nMap==>"+nMAp);
	System.out.println(sMap);
}
}
