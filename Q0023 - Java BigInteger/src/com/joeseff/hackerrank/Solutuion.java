package com.joeseff.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ONYX
 * @created 22 Feb 2020 13:33:37 
 * @project Q0023 - Java BigInteger
 * 
 */

public class Solutuion {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);
			BigInteger aBigInteger = scanner.nextBigInteger();
			BigInteger bBigInteger = scanner.nextBigInteger();
			
			System.out.println(aBigInteger.add(bBigInteger));
			System.out.println(aBigInteger.multiply(bBigInteger));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
