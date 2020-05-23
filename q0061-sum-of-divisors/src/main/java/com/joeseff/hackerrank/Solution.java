package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Wednesday 25-Mar-2020
 *
 */

interface AdvancedArithmetic {
	int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
	private List<Integer> divisorList = new ArrayList<>();
	public int divisorSum(int n) {
		getDivisors(n);
		
		int sum = 0;
		if ( divisorList.size() != 0 ) {
			for ( int b = 0; b < divisorList.size(); b++ ) {
				sum = sum + divisorList.get(b);
			}
		}
		
		return sum;
	}
	
	private void getDivisors(int n) {
		for ( int a = 1; a <= n; a++) {
			if ( (n % a) == 0 ) {
				divisorList.add(a);
			}
		}
	}
}

class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculator();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}
