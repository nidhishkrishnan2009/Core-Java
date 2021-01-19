package com.learning.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
}
}
