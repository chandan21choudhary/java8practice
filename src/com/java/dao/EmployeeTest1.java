package com.java.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.model.Employee;

public class EmployeeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> empList = new EmployeeList().getAllEmployees();

		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");

		
		  Map<String, Long> map = names.stream().collect( Collectors.groupingBy(
		  Function.identity(), Collectors.counting() ) );
		 
		Map<String, Long> noOfMalesAndFemales = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMalesAndFemales);

		List<Integer> listInt = Arrays.asList(1, 5, 10, 15, 20, 30);
		int sum = listInt.stream().filter(x -> x > 10).mapToInt(i -> i).sum();
		System.out.println(sum);

		List<String> listDept = empList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		System.out.println(listDept);

		Map<String, Double> avgAgeOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemale);

		Employee higestPaidEMployee = empList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println(higestPaidEMployee);

		System.out.println("********************************");
		List<String> threeLowestpaidEMp = empList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.peek(x->System.out.println(x)).map(Employee::getName).limit(3).peek(x->System.out.println(x)).collect(Collectors.toList());
		//System.out.println(threeLowestpaidEMp);
		System.out.println("********************************");
		double highestSalary = empList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
		System.out.println(highestSalary);

		List<String> threeHighesetPaidEmp = empList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName).limit(3)
				.collect(Collectors.toList());
		System.out.println(threeHighesetPaidEmp);

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8, 9);

		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

		List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(x -> x.stream()).filter(x -> x > 5)
				.collect(Collectors.toList());

		System.out.println(listOfAllIntegers);

		Map<Boolean, List<Employee>> listEmpNames = empList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getAge() > 25));

		System.out.println(listEmpNames);

		DoubleSummaryStatistics salaryStatics = empList.parallelStream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println(salaryStatics);

		System.out.println("Max Salary:" + salaryStatics.getMax());
		System.out.println("Min Salary:" + salaryStatics.getMin());
		System.out.println("Avg Salary:" + salaryStatics.getAverage());
		System.out.println("Total Salary:" + salaryStatics.getSum());

		Map<String, List<Employee>> listDeptWiseEmployee = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(listDeptWiseEmployee);

		for (Map.Entry<String, List<Employee>> deptWiseEmp : listDeptWiseEmployee.entrySet()) {
			System.out.println(deptWiseEmp.getKey());
			System.out.println("----------");
			List<Employee> employeeList= deptWiseEmp.getValue();
			employeeList.stream().forEach(x->System.out.println(x.getName()));
			System.out.println("----------");

		}

	}

}
