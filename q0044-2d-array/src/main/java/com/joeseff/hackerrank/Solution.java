package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Friday 13-Mar-2020
 *
 */

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static int getMaximum(int x, int y) {
		if (x > y)
			return x;

		return y;
	}

	public static int sumHourGlass(int[][] arr, int r, int c) {
		int sum = 0;
		if ((r + 2) < arr.length && (c + 2) < arr[r].length && (c + 1) < arr[r + 1].length
				&& (c + 2) < arr[r + 2].length) {
			sum = arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 1] + arr[r + 2][c] + arr[r + 2][c + 1]
					+ arr[r + 2][c + 2];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String line = scanner.nextLine();
			String[] arrRowItems = line.split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		scanner.close();

		// Results
		int[] resultsArray = new int[16];
		int counter = 0;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				resultsArray[counter] = sumHourGlass(arr, r, c);
				counter++;
			}
		}

		int maximum = resultsArray[0];
		for (int n = 1; n < resultsArray.length; n++) {
			maximum = getMaximum(maximum, resultsArray[n]);
		}

		System.out.println(maximum);
	}

}
