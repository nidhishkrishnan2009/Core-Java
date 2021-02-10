package com.learning.interview;

import java.util.HashMap;
import java.util.Objects;

/**
 * 
 * @author Krishnan
 * Hashmap is collection of Entry objects. Entry objects are stored as buckets. Buckets are stored using Array data structure
 * in a contiguos index position. Each Entry object is built using  Linked List data structure
 * hash map overrides equals & hashcode methods of object class. equals methods compares the 
 * keys. hash code returns the hash code value of key. For each Entry object index value is calculated.
 * An Entry object will contain hashcode of the key,key,value and the address of the next connecting node if any or else null.
 * At each index position in hashmap has bucket. If 2 keys have same calculated index position then both the entry 
 * object will share the same bucket. When getting Entry object by key where the bucket is shared, in that case equals method
 * will compare the key for returning the correct Entry object. 
 */
public class InternalWorkingHashMap {

	public static void main(String[] args) {
		
		// How index value is calculated for an entry object
		
		HashMap<String, Integer> map = new HashMap<>();  
		map.put("Aman", 19);  
		map.put("Sunny", 29);  
		map.put("Ritesh", 39);  
		
		int hashCodeAman=Objects.hashCode("Aman");
		System.out.println("hash code value of Aman = "+hashCodeAman);
		String binaryhashCodeAman=Integer.toBinaryString(hashCodeAman);
		String binaryCapacity=Integer.toBinaryString(16-1);
		System.out.println("binary of hashcode Amen ="+binaryhashCodeAman);
		int indexAman=hashCodeAman & (16-1);// this is 111110011000101111001 &
		                                    //                          1111
											// =	   000000000000000001001 = 9						
		System.out.println("Index value of Amen ="+indexAman);
		
		int hashCodeSunny=Objects.hashCode("Sunny");
		System.out.println("hash code value of Sunny = "+hashCodeSunny);
		int indexSunny=hashCodeSunny & (16-1);// this is 111110011000101111001 &
        //                          1111
		// =	   000000000000000001001 = 9						
System.out.println("Index value of Sunny ="+indexSunny);
		// Formula for calculating the index of Entry object
		
		//index=binary of hashcode value of key Bitwise AND binary of capacity of hash map minus one (i.e)(16-1)
		
		// Normally after getting index value for a key , the corresponding Entry object will be placed in the right index in the hashmap.
		// Here Aman Entry object will take the index position 9 and Sunny Entry object will take the index position 7	
		//Hash  code conflict
		//If the index value of 2 Entry objects are same then first object will be allocated the index position and the second  
		// entry object will also be allocated the same index position 
		//but it will be added as the connecting linked list node of the first entry.
	}
}
