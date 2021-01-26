package com.learning.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionInterfaceExample {

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		FilterEvenNumber e = new FilterEvenNumber();
		Predicate<Integer> evenPredicate = d -> d % 2 != 0;
		Predicate<Integer> oddPredicate = o -> o%2 == 0;

		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> oddNumber = (t, u) -> {
			return t.stream().filter(u).collect(Collectors.toList());
		};

		System.out.println(e.apply(values, evenPredicate));
		System.out.println(oddNumber.apply(values, oddPredicate));
		
		//Anonymous Inner Class
		Student s=new Student(){

			@Override
			public void test() {
				System.out.println("Testing Anonymous inner class");
				
			}
			
		};
		
		s.test();
		
		Supplier<String> supplier=()->"Hello from Supplier";
		System.out.println(supplier.get());
		Consumer<String> consumer=value->System.out.println(value);
		consumer.accept("Hello from Consumer");
		Function<String, String> f=String::toUpperCase;
		System.out.println(f.apply("Naija"));
	}
}

class FilterEvenNumber implements BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> t, Predicate<Integer> u) {
		return t.stream().filter(u).collect(Collectors.toList());
	}

}

interface Student{
	void test();
}