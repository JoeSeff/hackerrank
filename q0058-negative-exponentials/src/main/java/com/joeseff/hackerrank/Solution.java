package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 24-Mar-2020
 *
 */

class Calculator {
	
	public int power(int n, int p) throws IllegalArgumentException {
		if ( n < 0 || p < 0 ) {
			throw new IllegalArgumentException("n and p should be non-negative");
		}
		
		return (int)Math.pow(n, p);
	}
	
}

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
        
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }

}
