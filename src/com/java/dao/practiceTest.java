package com.java.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Employee;

public class practiceTest {

	public static void main(String arg[]) {

		List<Employee> empList = new EmployeeList().getAllEmployees();

		// How many male and female employees are there in the organization?
		Map<String, Long> noOfmaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfmaleAndFemale);
		System.out.println("----------------------------------------------------------");

		// Print the name of all departments in the organization?
		List<String> deptNames = empList.parallelStream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		deptNames.forEach(System.out::println);

		System.out.println("----------------------------------------------------------");

		// What is the average age of male and female employees?
		Map<String, Double> avgAgeofMaleAndFemale = empList.parallelStream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(avgAgeofMaleAndFemale);
		System.out.println("----------------------------------------------------------");
		
		
		//Get the details of highest paid employee in the organization?
		
	    Employee highestPaidEmployee=
	    		empList.parallelStream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println(highestPaidEmployee);
		System.out.println("----------------------------------------------------------");
		
		// Get the names of all employees who have joined after 2015?
		
		List<Employee> empDetails=
				empList.stream().filter(x->x.getYearOfJoining()>2015).collect(Collectors.toList());
		empDetails.forEach(emp->System.out.println(emp.getName()+" "+emp.getYearOfJoining()));
	}

}
