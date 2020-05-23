package com.joeseff.hackerrank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
 * @author JWachiuri
 * @created Friday 13-Mar-2020
 *
 */

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		while(testCases>0){
			String pattern = in.nextLine();
          	
			try {
				Pattern.compile(pattern);
				System.out.println("Valid");
			} catch (PatternSyntaxException pse) {
				System.out.println("Invalid");
			}
			testCases--;
		}
	}

}
