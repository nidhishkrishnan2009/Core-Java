package com.learning.interview;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestEx2 {
	public static void main(String[] args) {
		int value=345678;
		System.out.println("Reverse of "+value+ " ="+Integer.valueOf(reverseInteger(value)));
		
		List<Integer> intList=new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
		intList.removeIf(i->isPrime(i));
		System.out.println("Final list after removing prime numbers===>"+intList);
		
		Map<Character, String> dict=new HashMap<Character, String>();
		dict.put('a', "Apple");
		dict.put('b', "Bajaj");
		dict.put('c', "CISCO");
		dict.put('d', "Delloit");
		
		List<Character> inputList=new ArrayList<Character>(List.of('d','b'));
		Map<Character, String> filteredDict= dict.entrySet().stream().filter(e->inputList.contains(e.getKey()))
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n)->n));
		
		System.out.println("Filtered Dictionary ===>"+filteredDict);
		
		int[] findMaxDiffList={5,2,4,6,7};
		AtomicInteger maxDiff=new AtomicInteger(0);
		Stream.iterate(0, n->n<findMaxDiffList.length, n->n+1).forEachOrdered(i->{
			int j=i;
			while(j>=0)
			{
				int diff=findMaxDiffList[i]-findMaxDiffList[j];
				if(diff>maxDiff.get())
					maxDiff.set(diff);
				j--;
			}
		});
		
		System.out.println("Maximum depth between element= "+maxDiff.get());
		printTopFrequentlyUsedLastNames();
		findMaxOccurenceOfaWord("Nidish");
	}
	
	private static String reverseInteger(Integer no) {

		String s1=Stream.of(no.toString()).map(s->s.split(""))
				.map(s->s)
				.flatMap(Stream::of)
				.collect(StringBuffer::new,(x,y)->x.insert(0,y),StringBuffer::append).toString();
		return s1;
	}
	
	public static boolean isPrime(int no) {
		if(no==1)
			return false;
		else if(no==2)
			return true;
		else
			return IntStream.rangeClosed(2, no/2).noneMatch(i->no%i==0);

		
	}
	
	private static void printTopFrequentlyUsedLastNames()
	{
		String[] sArr= {"Sachin Tendulkar","Sachin Ramesh Tendulkar","Farhan","Farhan Khan","Amir Khan"};
		Map<String, Long> freqLastNames= Stream.of(sArr).map(s->s.split(" ")).map(s->s[s.length-1])
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n)->n,LinkedHashMap::new));
		System.out.println("freqLastNames===>"+freqLastNames);
					
	}
	
	public static void findMaxOccurenceOfaWord(String word)
	{
		try(Stream<String> fileStream=Files.lines(Paths.get("Nidish"),StandardCharsets.UTF_8)){
			long noOfOccurence= fileStream.map(s->s.split(" ")).flatMap(Stream::of).filter(w->w.equals(word)).count();
			System.out.println("Maximum occurence of "+word+" ="+noOfOccurence);
			findNthOccurence(word, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void findNthOccurence(String word,long nthOccurence)
	{
		try {
			String s= Files.lines(Paths.get("Nidish"),StandardCharsets.UTF_8)
					.collect(Collectors.joining(System.lineSeparator()));
			int currentIndex=0;
			int occurence=0;
			while(currentIndex<s.length() )
			{
				int index=s.indexOf(word,currentIndex);
				if(index==-1)
					break;
				occurence++;
				currentIndex=index+word.length();
				if(occurence==nthOccurence)
				{
					currentIndex=index;
					break;
				}
			}
			
			if(occurence==nthOccurence)
				System.out.println(nthOccurence+" occurence of "+word+" is "+currentIndex);
			else
				System.out.println("Not found");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

