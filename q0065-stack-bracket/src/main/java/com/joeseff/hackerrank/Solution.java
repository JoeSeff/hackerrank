package com.joeseff.hackerrank;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author JWachiuri
 * @created Friday 27-Mar-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		try {
			Scanner sc = new Scanner(System.in);

			Map<Character, Character> bracketMap = new HashMap<>();
			bracketMap.put('[', ']');
			bracketMap.put('{', '}');
			bracketMap.put('(', ')');

			while (sc.hasNext()) {
				char[] inputArr = sc.nextLine().toCharArray();
				bracketChecker(inputArr, bracketMap);
			}
			char[] inputArr = sc.nextLine().toCharArray();
			bracketChecker(inputArr, bracketMap);

		} catch (NoSuchElementException nse) {
			// TODO: handle exception
		}
		
	}
	
	private static void bracketChecker(char[] inputArr, Map<Character, Character> bracketMap) {
		if ((inputArr.length % 2) != 0) {
			System.out.println("false");
			return;
		}

		Stack<Character> charStack = new Stack<>();
		boolean matchStatus = true;
		for ( int a = 0; a < inputArr.length; a++ ) {
			if (bracketMap.containsKey(inputArr[a])) {
				charStack.push(inputArr[a]);
			} else {
				try {
					
					Character c = charStack.pop();
					Character matchingChar = bracketMap.get(c);
					if ( matchingChar != inputArr[a] ) {
						matchStatus = false;
						break;
					} 
					
				} catch (EmptyStackException e) {
					matchStatus = false;
					break;
				}
			}
		}
		System.out.println(matchStatus);

		
	}

}
