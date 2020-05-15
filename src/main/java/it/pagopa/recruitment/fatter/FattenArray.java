package it.pagopa.recruitment.fatter;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * Flattening an array of arbitrarily nested
 * arrays of integers into a flat array of integers
 * 
 */
public class FattenArray {

	/**
	 * Method to flatten a Stream of Arrays 
	 * 
	 * @param array The array to flatten
	 * @return a Stream for the array
	 */
	private static Stream<Object> flatten(Object[] array) {
	    return Arrays.stream(array)
	                 .flatMap(o -> o instanceof Object[]? flatten((Object[])o): Stream.of(o));
	}
	
	public static void main(String[] args) {
		// Get the arrays to be flattened. 
        Object[] array = {new Object[] {1,2, new Object[] {3}},4};
  
        // Flatten the Stream 
        Integer[] flatArray = flatten(array).toArray(Integer[] ::new); 
  
        // Print the flattened array 
        System.out.println(Arrays.toString(flatArray)); 
	}
}
