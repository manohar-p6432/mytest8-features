package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;

public class PrintDoublesUsingMap {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of numbers and that has been assigned to a List of Integers.
		 */
		List<Integer> someNumbers = Arrays.asList(11, 33, 44, 66, 77);
		
		/**
		 * first, need to convert 'List' into 'Stream' by using stream() method.
		 * Stream follows Functional Programming concept more strictly like 'immutable variable' here in this example.
		 * the 'num' is an immutable variable unlike previous example.
		 * Stream finds out a more optimized way to doubling each number by using map() method.
		 * map() is an intermediary method means it will not execute until there is a terminal method in the chain.
		 * forEach() is a terminal method, that's why map() will also execute.
		 * map() accepts a Functional Interface of type "Function".
		 * the output of map() method is input to forEach() method. It means when each number is traversed inside forEach(), 
		 * it is Stream of doubled numbers.
		 * at the end, all the double numbers will get printed. 
		 */
		someNumbers.stream().map(num -> num * 2)
							.forEach(doubleNum -> System.out.println(doubleNum));
	}

}
