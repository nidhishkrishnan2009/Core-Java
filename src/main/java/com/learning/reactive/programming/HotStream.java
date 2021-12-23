package com.learning.reactive.programming;

import java.time.Duration;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class HotStream {
	 public static void main(String[] args) {
		hotStream();
	}
	 
	 public static void hotStream() {
		 ConnectableFlux<Object> publish=Flux.create(fluxSink->{
			  while(true) {
				 fluxSink.next(System.currentTimeMillis());
			  }
		 })
		 .sample(Duration.ofSeconds(2))
		 .publish();
		 
		 publish.subscribe(d->{
			 System.out.println(d);
		 });
		 
//		 publish.subscribe(d->{
//			 System.out.println(d);
//		 });
		 publish.connect();
	 }
	 

}
