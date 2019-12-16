package com.joeseff.hackerrank.algorithms;

import java.util.Scanner;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
    	
    	for ( int a = 1; a <= n; a++ ) {
    		int count = 0;
    		for ( int b = 1; b <= n - a; b++) {
    			System.out.print(" ");
    			count++;
    		}
    		
    		for ( int c = n - count; c > 1; c-- ) {
    			System.out.print("#");
    		}
    		System.out.println("#");
    		
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }

}
