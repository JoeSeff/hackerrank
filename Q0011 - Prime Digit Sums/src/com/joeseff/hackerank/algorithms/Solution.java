package com.joeseff.hackerank.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);
	
	static int getSum(String number) {
		int num = Integer.valueOf(number);
		int rem = 0, sum = 0;

		while (num > 0) {
			rem = num % 10;
			sum = sum + rem;
			num = num / 10;
		}
		return sum;
	}

	static int primeDigitSums(int n) {
		Integer[] intArr = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		List<Integer> primeList = Arrays.asList(intArr);
		int numOfPrimes = 0;
		int sum = 0;

		int divisor = (int) Math.pow(10, 9) + 7;
		String lowNumber = "1";
		String highNumber = "9";
		for (int a = 1; a < n; a++) {
			lowNumber = lowNumber + "0";
			highNumber = highNumber + "9";
		}

		// System.out.println("Low number: " + lowNumber);

		long lowNum = Long.valueOf(lowNumber);
		long highNum = Long.valueOf(highNumber);

		for (long x = lowNum; x <= highNum; x++) {
			boolean isPrime = true;

			String currentNumber = String.valueOf(x);
			// char[] currentNumberArr = currentNumber.toCharArray();

			for (int i = 0; (i <= currentNumber.length() - 3) && isPrime; i++) {

				// Get sum of consecutive three numbers
				if ((i + 3) <= currentNumber.length()) {
					sum = getSum(currentNumber.substring(i, i + 3));
					if (!primeList.contains(sum))
						isPrime = false;
				}

				// Get sum of consecutive four numbers
				if ((i + 4) <= currentNumber.length()) {
					sum = getSum(currentNumber.substring(i, i + 4));
					if (!primeList.contains(sum))
						isPrime = false;

				}

				// Get sum of consecutive five numbers
				if ((i + 5) <= currentNumber.length()) {
					sum = getSum(currentNumber.substring(i, i + 5));
					if (!primeList.contains(sum))
						isPrime = false;

				}
			}

			if (isPrime) {
				numOfPrimes++;
				// System.out.println(currentNumber);
			}
		}
		int modulus = numOfPrimes % divisor;

		return modulus;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int q = Integer.parseInt(scanner.nextLine().trim());
		 * 
		 * for (int qItr = 0; qItr < q; qItr++) { int n =
		 * Integer.parseInt(scanner.nextLine().trim());
		 * 
		 * int result = primeDigitSums(n);
		 * 
		 * bufferedWriter.write(String.valueOf(result));
		 * bufferedWriter.newLine(); }
		 * 
		 * bufferedWriter.close();
		 */
		/*
		 * long baseNumber = 2l;
		 * 
		 * if (isPrimeNumber(baseNumber)) { System.out.println(baseNumber +
		 * " is a prime number!"); } else { System.out.println(baseNumber +
		 * " is NOT a prime number!"); }
		 */

		System.out.println("Number of prime numbers: " + primeDigitSums(8));
	}

}
