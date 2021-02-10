package com.learning.interview.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinRecursiveAction extends RecursiveTask<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 233714905799082545L;
	private static final int THRESHOLD=2;
	private static StringBuilder result=new StringBuilder();
	private String workLoad;
	public ForkJoinRecursiveAction(String workLoad) {
		this.workLoad=workLoad;
	}
	
	@Override
	public String compute() {
		//String result="";
		if(workLoad.length()>THRESHOLD)
			return ForkJoinTask.invokeAll(createSubTask(workLoad)).stream().map(ForkJoinRecursiveAction::join).collect(Collectors.joining());
					
		else
			return process(workLoad);
	}
	
	public List<ForkJoinRecursiveAction> createSubTask(String workLoad)
	{
		List<ForkJoinRecursiveAction> list=new ArrayList<ForkJoinRecursiveAction>();
		int strLen=workLoad.length();
		String half1=workLoad.substring(0,strLen/2);
		String half2=workLoad.substring(strLen/2, strLen);
		ForkJoinRecursiveAction half1Fork=new ForkJoinRecursiveAction(half1);
		ForkJoinRecursiveAction half2Fork=new ForkJoinRecursiveAction(half2);
		list.add(half1Fork);
		list.add(half2Fork);

		return list;
	}
	
	public static String process(String workLoad) {
		String toUpperCase=workLoad.toUpperCase();
		result.append(toUpperCase);
		System.out.println(Thread.currentThread().getName()+" is acting upon "+toUpperCase);
		return toUpperCase;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
		ForkJoinRecursiveAction customTask=new ForkJoinRecursiveAction("Nidish Krishnan");
		forkJoinPool.execute(customTask);
		System.out.println("Final String ===>"+result.toString());
		System.out.println(customTask.join());
	}
}
