package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrintEvenNumbersUsingPredicateVariable {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of numbers and that has been assigned to a List of Integers.
		 */
		List<Integer> someNumbers = Arrays.asList(11, 33, 44, 66, 77);
		
		/**
		 * Functional Interface can also be declared as variable.
		 * a lambda expression is assigned to this variable.
		 * as shown in this example the lambda expression is of type "Predicate".
		 */
		Predicate<Integer> evenPredicate = num -> num % 2 == 0;
		
		/**
		 * 'evenPredicate' variable is of type "Predicate".  
		 */
		someNumbers.stream().filter(evenPredicate)
							.forEach(evenNum -> System.out.println(evenNum));
	}

}
