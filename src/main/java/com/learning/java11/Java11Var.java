package com.learning.java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Java11Var {
	public static void main(String[] args) {
		List<String> list=Arrays.asList("a","b","c",null);
		String s=list.stream().filter(Objects::nonNull).map(( var a)->a.toUpperCase()).collect(Collectors.joining());
		List<String> s3=list.stream().collect(Collectors.toCollection(ArrayList::new));
		s3.add("d");
		System.out.println("s3==>"+s3);
		System.out.println(s);
		Set<String> s2=Set.of("a","b");
		List<String> s4=s2.stream().collect(Collectors.toUnmodifiableList());
		s4.add("c");
		System.out.println("s4===>"+s4);
		s2.stream().map(String::toUpperCase).forEach(System.out::println);
		s2.removeIf(a->a.equals("a"));
		System.out.println(s2);
		s2.add("c");
	}
}
