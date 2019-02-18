package jdk8.features.samples;

import java.util.Arrays;
import java.util.List;

public class PrintListItems {
	
	public static void main(String[] args) {
		
		/**
		 * we have an array of strings and that has been assigned to a List of Strings.
		 */
		List<String> someStrings = Arrays.asList("abcd", "efgh", "ijk", "lmno", "pqr");
		
		/**
		 * forEach() is a new method in 'List' interface.
		 * the argument to forEach() is an 'Lambda Expression'.
		 * 'Lambda Expression' can be used in place of 'Functional Interfaces' only.
		 * the parameter type of 'forEach()' is of type 'Consumer'.
		 * 'accept()' is the abstract method of 'Consumer' Functional Interface.
		 * 'accept()' receives an input parameter and returns nothing.
		 * the left side of the 'Lambda Expression' shown in this example is the input parameter to 'accept()'.
		 * the right side of the 'Lambda Expression' shown in this example is the body of 'accept()'.
		 * all the strings is iterated one by one and each of them is assigned to 'str' variable used in Lambda.
		 * at the end, all the strings will be printed.    
		 */
		someStrings.forEach((String str) -> System.out.println(str));
	}

}
