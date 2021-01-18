package com.learning.string;

public class StringInternExample {
public static void main(String[] args) {
    String s1="Sachin";
    String s2=new String("Sachin");
    // here intern method will create exact copy of new String("Sachin") in String constant pool
    String s3=s2.intern();
    System.out.println(s1==s2);
    System.out.println(s1==s3);
}
}
