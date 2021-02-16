package com.learning.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureEx1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		CompletableFuture<String> c1=new CompletableFuture<String>();
		Future<String> f=c1.completedFuture("Nidish");
		System.out.println(f);
		CompletableFuture<String> c2= CompletableFuture.supplyAsync(()->{
			return "Hello";
		}).thenApply(s->{
			return s+" Naija Nidish";
		});
		
		System.out.println("Printing the result");
		System.out.println(c2.get());
		
		CompletableFuture<String> c3=c2.thenApply(s->CompletableFuture.supplyAsync(()->s+" Mandur")).thenCompose(s->s);
		System.out.println(c3.get());
		
		CompletableFuture<String> c4= c2.thenCombine(c3, (s1,s2)->s1+s2);
		System.out.println("c4===>"+c4.get());
		
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> "World");
	
		List<CompletableFuture<String>> futureList=new ArrayList<CompletableFuture<String>>(List.of(future1,future2,future3));
		
		CompletableFuture.allOf(futureList.toArray(new CompletableFuture<?>[0]));
		
		CompletableFuture.allOf(future1,future2,future3);
		
		Stream.of(future1,future2,future3).map(CompletableFuture::join)
		.forEach(System.out::println);
		
		CompletableFuture<Void> i2= CompletableFuture.runAsync(()->{
			int i=10/0;
		}).exceptionally(e->{
			throw new ArithmeticException();
		}).thenAccept(d->System.out.println("testing"));
		
		CompletableFuture<Void> i3= CompletableFuture.runAsync(()->{
			int i=10/0;
		},executorService).exceptionally(e->{
			throw new ArithmeticException();
		})
			.handle((s,t)->{
				if(t!=null)
				{
					System.out.println("handled"+t);
					
				}
			
					return s;
			})
			.thenAccept(d->System.out.println("handled testing"));
//		
			CompletableFuture<Integer> i= CompletableFuture.supplyAsync(()->10/0).handle((s,t)->s!=null?s:0)
					.thenApply(d->d);
			
			//System.out.println(i.get());
			
			//System.out.println(i2.get());
			
			System.out.println(i3.get());

	}
	
	
}
