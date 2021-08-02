package com.java.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.dao.EmployeeList;
import com.java.model.Employee;

public class Comparing {

	public static void main(String arg[]) {

		List<Employee> empList = new EmployeeList().getAllEmployees();

//		/Get the details of highest paid employee in the organization?
		Employee emp = empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		System.out.println(emp.getName() + "---" + emp.getSalary());
		
		
		
		
		Double maxSalary= empList.stream().mapToDouble(x->x.getSalary()).reduce(0, Double::max);
		System.out.println(maxSalary);
		
		
		 //List of Employee based on salary in descending order
		List<Employee> salaryWiseEmployee = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		salaryWiseEmployee.forEach(x->System.out.println(x.getName()+"---"+x.getSalary()));
		
		
		Map<Boolean, List<String>> listEmpNames = empList.stream()
				.collect(Collectors.partitioningBy(emp1 -> emp1.getSalary() > 30000, Collectors.mapping(Employee::getName, Collectors.toList())));

		listEmpNames.entrySet().stream().forEach(x->System.out.println(x.getKey()+"--"+x.getValue()));
		
		System.out.println(listEmpNames.values());
		
		
		//Get the details of youngest male employee in the product development department?
        Employee youngestEmpInPD= empList.stream().filter(x->x.getDepartment().equals("Product Development"))
        		.sorted(Comparator.comparing(Employee::getAge)).findFirst().get();
        
        System.out.println(youngestEmpInPD);
        
       //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        
       Employee agedEmp= empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge))).get();
       
       System.out.println("Name:"+agedEmp.getName()+" "+"Age:"+agdEmp.getAge()+" "+"Department:"+agedEmp.getDepartment());
       
      Employee oldestEmployeeWrapper = empList.stream().max(Comparator.comparing(Employee::getAge)).get();
      
      System.out.println("Name:"+oldestEmployeeWrapper.getName()+" "+"Age:"+oldestEmployeeWrapper.getAge()+" "+"Department:"+oldestEmployeeWrapper.getDepartment());
      
      
      //Query 3.9 : Who has the most working experience in the organization?
         Long minYear= empList.stream().mapToLong(Employee::getYearOfJoining).min().getAsLong();
         System.out.println(minYear);
         
         empList.stream().filter(x->x.getYearOfJoining()==minYear).collect(Collectors.toList())
         .forEach(System.out::println);
  
        

	}

}
