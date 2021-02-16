package com.learning.interview.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveAction  extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 278936182735502308L;

	private String workLoad;
	private static final int THRESHOLD=2;
	private List<ForkJoinRecursiveAction> list=new ArrayList<ForkJoinRecursiveAction>();
	public ForkJoinRecursiveAction(String workLoad)
	{
		this.workLoad=workLoad;
	}
	@Override
	protected void compute() {
		if(workLoad.length()>THRESHOLD)
			ForkJoinTask.invokeAll(createSubTask());
		
		else 
		{
			process();
			
		}
		

	}
	
	private void process() {
		workLoad=workLoad.toUpperCase();
		System.out.println(workLoad);
		//System.out.println("Current String "+workLoad+" is processed by "+Thread.currentThread().getName());
	}
	
	private  List<ForkJoinRecursiveAction> createSubTask()
	{
		int strLen=workLoad.length();
		String s1=workLoad.substring(0,strLen/2);
		String s2=workLoad.substring(strLen/2,strLen);
		ForkJoinRecursiveAction s1Task=new ForkJoinRecursiveAction(s1);
		ForkJoinRecursiveAction s2Task=new ForkJoinRecursiveAction(s2);
		list.add(s1Task);
		list.add(s2Task);
		return list;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoin=ForkJoinPool.commonPool();
		ForkJoinRecursiveAction forkJoinAction=new ForkJoinRecursiveAction("Naija Nidish");
		forkJoin.invoke(forkJoinAction);
	}
}
