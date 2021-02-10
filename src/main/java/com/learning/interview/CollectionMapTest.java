package com.learning.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectionMapTest {

	public static void main(String[] args) {
		Map<Integer, String> studentMap=new HashMap<Integer, String>();
		
		studentMap.put(101, "Sachin");
		studentMap.put(102, "Shewag");
		studentMap.put(103, "Ganguly");
		studentMap.compute(103, (k,v)->"Sourav Ganguly");
		studentMap.compute(104, (k,v)->k+"Dravid"+v);
		studentMap.computeIfAbsent(104, d->"Rahul");
		studentMap.computeIfAbsent(105, d->"Yuvraj");
		studentMap.computeIfPresent(106, (k,v)->{
			return "Rahul Dravid";
		});
		
		studentMap.computeIfPresent(104, (k,v)->{
			return "Rahul Dravid";
		});
		studentMap.put(107, "Robin");
		studentMap.merge(101, "Sachin", (k,v)->v+" Ramesh Tendulkar");
		studentMap.replaceAll((k,v)->{
			if(v.contains("Yuvraj"))
				return v+" Singh";
			else 
				return v;
		});
		studentMap.replace(107, "Rob", "Robin Singh");
		studentMap.replace(107, "Robin", "Robin Singh");
		System.out.println(studentMap);
		
		Map<Integer, String> studentMapOrderByKey=studentMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue,newValue)->newValue,LinkedHashMap::new));
		System.out.println(studentMapOrderByKey);
		
		HashMap<Integer, String> nullMap=new HashMap<Integer, String>();
		nullMap.put(null, null);
		nullMap.put(null, "Ramesh");
		System.out.println(nullMap);
		
		HashMap<Integer, String> nullMapShallowCopy=(HashMap<Integer, String>) nullMap.clone();
		
		System.out.println("shallow copy of nullMap is "+nullMapShallowCopy);
		
		TreeMap<Integer, String> treeMap=new TreeMap<Integer, String>();
		treeMap.put(105, "Arjun");
		treeMap.put(101, "Ramesh");
		System.out.println(treeMap);
		
		TreeMap<Integer, String> treeMapComparator=new TreeMap<Integer, String>(Comparator.reverseOrder());
		treeMapComparator.put(105, "Arjun");
		treeMapComparator.put(101, "Ramesh");
		treeMapComparator.put(102, "Mane");
		System.out.println(treeMapComparator);
		
		Entry<Integer, String> ceilingEntry=treeMapComparator.ceilingEntry(106);
		System.out.println(ceilingEntry);
		System.out.println(treeMapComparator.ceilingEntry(100));
		System.out.println(treeMapComparator.ceilingEntry(103));
		
		Entry<Integer, String> floorEntry=treeMapComparator.floorEntry(100);
		System.out.println("floor entry for 100 ="+floorEntry);
		
		NavigableMap<Integer, String> descendingOrderHashmap=new TreeMap<Integer, String>(studentMap).descendingMap();
		System.out.println("descendingfromAscxendingMap--->"+descendingOrderHashmap);
		
		SortedMap<Integer, String> headMap=descendingOrderHashmap.headMap(103);
		System.out.println("head map is--->"+headMap);
		SortedMap<Integer, String> headMapInclusive=descendingOrderHashmap.headMap(103, true);
		System.out.println("head map inclusive is--->"+headMapInclusive);
		
		Map<Integer, String> tailMap=descendingOrderHashmap.tailMap(103);
		System.out.println("Tail map is --->"+tailMap);
		
		Map<Integer, String> tailMapInclusive=descendingOrderHashmap.tailMap(103,false);
		System.out.println("tail map inclusive is___>"+tailMapInclusive);
		System.out.println("getting first key --->"+descendingOrderHashmap.firstKey());
		System.out.println("getting last key --->"+descendingOrderHashmap.lastKey());
		//Compilation error.
		//HashMap<Integer, String> hashMapComparator=new HashMap<>(Comparator.reverseOrder());
		 
		Collection<String> mapValues=descendingOrderHashmap.values();
		System.out.println("Map values are");
		System.out.println(mapValues);
		List<String> collectionToList=new ArrayList<String>(mapValues);
		mapValues.stream().sorted().forEach(System.out::println);
		System.out.println("\nSorting in descending way\n");
		mapValues.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		Hashtable<Integer, String> hashTable=new Hashtable<Integer, String>(studentMap);
		Enumeration<String> hashtableValues=hashTable.elements();
		System.out.println("\nHash table values enumeration");
		while (hashtableValues.hasMoreElements()) {
			System.out.println(hashtableValues.nextElement());
			
		}
	}
}
