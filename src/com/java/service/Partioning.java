/**
 * 
 */
package com.java.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.dao.EmployeeList;
import com.java.model.Employee;

/**
 * @author Chandan
 *
 */
public class Partioning {

	/**
	 * fetch out two stream from a single stream
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> listEmp = new EmployeeList().getAllEmployees();

		Map<Boolean, List<String>> empNames = listEmp.stream().collect(Collectors.partitioningBy(
				emp -> emp.getSalary() > 30000, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		empNames.entrySet().stream().forEach(x->System.out.println(x.getKey()+"--"+x.getValue()));
		//System.out.println(empNames.values());
		
		
		//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		
		Map<Boolean, List<String>> empNames1 = listEmp.stream().collect(Collectors.partitioningBy(
				emp -> emp.getAge() > 25, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		
	}

}
