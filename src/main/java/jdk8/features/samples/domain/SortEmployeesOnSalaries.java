package jdk8.features.samples.domain;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import java.util.List;

public class SortEmployeesOnSalaries {
	
	public static void main(String[] args) {
		
		/**
		 * this is just a list of employees getting returned from static method of "Employee" class.
		 */
		List<Employee> employees = Employee.listofEmployees();
		
		/**
		 * first convert a List to Stream.
		 * sorted() method sorts all the employees object on the basis of parameter passed as argument.
		 * comparing() is a static method which takes Lambda Expression.
		 * the body of the Lambda Expression is the criteria for which the object will be sorted.
		 * At the end, collect() will convert Stream into List.
		 */
		List<Employee> sortedEmployees = employees.stream().sorted(comparing(emp -> emp.getSalary()))
															.collect(toList());
		
		/**
		 * print out all the employees in the sorted order.
		 */
		sortedEmployees.forEach(emp -> System.out.println(emp));
	}

}
