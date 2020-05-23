package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Wednesday 18-Mar-2020
 *
 */

public class Solution {
	private static final String SCANNER_PATTERN = "(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read N from stdin
		Scanner scanner = new Scanner(System.in);
		Integer N = scanner.nextInt();
		scanner.skip(SCANNER_PATTERN);
		
		// Initialise List
		List<Integer> integerList = new ArrayList<>(N);
		String[] integerStringArr = scanner.nextLine().split(" ");
		for ( int a = 0; a < integerStringArr.length; a++ ) {
			integerList.add(Integer.parseInt(integerStringArr[a]));
		}
		
		// Read Q from stdin
		int Q = scanner.nextInt();
		scanner.skip(SCANNER_PATTERN);
		
		// for each query
		for ( int b = 0; b < Q; b++ ) {
			String operation = scanner.nextLine();
			if ( operation.equalsIgnoreCase("insert") ) {
				String[] values = scanner.nextLine().split(" ");
				integerList.add(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
			} else {
				int x = scanner.nextInt();
				scanner.skip(SCANNER_PATTERN);
				integerList.remove(x);
			}
		}
		scanner.close();
		
		// output the list
		for (Iterator<Integer> iterator = integerList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + " ");
		}
	}

}
