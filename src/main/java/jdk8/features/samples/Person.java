package jdk8.features.samples;

public class Person implements Comparable<Person>{

	private String name;
	private String address;
	private String city;
	private int salary;

	public Person(String name, String address, String city, int salary){
		this.name = name;
		this.address = address;
		this.city = city;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" Name :" + name);
		strBuilder.append(" Address :" + address);
		strBuilder.append(" City :" + city);
		strBuilder.append(" Salary :" + salary);
		return strBuilder.toString();
		//String
		//return super.toString();
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		// sorting on name
		String otherPersonName = o.getName();
		int result = String.CASE_INSENSITIVE_ORDER.compare(this.name, otherPersonName);
		return result;
	}

}
