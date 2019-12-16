package com.joeseff.hackerrank.algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
	
	public static long GCD(long a, long b) {
		long remainder = 1;
		while( b != 0 ) {
			// GCD(A, B) = GCD(B, A mod B)
			remainder = a % b;
			a = b;
			b = remainder;
		}
		
		return a;
	}

    public static void main(String[] args) {
        String[] nmq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmq[0]); // Size of Array A
        int m = Integer.parseInt(nmq[1]); // Size of Array B
        int q = Integer.parseInt(nmq[2]); // Number of questions

        // Initialize Array A
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        // Initialize Array B
        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }
        
        // Create StringBuilder to hold items
        StringBuilder sb = new StringBuilder();

        // Each loop represents a sub-matrix
        for (int qItr = 0; qItr < q; qItr++) {
        	Set<Long> uniqueNumSet = new HashSet<>();
            String[] r1C1R2C2 = scanner.nextLine().split(" ");

            // Get start and finish
            // Start
            int r1 = Integer.parseInt(r1C1R2C2[0]);
            int c1 = Integer.parseInt(r1C1R2C2[1]);
            // Finish
            int r2 = Integer.parseInt(r1C1R2C2[2]);
            int c2 = Integer.parseInt(r1C1R2C2[3]);

            // Write Your Code Here
            for ( int u = r1; u <= r2; u++ ) {
            	for ( int v = c1; v <= c2; v++ ) {
            		long gcdVal = GCD(a[u], b[v]);
            		uniqueNumSet.add(gcdVal);
            	}
            }
            sb.append(uniqueNumSet.size() + "\n");
        }
    	System.out.println(sb.toString());

        scanner.close();
    }
}
