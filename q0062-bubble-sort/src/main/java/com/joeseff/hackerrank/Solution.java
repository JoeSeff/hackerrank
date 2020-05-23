package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 26-Mar-2020
 *
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        // Write Your Code Here
        bubbleSort(a);
    }

	/**
	 * @param a
	 */
	private static void bubbleSort(int[] a) {
		int totalNumberOfSwaps = 0;
		
		for ( int i = 0; i < a.length; i++ ) {
			int numOfSwaps = 0; // no of swaps per iteration
			
			for ( int j = 0; j < a.length - 1; j++ ) {
				if ( a[j] > a[j+1] ) {
					swap(a, j, j+1);
					numOfSwaps++;
				}
			}
			
			if ( numOfSwaps == 0 ) {
				break; // array is sorted
			}
			totalNumberOfSwaps = totalNumberOfSwaps + numOfSwaps;
		}
		
		System.out.printf("Array is sorted in %d swaps.\n", totalNumberOfSwaps);
		System.out.printf("First Element: %d\n", a[0]);
		System.out.printf("Last Element: %d\n", a[a.length-1]);		
	}

	/**
	 * @param a
	 * @param j
	 * @param i
	 */
	private static void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

}
