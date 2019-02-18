package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;

public class PrintEvenNumbersUsingFilter {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of numbers and that has been assigned to a List of Integers.
		 */
		List<Integer> someNumbers = Arrays.asList(11, 33, 44, 66, 77);
		
		/**
		 * filter() is an intermediary method that takes 'Predicate' functional interface as parameter.
		 * 'Predicate' has 'test()' method which receives an input of any type and return only boolean.  
		 */
		someNumbers.stream().filter(num -> num % 2 == 0)
							.forEach(evenNum -> System.out.println(evenNum));
	}

}
