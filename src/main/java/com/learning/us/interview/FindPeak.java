package com.learning.us.interview;

public class FindPeak {
    public static void main(String[] args) {
        int[] arr= new int[] {1,12,2,4,0,7,6,3};
        int left=0;
        int length=arr.length;
        int right=length-1;
        System.out.println(findPeak(arr,left,right));
    }
    static int findPeak(int[] arr,int left,int right){
        int mid=(left+right)/2;
        if(left>=right)
            return mid;
        else if(arr[mid]<arr[mid+1])
           return findPeak(arr,mid+1,right);
        else
           return findPeak(arr,left,mid);
    }
}
