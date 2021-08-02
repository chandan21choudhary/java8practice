package com.java.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import com.java.dao.EmployeeList;
import com.java.model.Employee;

public class Grouping {

	public static void main(String[] args) {

		List<Employee> empList = new EmployeeList().getAllEmployees();
		// How many male and female employees are there in the organization?
		Map<String, Long> countNoOfMaleAndFemaleEmployees = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countNoOfMaleAndFemaleEmployees);

		// List down the departwise employee name
		Map<String, List<String>> deptWiseEmployee = empList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(deptWiseEmployee);

		// Average Age of male and female employee
		Map<String, Double> avgAgeOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemale);

		// Print the name of all departments in the organization in descending order
		empList.stream().map(Employee::getDepartment).distinct().sorted(Collections.reverseOrder())
				.forEach(System.out::println);
		
		//Count the number of employees in each department?
		Map<String,Long> countDeptWiseEmployee= 
				empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.counting())));
		
		System.out.println(countDeptWiseEmployee);
		
		// What is the average salary of each department?
		
		Map<String, Double> deptWiseAvgSalary=
				empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(deptWiseAvgSalary);
        
       // What is the average salary of male and female employees?
        Map<String,Double> avgSalaryMaleAndFemale=
        		empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryMaleAndFemale);
        
        //Query 3.10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Double> avagAgemaleAndGemale= empList.stream().filter(emp->emp.getDepartment().equals("Sales And Marketing"))
        .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        
        System.out.println(avagAgemaleAndGemale);        
        
	}

}
