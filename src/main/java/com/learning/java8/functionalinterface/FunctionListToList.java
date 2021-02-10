package com.learning.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Krishnan
 *This example accepts Function as an argument, convert a List of String into another List of String, which was hashed with SHA256.
 */
public class FunctionListToList {
	
	public static void main(String[] args) {
		ListToListDemo listDemo=new ListToListDemo();
		List<String> list=Arrays.asList("Naija","Nidish");
		List<String> sha256ConvertedList=convertToList(listDemo::getSHA256, list);
		System.out.println("sha256ConvertedList===>"+sha256ConvertedList);
	}

	public static <U,R> List<R> convertToList(Function<U, R> func,List<U> list)
	{
		return list.stream().map(d->func.apply(d)).collect(Collectors.toList());
		
	}
}

class ListToListDemo{
	public String getSHA256(String s)
	{
		return DigestUtils.sha256Hex(s);
	}
	
}
