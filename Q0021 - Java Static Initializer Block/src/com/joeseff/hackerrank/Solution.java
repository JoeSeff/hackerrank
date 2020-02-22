package com.joeseff.hackerrank;

import java.util.Scanner;

/**
 * @author ONYX
 * @created 22 Feb 2020 12:11:42
 * @project Q0021 - Java Static Initializer Block
 * 
 */

public class Solution {
	private static boolean flag = true;
	private static int B;
	private static int H;

	static {

		try {
			Scanner sc = new Scanner(System.in);
			B = sc.nextInt();
			H = sc.nextInt();
			sc.close();

			if (!(B > 0 && H > 0)) {
				throw new Exception("java.lang.Exception: Breadth and height must be positive");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			flag = false;
		}

	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}// end of class
