package com.learning.reactive.programming;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;

public class CombiningPublishers {
	private static Flux<Integer> evenNo;
	private static Flux<Integer> oddNo;
	static {
		List<Integer> elements=new ArrayList<>(List.of(1,2,3,4,5));
		evenNo= Flux.fromIterable(elements)
				.filter(i->i%2==0);
			
		oddNo= Flux.fromIterable(elements)
				.filter(i->i%2!=0);
			
	}

	public static void main(String[] args) {
		//concatPublishers();
		//concatWithPublishers();
		combineLatestPublishers();
	
	}
	
	
	public static void concatPublishers() {
	
		   Flux.concat(evenNo,oddNo)
			.subscribe(System.out::println);
		
	}
	
	public static void concatWithPublishers() {
		
		  evenNo.concatWith(oddNo)
			.subscribe(System.out::println);
		
	}
	
	/**
	 * We can see here that the function combineLatestPublishers applied 
	 * the function “a + b” using the latest element 
	 * of evenNumbers (4) and the elements of
	 *  oddNumbers (1,3,5), thus generating the sequence 5,7,9.
	 */
	
	public static void combineLatestPublishers() {
		
		  Flux.combineLatest(evenNo,oddNo, (a,b)->a+b)
			.subscribe(System.out::println);
		
	}
	
	/**
	 * opposed to concat (lazy subscription), the sources are subscribed eagerly.
	   we can see a different outcome of the merge function if we insert a delay between
	    the elements of the Publishers:
	 */
	public static void mergePublishers() {
		
		  Flux.merge(evenNo.delayElements(Duration.ofMillis(0)))
			.subscribe(System.out::println);
		
	}
}
