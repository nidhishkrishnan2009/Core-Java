package com.learning.reactive.programming;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class Combining2Streams {
	public static void main(String[] args) {
		combiningStreams();
	}
	
	public static void combiningStreams() {
		List<String> elements=new ArrayList<>();
		Flux.just(1,2,3,4)
			.log()
			.map(i->i*2)
			.zipWith(Flux.range(1, Integer.MAX_VALUE),(one,two)->{
				return String.format("first flux is %d : second flux is %d", one,two);
			}).subscribe(elements::add);
			System.out.println(elements);
	}
}
