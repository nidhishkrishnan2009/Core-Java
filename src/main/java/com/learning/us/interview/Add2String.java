package com.learning.us.interview;

public class Add2String {

    // Function for finding sum of larger numbers
    //https://www.geeksforgeeks.org/sum-two-large-numbers/
    static String findSum(String str1, String str2)
    {
        String result="";
        if(str1.length()>str2.length())
        {
            String temp=str1;
            str1=str2;
            str2=temp;
        }
        int length1=str1.length();
        int length2=str2.length();
        int diff=length2-length1;
        int carry=0;
        for(int i=(length1-1);i>=0;i--){
            int sum= (int)str1.charAt(i)-'0'+(int)str2.charAt(i+diff)+carry+-'0';
            result+=(char)(sum%10+'0');
            carry=sum/10;
        }
        for(int i=diff-1;i>=0;i--){
            int sum=(int)str2.charAt(i)-'0'+carry;
            result+=(char)(sum%10+'0');
            carry=sum/10;
        }
        if(carry>0)
            result+=(char)(carry+'0');

       return new StringBuilder(result).reverse().toString();
    }

    // Driver code
    public static void main(String[] args)
    {
        String str1 = "128";
        String str2 = "84";
        System.out.println(findSum(str1, str2));
    }
}
