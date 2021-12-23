package com.learning.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stocks {

	public static void main(String[] args) {
		long[] prices=new long[] {6,0,-1,10};
		System.out.println(solution(prices));
	}
	public static long solution(long[] prices) {
		if(prices.length==0)
			return 0;
		List<Long> list=new ArrayList<>();
		for(long price:prices) {
			list.add(price);
		}
		Arrays.sort(prices);
		int idx=list.indexOf(prices[0]);
		List<Long> sublist=list.subList(idx,list.size());
		Collections.sort(sublist);
		System.out.println(sublist);
		
		return sublist.get(sublist.size()-1)-prices[0];
	}
	
	 public static long[] quickSort(long[] arr,int lb,int ub){
	        if(lb<ub)
	        {
	            int partition=partition(arr,lb,ub);
	            arr=quickSort(arr,lb,partition-1);
	            arr=quickSort(arr,partition+1,ub-1);
	        }
	        return arr;
	    }

	    private static int partition(long[] arr,int lb,int ub){
	        int start,end;
	        long pivot;
	        start=lb;
	        end=ub;
	        pivot=arr[lb];
	        while (end > start) {
	            while(arr[start]<=pivot)
	                start++;
	            while(arr[end]>pivot)
	                end--;
	            if(end>start){
	                arr=swap(arr,start,end);
	            }
	        }
	        arr=swap(arr,lb,end);
	        return end;
	    }
	    
	    private static long[] swap(long[] arr,int start,int end){
	        long temp=arr[start];
	        arr[start]=arr[end];
	        arr[end]=temp;
	        return arr;
	    }
}
