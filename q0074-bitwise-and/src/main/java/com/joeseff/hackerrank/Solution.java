package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 07-Apr-2020
 *
 */

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            
            int[] arr = new int[n];
            for ( int a = 0; a < arr.length; a++ ) {
            	arr[a] = a+1;
            }
            
            int maxVal = 0;
            int res = 0;
            for (int b = arr.length -1; b > 0; b--) {
            	for (int c = arr.length - 2; c >= 0; c--) {
            		int B = arr[b];
            		int A = arr[c];
            		res = A & B;
            		
            		if ( res < k && A < B ) {            			
            			if ( res > maxVal) {
            				maxVal = res;
            			}
            		}
            	}
            }
            
            
            System.out.println(maxVal);
        }

        scanner.close();
    }
}
