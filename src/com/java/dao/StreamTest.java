package com.java.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String... arg) {

		// Given a list of integers, find out all the even numbers exist in the list
		// using Stream functions?
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
		
		
		int arr[]= {5,10,2,6,9,54,100};
		
		Arrays.stream(arr).sorted().limit(arr.length-1).skip(arr.length-2).forEach(System.out::println);
		//int num= Arrays.stream(arr).reduce(10,Integer::min);
		//System.out.println(num);
		
		
		
		System.out.println("----------------------");
		// Given a list of integers, find out all the numbers starting with 1 using
		// Stream functions?
		myList.stream().map(x -> x + " ").filter(x -> x.startsWith("1")).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("-------------------------------------");

		// How to find duplicate elements in a given integers list in java using Stream
		// functions?

		List<Integer> myList1 = Arrays.asList(2,10, 15, 8, 49, 25, 98, 98, 32, 15, 10);
		HashSet<Integer> s = new HashSet<>();
		myList1.stream().filter(x -> !s.add(x)).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("-------------------------------------");
		// Given the list of integers, find the first element of the list using Stream
		// functions?
		
		System.out.println(myList1.stream().findFirst().get());
		
		System.out.println("-----------------------------------------");
		
		
		//Given a String, find the first non-repeated character in it using Stream functions?
		 String input = "Java Hungry Blog Alive is Awesome";

         Character result = input.chars() // Stream of String       
                                 .mapToObj(st -> Character.toLowerCase(Character.valueOf((char) st))) // First convert to Character object and then to lowercase         
                                 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                 .entrySet()
                                 .stream()
                                 .filter(entry -> entry.getValue() == 1L)
                                 .map(entry -> entry.getKey())
                                 .findFirst()
                                 .get();
         System.out.println(result); 
         
         System.out.println("-----------------------------------------");
 		
         
         //Given a String, find the first repeated character in it using Stream functions?
         String input1 = "Java Hungry Blog Alive is Awesome";

         Character result1 = input1.chars() // Stream of String       
                                 .mapToObj(ss -> Character.toLowerCase(Character.valueOf((char) ss))) // First convert to Character object and then to lowercase         
                                 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                 .entrySet()
                                 .stream()
                                 .filter(entry -> entry.getValue() > 1L)
                                 .map(entry -> entry.getKey())
                                 .findFirst()
                                 .get();
         System.out.println(result1);    
         System.out.println("-----------------------------------------");
 		
	}

}
