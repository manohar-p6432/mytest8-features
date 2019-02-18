package jdk8.features.samples.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class FirstThreeEmployeesWithMoreThanSalary {
	
	public static void main(String[] args) {
		
		/**
		 * this is just a list of employees getting returned from static method of "Employee" class.
		 */
		List<Employee> employees = Employee.listofEmployees();
		
		/**
		 * first convert List into Stream.
		 * filter() will filter out only those employees having salary more than 3000.
		 * filter() returns Stream of Employees.
		 * limit() will return only first n objects from the Stream.
		 * collect() will return the list corresponding to Stream.
		 */
		List<Employee> firstThreeEmployeesWithMoreThan3000Salary = employees.stream().filter(emp -> emp.getSalary() > 3000)
																						.limit(3)
																						.collect(toList());
		
		/**
		 * just iterate through the list and print the employees by using lambda expression.
		 */
		firstThreeEmployeesWithMoreThan3000Salary.forEach(emp -> System.out.println(emp));
	}

}
