package com.learning.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
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

	}
}

class FilterEvenNumber implements BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> t, Predicate<Integer> u) {
		return t.stream().filter(u).collect(Collectors.toList());
	}

}