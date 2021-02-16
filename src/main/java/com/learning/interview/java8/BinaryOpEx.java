package com.learning.interview.java8;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryOpEx {
	public static void main(String[] args) {
		 int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 IntBinaryOperator i=Integer::sum;
		 System.out.println(i.applyAsInt(5, 5));;
		 Integer s=Arrays.stream(numbers).reduce(0, (a,b)->a+b);
		 System.out.println(s);
		 Stream<int[]> stream=Stream.of(numbers);
		 stream.flatMapToInt(d->Arrays.stream(d)).forEach(System.out::println);
		 IntStream.of(numbers).forEach(System.out::println);
		 double x=IntStream.of(numbers).average().getAsDouble();
		 System.out.println(x);
		 double y= Stream.iterate(10, n->n+1).limit(30).mapToInt(n->n*2).average().getAsDouble();
		 Predicate<Integer> p=a->a<10;
		 UnaryOperator<Integer> u=n->n+1;
		 System.out.println("Prime numbers are: ");
		 Stream.iterate(0, p, u).forEach(System.out::println);
	}
}
