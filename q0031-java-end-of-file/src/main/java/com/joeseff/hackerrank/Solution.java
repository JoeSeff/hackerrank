package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 05-Mar-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int counter = 1;
			String output = "";
			
			while(scanner.hasNextLine()) {
				if ( counter == 1 ) {
					output = output + counter + " " + scanner.nextLine();
				} else {
					output = output + "\n" + counter + " " + scanner.nextLine();
				}
				counter++;
			}
			System.out.println(output);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
