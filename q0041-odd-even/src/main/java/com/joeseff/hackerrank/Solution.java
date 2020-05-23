package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 12-Mar-2020
 *
 */

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int iterations = scan.nextInt();
		scan.nextLine();
		String input = "";

		for (int k = 0; k < iterations; k++) {
			input = scan.nextLine();
			char[] charArr = input.toCharArray();

			String oddWord = "";
			String evenWord = "";

			for (int m = 0; m < input.length(); m++) {
				if ((m % 2) == 0) {
					evenWord = evenWord + String.valueOf(charArr[m]);
				} else {
					oddWord = oddWord + String.valueOf(charArr[m]);
				}
			}
			System.out.println(evenWord + "  " + oddWord);
		}

		scan.close();

	}

}
