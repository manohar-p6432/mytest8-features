package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;

public class DoubleEachNumberAndPrintMultipliersOf3 {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of numbers and that has been assigned to a List of Integers.
		 */
		List<Integer> someNumbers = Arrays.asList(11, 33, 44, 66, 77);
		
		/**
		 * this solution contains both map() and filter() method.
		 */
		someNumbers.stream().map(num -> num*2)
							.filter(doubleNum -> doubleNum % 3 == 0)
							.forEach(result -> System.out.println(result));
		
		/**
		 * the order of the map() and filter() doesn't matter in this solution.
		 */
		someNumbers.stream().filter(doubleNum -> doubleNum % 3 == 0)
							.map(num -> num*2)
							.forEach(result -> System.out.println(result));
	}

}
