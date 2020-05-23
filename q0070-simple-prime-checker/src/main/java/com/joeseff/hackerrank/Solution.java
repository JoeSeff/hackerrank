package com.joeseff.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Friday 03-Apr-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger bigInteger;
			
			int limit = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			for ( int a = 0; a < limit; a++ ) {
				int num = scanner.nextInt();
				
				bigInteger = BigInteger.valueOf(num);
				
				if ( bigInteger.isProbablePrime(5) ) {
					System.out.println("Prime");
				} else {
					System.out.println("Not prime");
				}
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
