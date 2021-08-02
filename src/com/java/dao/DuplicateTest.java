package com.java.dao;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateTest {

	public static void main(String arg[]) {

		Integer[] arr = new Integer[] { 1, 2, 3, 4, 3, 2, 4, 2 };
		// List<Integer> listWithDuplicates = Arrays.asList(arr);

		Arrays.stream(arr).distinct().forEach(System.out::println);
		Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList())
				.forEach(System.out::println);

		// System.out.println(mapList);

		Integer[] arr1 = new Integer[] { 100, 24, 13, 44, 114, 200, 40, 112 };

		Arrays.stream(arr1).mapToInt(x -> x * x).filter(x -> x > 10000).average().ifPresent(System.out::println);

		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)
				.withZone(ZoneId.systemDefault());

		Instant instant = Instant.now();
		String instantStr = formatter.format(instant);
		System.out.println("Instant in String format: " + instantStr);
		
		List<String> names= new ArrayList<String>();
		names.add("abc");
		names.add("xyz");
		names.stream().forEach(x->System.out.println(x.toUpperCase()));
		

	}

}
