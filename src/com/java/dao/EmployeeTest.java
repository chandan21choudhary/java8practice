package com.java.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Employee;

public class EmployeeTest {

	public static void main(String args[]) {

		List<Employee> empList = new EmployeeList().getAllEmployees();
		
		List<String> input = Arrays.asList("one", "two", "three", "four", "five");
		Map<Boolean, List<String>> map = input.stream().collect(Collectors.partitioningBy(s -> s.length() == 3));
		System.out.println(map); // {false=[three, four, five], true=[one, two]}

		empList.forEach(x -> System.out.println(x));

		// How many male and females employeess are there in the organizations

		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(noOfMaleAndFemaleEmployees);

		// Print the name of all departments in the organization?

		List<String> dept = empList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		dept.forEach(System.out::println);

		// List the employee whose age is 32
		List<String> empNames = empList.stream().filter(emp -> emp.getAge() == 32).map(emp -> emp.getName())
				.collect(Collectors.toList());
		empNames.forEach(emp -> System.out.println(emp));

		// What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemale);
		
		//Find the avarage age of Male employee
		double averageAge = empList.stream().filter(emp->emp.getGender().equals("Male")).mapToDouble(i->i.getAge()).average().getAsDouble();
		System.out.println(averageAge);
		
		
		//find the maximum age of the employee
		int maxAge=empList.stream().map(emp->emp.getAge()).collect(Collectors.toList()).stream().reduce(Integer::max).get();
		System.out.println(maxAge);
		
	
		
		// Get the details of highest paid employee in the organization?
		Employee highestPaidEmployee = empList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println(highestPaidEmployee);

		// Get the names of all employees who have joined after 2015?
		Long d1 = System.currentTimeMillis();
		empList.stream().filter(x -> x.getYearOfJoining() > 2015).collect(Collectors.toList())
				.forEach(x -> System.out.println(x.getName()));
		;
		Long d2 = System.currentTimeMillis();
		System.out.println("Total Time taken by stream class:" + (d2 - d1));

		Long d3 = System.currentTimeMillis();
		empList.parallelStream().filter(x -> x.getYearOfJoining() > 2015).collect(Collectors.toList())
				.forEach(x -> System.out.println(x.getName()));
		;
		// empList.parallelStream().filter(x->
		// x.getYearOfJoining()>2015).map(Employee::getName).forEach(System.out::println);
		Long d4 = System.currentTimeMillis();
		System.out.println("Total Time taken by parallel stream class:" + (d4 - d3));

		// Count the number of employees in each department?

		Map<String, Long> departmentWiseEMployee = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// unsortedMap.entrySet().stream().sorted(Map.Entry.<EmailAttachment,
		// Double>comparingByValue().reversed())
		// .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		System.out.println(departmentWiseEMployee);

		// In sorted order
		departmentWiseEMployee.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed());
		System.out.println(departmentWiseEMployee);

	}

}
