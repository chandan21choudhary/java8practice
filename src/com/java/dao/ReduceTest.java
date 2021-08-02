package com.java.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.model.Employee;

public class ReduceTest {
	public static void main(String arg[]) {
		
		 int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 
		List<Integer> numList = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 7, 7, 7);
		Set<Integer> set = new HashSet<>();
		Set<Integer> list1 = numList.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
		System.out.println(list1);
		
		int sum= Arrays.stream(numbers).reduce(10, Integer::min);
		System.out.println(sum);
		
		List<Employee> empList = new EmployeeList().getAllEmployees();
		int maxAge=empList.stream().map(e->e.getAge()).reduce(0, Integer::min);
		System.out.println(maxAge);
		
		
		Map<String, List<String>> deptEmpCount=
				empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
		
		System.out.println(deptEmpCount);
		
		
		int maxAge1=empList.stream().map(emp->emp.getAge()).collect(Collectors.toList()).stream().reduce(Integer::max).get();
		System.out.println(maxAge1);
		
		Employee agedEmployee=empList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge).reversed())).get();
		System.out.println(agedEmployee);
		
		double avgAge=empList.stream().mapToDouble(i->i.getAge()).average().getAsDouble();
		System.out.println(avgAge);
		
		findDupliacteCharacter("elephant");
		camleToSnake("GeeksForGeeks");
		snaketoCamle("geeks_for_geeks");
		
	}

	private static void snaketoCamle(String string) {
		
		char[] ch=string.toCharArray();
		
		 String result="";
		 result=result+Character.toUpperCase(ch[0]);
		 for(int i=1;i<=string.length()-1;i++) {
			 
			 if(string.charAt(i)=='_') {
				 i=i+1;
				 result=result+Character.toUpperCase(string.charAt(i));
			 }
			 else {
				 result=result+string.charAt(i);
			 }
		 }
		System.out.println(result);
	}

	private static void camleToSnake(String str) {
		String result = "";
		 
        // Append first character(in lower case)
        // to result string
        char c = str.charAt(0);
        result = result + Character.toLowerCase(c);
 
        // Tarverse the string from
        // ist index to last index
        for (int i = 1; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            // Check if the character is upper case
            // then append '_' and such character
            // (in lower case) to result string
            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result
                    = result
                      + Character.toLowerCase(ch);
            }
 
            // If the character is lower case then
            // add such character into result string
            else {
                result = result + ch;
            }
        }
		System.out.println(result);	

	
}
private static void findDupliacteCharacter(String string) {

		char[] ch = string.toCharArray();
		Map<Character, Integer> mapResult = new LinkedHashMap<Character, Integer>();
		for (char c : ch) {
			mapResult.put(c, mapResult.containsKey(c) ? mapResult.get(c) + 1 : 1);
		}
        StringBuffer sb=new StringBuffer();
		for (Map.Entry<Character, Integer> m : mapResult.entrySet()) {
			sb.append(m.getKey());
			sb.append(m.getValue());
		}
        System.out.println(sb);
       
		
	}

}
