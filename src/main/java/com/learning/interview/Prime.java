package com.learning.interview;

public class Prime {
	public static void main(String[] args) {
        long largestPrime=0;
        long input=600851475143L;
        long limit=input/2;
        for(long i=2;i<=limit;i++){
            try {
            	long no=input%i;
                if(no==0){
                    if(isPrime(i) && i>largestPrime){
                        largestPrime=i;
                    }
                }
            }
            catch(Exception e){
                System.out.println(i);
            }
        }
        System.out.println(largestPrime);
    }

    public static boolean isPrime(long input){
        boolean flag=true;
        long limit=input/2;
        for(long i=2;i<=limit;i++)
        {
            if(input%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
