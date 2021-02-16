package com.learning.interview.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinRecursiveTask extends RecursiveTask<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 233714905799082545L;
	private static final int THRESHOLD=2;
	private String workLoad;
	public ForkJoinRecursiveTask(String workLoad) {
		this.workLoad=workLoad;
	}
	
	@Override
	public String compute() {
		//String result="";
		if(workLoad.length()>THRESHOLD)
			return ForkJoinTask.invokeAll(createSubTask(workLoad)).stream().map(ForkJoinRecursiveTask::join).collect(Collectors.joining());
					
		else
			return process(workLoad);
	}
	
	public List<ForkJoinRecursiveTask> createSubTask(String workLoad)
	{
		List<ForkJoinRecursiveTask> list=new ArrayList<ForkJoinRecursiveTask>();
		int strLen=workLoad.length();
		String half1=workLoad.substring(0,strLen/2);
		String half2=workLoad.substring(strLen/2, strLen);
		ForkJoinRecursiveTask half1Fork=new ForkJoinRecursiveTask(half1);
		ForkJoinRecursiveTask half2Fork=new ForkJoinRecursiveTask(half2);
		list.add(half1Fork);
		list.add(half2Fork);

		return list;
	}
	
	public static String process(String workLoad) {
		String toUpperCase=workLoad.toUpperCase();
		System.out.println(Thread.currentThread().getName()+" is acting upon "+toUpperCase);
		return toUpperCase;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
		ForkJoinRecursiveTask customTask=new ForkJoinRecursiveTask("Nidish Krishnan");
		forkJoinPool.execute(customTask);
		System.out.println(customTask.join());
	}
}
