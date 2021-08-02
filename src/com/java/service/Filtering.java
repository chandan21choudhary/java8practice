package com.java.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.dao.EmployeeList;
import com.java.model.Employee;

public class Filtering {
	
	public static void main(String arg[]) {
		
		List<Employee> empList= new EmployeeList().getAllEmployees();
		// Get the names of all employees who have joined after 2015?
		
		empList.stream().filter(x->x.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList())
		.forEach(System.out::println);
		
		// Get the names and doj of all employees who have joined after 2015?
		
		empList.stream().filter(x->x.getYearOfJoining()>2015).sorted(Comparator.comparing(Employee::getYearOfJoining).reversed())
		.collect(Collectors.toMap(Employee::getName, Employee::getYearOfJoining))
		.entrySet().parallelStream().forEach(x->System.out.println(x.getKey()+"--"+x.getValue()));   
		
	   
		
	}

}
