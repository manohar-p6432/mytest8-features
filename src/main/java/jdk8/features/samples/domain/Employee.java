package jdk8.features.samples.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee class is created to show how to use domain objects in Lambda
 * Expressions.
 *
 */
public class Employee {

	/**
	 * Contains three fields
	 */
	private int id;
	private String name;
	private float salary;

	/**
	 * default constructor
	 */
	public Employee() {
		super();
	}

	/**
	 * constructor with fields
	 */
	public Employee(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
	/**
	 * Ideally this method doesn't belong here. 
	 * But only for the demo purpose we are using it here, 
	 * so that different use-cases use this list rather than
	 * creating a new one for each use-case. 
	 */
	public static List<Employee> listofEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee emp1 = new Employee(1, "Alice", 3000);
		Employee emp2 = new Employee(2, "Bob", 30000);
		Employee emp3 = new Employee(3, "Chris", 2500);
		Employee emp4 = new Employee(4, "Daniel", 9000);
		Employee emp5 = new Employee(5, "Emma", 45000);
		Employee emp6 = new Employee(6, "Franklin", 6000);
		Employee emp7 = new Employee(7, "Alice", 10000);
		Employee emp8 = new Employee(8, "Chris", 15500);
		Employee emp9 = new Employee(9, "Emma", 90000);
		Employee emp10 = new Employee(10, "Gary", 5300);
		Employee emp11 = new Employee(11, "Daniel", 1100);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		employees.add(emp8);
		employees.add(emp9);
		employees.add(emp10);
		employees.add(emp11);
		
		return employees;		
	}
}
