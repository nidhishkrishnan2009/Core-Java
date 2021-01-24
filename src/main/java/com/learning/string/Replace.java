package com.learning.string;

public class Replace {

	public static void main(String[] args) {
	     String str = "oooooo-hhhh-oooooo";  
	     String s1=str.replace("o", "n");
	     System.out.println(s1);
	     String s2=str.replaceAll("o", "k");
	     System.out.println(s2);
	     
	     System.out.println("Comparison between replace & replaceALl");
	     
	     String s3="My name is Khan. My name is Bob. My name is Sonoo.";  
	     String replaceString=s3.replaceAll("\\s","");  
	     System.out.println(replaceString); 
	     String r=s3.replace("\\s","");  
	     System.out.println(r);
	     
	     System.out.println("conclusion : replaceAll supports regex while replace not");
	}
}
