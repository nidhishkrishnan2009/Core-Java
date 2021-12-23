package com.learning.us.interview;

import java.util.*;
import java.util.stream.*;


public class MaxSubArray {

	public static void main(String[] args) {
		//int[] arr=new int[] {-3,-1,-2};
		int[] arr=new int[] {5,4,-1,7,8};
		System.out.println(maximumSubarray(arr));
	}

//	static int maximumSubarray(int[] arr){
//			Integer[] arrBoxed= IntStream.of(arr).boxed().toArray(Integer[]::new);
//		 	if(arrBoxed.length==0)
//		 		return 0;
//	        int result=0;
//	        int len=arrBoxed.length;
//	        Arrays.sort(arrBoxed, ( a,  b) -> a.compareTo(b));
//	        if(len==1)
//	        	result=arrBoxed[0];
//	        if(len>0)
//	        	result=arrBoxed[len-2]+arrBoxed[len-1];
//			return result;
//	    }

	static int maximumSubarray(int[] arr){
		int globalSum=-Integer.MAX_VALUE;
		int localSum=0;
		for(int element:arr){
			localSum=Math.max(element,localSum+element);
			globalSum=Math.max(globalSum,localSum);
		}
		return globalSum;
	}
}
