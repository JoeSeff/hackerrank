package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Monday 23-Mar-2020
 *
 */

class Difference {
  	private int[] elements;
  	public int maximumDifference;

	public Difference(int[] elements) {
		this.elements = elements;
	}
	
	public void computeDifference() {
		int max = 0;
		for (int a = 0; a < elements.length - 1; a++) {
			for (int b = a+1; b < elements.length; b++) {
				max = getMax(max, Math.abs(elements[a] - elements[b]));
			}
		}
		this.maximumDifference = max;
	}
	
	public int getMax(int a, int b) {
		if ( a > b ) {
			return a;
		}
		
		return b;
	}

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
