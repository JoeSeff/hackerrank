package com.joeseff.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static Map<String, Long> lookupMap = new HashMap<>();

	public static long GCD(long a, long b) {
		long remainder = 1;
		while (b != 0) {
			// GCD(A, B) = GCD(B, A mod B)
			remainder = a % b;
			a = b;
			b = remainder;
		}

		return a;
	}

	// extended Euclidean Algorithm
	public static long gcdExtended(long a, long b, long x, long y) {

		// Base Case
		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}

		long x1 = 1, y1 = 1; // To store results of recursive call
		long gcd = gcdExtended(b % a, a, x1, y1);

		// Update x and y using results of recursive
		// call
		x = y1 - (b / a) * x1;
		y = x1;

		return gcd;
	}

	// Function to implement Stein's 
    // Algorithm 
    public static long binaryGcd(long a, long b) 
    { 
        // GCD(0, b) == b; GCD(a, 0) == a,  
        // GCD(0, 0) == 0 
        if (a == 0) 
            return b; 
        if (b == 0) 
            return a; 
  
        // Finding K, where K is the greatest  
        // power of 2 that divides both a and b 
        int k; 
        for (k = 0; ((a | b) & 1) == 0; ++k)  
        { 
            a >>= 1; 
            b >>= 1; 
        } 
  
        // Dividing a by 2 until a becomes odd  
        while ((a & 1) == 0) 
            a >>= 1; 
  
        // From here on, 'a' is always odd. 
        do { 
            // If b is even, remove  
            // all factor of 2 in b 
            while ((b & 1) == 0) 
                b >>= 1; 
  
            // Now a and b are both odd. Swap  
            // if necessary so a <= b, then set  
            // b = b - a (which is even) 
            if (a > b)  
            { 
  
                // Swap u and v. 
                long temp = a; 
                a = b; 
                b = temp; 
            } 
  
            b = (b - a); 
        } while (b != 0); 
  
        // restore common factors of 2  
        return a << k; 
    } 

	public static void main(String[] args) {
		Instant start = Instant.now();
		long x = 1, y = 1;

		try {
			File inputFile = new File("test07.txt");
			Scanner scanner = new Scanner(inputFile);
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
			Set<Long> uniqueNumSet = null;
			for (int qItr = 0; qItr < q; qItr++) {
				Instant startOfSubMatrix = Instant.now();
				System.out.println("SubMatrix Loop #" + qItr);

				uniqueNumSet = new HashSet<>();
				String[] r1C1R2C2 = scanner.nextLine().split(" ");

				// Get start and finish
				// Start
				int r1 = Integer.parseInt(r1C1R2C2[0]);
				int c1 = Integer.parseInt(r1C1R2C2[1]);
				// Finish
				int r2 = Integer.parseInt(r1C1R2C2[2]);
				int c2 = Integer.parseInt(r1C1R2C2[3]);

				// Write Your Code Here
				for (int u = r1; u <= r2; u++) {
					for (int v = c1; v <= c2; v++) {
						// long gcdVal = GCD(a[u], b[v]);
						// long gcdVal = gcdExtended(a[u], b[v], x, y);
						long gcdVal = binaryGcd(a[u], b[v]);
						uniqueNumSet.add(gcdVal);
					}
				}
				sb.append(uniqueNumSet.size() + "\n");

				Instant endOfSubMatrix = Instant.now();
				long seconds = Duration.between(startOfSubMatrix, endOfSubMatrix).getSeconds();
				System.out.println("Time in loop: " + seconds + "s");
			}

			System.out.println(sb.toString());

			scanner.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
}
