package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 17-Mar-2020
 *
 */

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Read n from stdin
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		// Initialise List using n 
        List<List<Integer>> arrayList = new ArrayList<>(n);
		
		// Loop through List 
        for( int a = 0; a < n; a++ ) {
    		// - Read input from stdin
        	String subListString = scanner.nextLine();
    		
    		// - Break string into array elements
        	String[] subArr = subListString.split(" ");

    		// - Convert first element of array into integer
        	int subListSize = Integer.parseInt(subArr[0]);

    		// - Initialise each sub-List using the first element (if not = 0)
        	List<Integer> subList = null; 
        	if (subListSize != 0) {
        		subList = new ArrayList<>(subListSize);
        	} 

    		// - Loop through subList inserting elements converted to int
        	for( int b = 1; b <= subListSize; b++ ) {
        		subList.add(Integer.parseInt(subArr[b]));
        	}
        	
        	// - Add subList to main List
        	arrayList.add(subList);
        }// End of outer for loop
		
		// Read no. of queries q from stdin 
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
		// - For each subsequent line, get (x-1) subList then get (y-1) element from the sublist
        for( int c = 0; c < q; c++ ) {
        	String queryParams = scanner.nextLine();
        	String[] queryArgs = queryParams.split(" ");
        	
        	int lineX = Integer.parseInt(queryArgs[0]) - 1;
        	int positionY = Integer.parseInt(queryArgs[1]) - 1;
        	
        	// Check if coordinates exist
        	if ( lineX < arrayList.size() ) {
        		List<Integer> subList = arrayList.get(lineX);
        		if ( subList != null && positionY < subList.size() ) {
        			System.out.println(subList.get(positionY));
        		} else {
        			System.out.println("ERROR!");
        		}
        	} else {
        		System.out.println("ERROR!");
        	}
        }
		
	}
}
