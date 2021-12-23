package com.learning.reactive.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class Basic {
	private static List<Integer> arrayList=Arrays.asList(1);
	public static void main(String[] args) {
		fluxImplementation();
		
	}
	
	public static void simpleFlux() {
		List<Integer> elements=new ArrayList<>();
		Flux.just(1,2,3,4,5,6)
			.subscribe(elements::add);
	}
	
	public static void fluxImplementation() {
		List<Integer> elements=new ArrayList<>();
		Flux.just(1,2,3,4,5,6)
			.log()
			.subscribe(new Subscriber<Integer>() {
				private Subscription s;
				int onNextAmount;
				@Override
				public void onSubscribe(Subscription s) {
					this.s=s;
					s.request(2);				
				}

				@Override
				public void onNext(Integer t) {
					elements.add(1);
					onNextAmount++;
					if(onNextAmount%2==0)
						s.request(2);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}
				
			});
	}
}
