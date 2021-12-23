package com.learning.reactive.programming;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BasicConcurrency {
	public static void main(String[] args) {
		concurrency();
	}
	
	public static void concurrency() {
		List<Integer> elements=new ArrayList<>();
//		Flux.just(1,2,3,4)
//			.log()
//			.map(i->i*2)
//			.subscribeOn(Schedulers.parallel())
//			.subscribe(e->{
//				elements.add(e);
//			});
		
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .subscribeOn(Schedulers.parallel())
		  .subscribe(elements::add);
	}

}
