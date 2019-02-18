package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;

public class PrintDoubles {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of numbers and that has been assigned to a List of Integers.
		 */
		List<Integer> someNumbers = Arrays.asList(11, 33, 44, 66, 77);
		
		/**
		 * Each number in 'someNumbers' is iterated and assigned to 'num' variable one by one.
		 * at the end, all the numbers will be doubled and printed.  
		 */
		someNumbers.forEach(num -> System.out.println(num * 2));
	}

}
