package jdk8.features.samples.domain;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class DistinctEmployeeNames {
	
	public static void main(String[] args) {
		
		/**
		 * this is just a list of employees getting returned from static method of "Employee" class.
		 */
		List<Employee> employees = Employee.listofEmployees();
		
		/**
		 * First of all, convert the list of Employees into Stream.
		 * map() will map each employee to it's name. It will return a Stream of String.
		 * distinct() will apply to all the employee names and returns only unique names.
		 * distinct() is a terminal method and returns a Stream.
		 * Since we need List instead of Stream, we use collect() which is a static import method 
		 * from 'Collectors' and it will convert from Stream to List.
		 */
		List<String> employeesWithDistinctNames = employees.stream().map(emp -> emp.getName())
																		.distinct()
																		.collect(toList());
		/**
		 * just iterate through the list and print the names by using lambda expression.
		 */
		employeesWithDistinctNames.forEach(emp -> System.out.println(emp));
	}

}
