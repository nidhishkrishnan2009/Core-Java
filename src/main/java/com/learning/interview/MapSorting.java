package com.learning.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;



/**
 * 
 * @author Krishnan
 *
 * Retrieve key in ascending order 
 */
public class MapSorting {
public static void main(String[] args) {
	TreeMap<String, String> m=new TreeMap();
	m.put("a", "Apple");
	m.put("b", "Bajaj");
	m.put("d", "Deloitte");
	m.put("c", "CISCO");
	
	
	Scanner sc=new java.util.Scanner(System.in);
	System.out.println("Enter input");
	List<String> s1=new ArrayList<String>(List.of(sc.next().split(",")));
	m.forEach((k,v)->{
		if(s1.contains(k))
			System.out.println(v);
	});
	
}
}