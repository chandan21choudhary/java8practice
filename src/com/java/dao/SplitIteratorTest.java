package com.java.dao;

import java.util.Arrays;
import java.util.Spliterator;

public class SplitIteratorTest {
	
	public static void main(String arg[]) {
	String[] languageArray = new String[] {"Java", "C", "C++", "Python", "Scala", "Kotlin"};
	Spliterator<String> spliteratorOfArray = Arrays.spliterator(languageArray);
	//System.out.println(spliteratorOfArray);
	
		
		 spliteratorOfArray.tryAdvance(System.out::println);
		  spliteratorOfArray.tryAdvance(System.out::println);
		 
	
//	spliteratorOfArray.forEachRemaining(System.out::println);
	}
}
