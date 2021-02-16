package com.learning.interview;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx2 {
	public static void main(String[] args) {
		try(Stream<String> stream=Files.lines(Paths.get("Nidish"),StandardCharsets.UTF_8)){
		
		Map<String, Long>	map= stream.map(s->s.split(" ")).flatMap(Stream::of)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
	
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		try(Stream<String> stream=Files.lines(Paths.get("Nidish"),StandardCharsets.UTF_8)){
			
	
			String s=stream.collect(Collectors.joining(System.lineSeparator()));
			
			System.out.println(s);
			String searchStr="Naija";
			AtomicInteger index=new AtomicInteger();
			
			int idx=0;
			int strLen=searchStr.length();
			while(idx<s.length()) {
				int i=s.indexOf(searchStr, idx);
				if(i==-1)
					break;
				else {
					idx=i+strLen;
					
				System.out.println(searchStr+" is located at "+i);
				}
			}
			
			System.out.println("2nd occurence of Nidish ===>"+findNthOccurence(s, "Nidish", 2));
			System.out.println("2nd occurence of Naija ===>"+findNthOccurence(s, "Naija", 2));
			}
			catch (IOException e) {
				// TODO: handle exception
			}
		
	}
	
	public static int findNthOccurence(String s, String searchStr, int ntheOccurence) {
		int idx = 0;
		int strLen = searchStr.length();
		int occurence = 0;
		int result = 0;
		while (idx < s.length()) {
			int i = s.indexOf(searchStr, idx);
			occurence++;
			if (i == -1) {
				result = -1;
				break;
			} else {
				idx = i + strLen;

				if (occurence == ntheOccurence) {
					result = i;
					break;
				}

			}
		}

		return result;
	}

	
}
