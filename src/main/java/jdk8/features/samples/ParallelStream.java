package jdk8.features.samples;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
	
	public static void main(String[] args) {
		
		/**
		 * a list of numbers for testing purpose only.
		 */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		/**
		 * to measure how much time stream takes, two variables are being used - start and end.
		 * first, convert List of numbers into Stream.
		 * map each number to its double number by calling 'doubleIt()' static method.
		 * 'doubleIt()' sleeps for 1 second for each call, which means it will take at least 6 seconds
		 * to process all 6 numbers given in this example.
		 * At the end, convert Stream into LIst again and print it.
		 */
		Long start = System.currentTimeMillis();
		System.out.println(numbers.stream()
									.map(value -> doubleIt(value))
									.collect(toList()));
		Long end = System.currentTimeMillis();
		System.out.println("It took " + (end - start) + " mili seconds to complete Stream");
		
		/**
		 * everything is same as above except using 'ParallelStream' instead of 'Stream'.
		 * since for each call sleep time is 1 seconds, ideally it takes more than 6 seconds 
		 * to process 6 numbers in normal 'Stream'. But, using 'ParallelStream' all the 
		 * possible cores will be used and multiple threads will run concurrently.
		 * as a result, it will be completed way before 6 seconds. 
		 */
		start = System.currentTimeMillis();
		System.out.println(numbers.parallelStream()
									.map(value -> doubleIt(value))
									.collect(toList()));
		end = System.currentTimeMillis();
		System.out.println("It took " + (end - start) + " mili seconds to complete ParallelStream");
	}
	
	/**
	 * this static method initially sleeps for 1 second for each call.
	 * at the end, it returns only double of the number given as argument. 
	 */
	public static int doubleIt(int number){
		try{Thread.sleep(1000);} 
		catch(Exception ex){}
		return number * 2;
	}
	

}
