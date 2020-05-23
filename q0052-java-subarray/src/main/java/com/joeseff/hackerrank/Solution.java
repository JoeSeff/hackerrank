package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Friday 20-Mar-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getFinalCount());

	}

	public static int getFinalCount() {
		int sumOfNegativeArrays = 0;
		try (Scanner scanner = new Scanner(System.in)) {

			int arraySize = scanner.nextInt();
			int[] elementsArr = new int[arraySize];
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] stringArr = scanner.nextLine().split(" ");
			int counter = 0;
			for (int a = 0; a < stringArr.length; a++) {
				if (stringArr[a].isEmpty()) {
					continue;
				}

				elementsArr[counter] = Integer.parseInt(stringArr[a]);
				counter++;
			}

			sumOfNegativeArrays = getFinalNumberOfNegativeArrays( arraySize,  elementsArr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sumOfNegativeArrays;
	}
	
	public static int getFinalNumberOfNegativeArrays(int arraySize, int[] elementsArr) {
		int sumOfNegativeArrays = 0;
		
		if (arraySize == 0) {
			sumOfNegativeArrays = 0;
		} else if (arraySize <= 2) {
			int sum = 0;
			for (int b = 0; b < arraySize; b++) {
				if (elementsArr[b] < 0 && arraySize == 2) {
					sumOfNegativeArrays++;
				}
				sum = sum + elementsArr[b];
			}

			if (sum < 0) {
				sumOfNegativeArrays++;
			}

		} else {
			for (int c = 0; c < elementsArr.length; c++) {
				int minisum = 0;
				for ( int d = c; d < elementsArr.length; d++ ) {
					minisum = minisum + elementsArr[d];

					if (minisum < 0) {
						sumOfNegativeArrays++;
					}
				}
			}
		}

		return sumOfNegativeArrays;
	}

}
