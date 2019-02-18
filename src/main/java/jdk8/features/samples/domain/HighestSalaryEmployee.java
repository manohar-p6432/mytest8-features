package jdk8.features.samples.domain;

import java.util.List;
import java.util.Optional;

public class HighestSalaryEmployee {
	
	public static void main(String[] args) {
		/**
		 * this is just a list of employees getting returned from static method of "Employee" class.
		 */
		List<Employee> employees = Employee.listofEmployees();
		
		/**
		 * first, convert a List into Stream.
		 * use reduce() method to pass the rule for selecting the criteria.
		 * reduce() takes Lambda Expression as argument. 
		 * basically lambda expression is receiving two employee objects as input and returns the employee 
		 * with highest salary out of these two. 
		 * all the employees will be compared like this to each other.
		 * The employee with highest salary will returned at the end.
		 * The return type is Optional, which is a new type in JDK8. 
		 * Optional is alternative to NULL objects.  
		 */
		Optional<Employee> highestSalaryEmployee = employees.stream()
															.reduce( (emp1, emp2) -> 
																		emp1.getSalary() > emp2.getSalary() ? emp1 : emp2);
		/**
		 * printing out the employee with highest salary.
		 */
		System.out.println(highestSalaryEmployee);
	}

}
