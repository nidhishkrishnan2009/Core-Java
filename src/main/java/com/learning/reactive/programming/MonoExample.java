package com.learning.reactive.programming;

import java.util.List;
import java.util.function.Function;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoExample {
	private static final List<Integer> list=List.of(1,2,3,4,5);
	public static void main(String[] args) {
		//simpleMono();
		//flatMapMany();
		//flatMapIterable();
		flatMapExample();
	}
	
	public static void simpleMono() {
		Mono<String> data = Mono.just("hello");
		data.doOnNext(d -> {
			d = d + "world";
		}).subscribe(System.out::println);
	}
	
	public static void flatMapMany() {
		Mono.just(list)
			.flatMapMany(Flux::fromIterable)
			.subscribe(System.out::println);
	}
	
	public static void flatMapIterable() {
		Mono.just(list)
			.flatMapIterable(d->d)
			.subscribe(System.out::println);
	}
	
	public static void flatMapExample() {

		Function<String, Publisher<String>> mapper = s -> Flux.just(s.toUpperCase().split(""));
		Flux<String> inFlux = Flux.just("Nidish.com");
		inFlux.flatMap(mapper).subscribe(System.out::println);

	}

}
