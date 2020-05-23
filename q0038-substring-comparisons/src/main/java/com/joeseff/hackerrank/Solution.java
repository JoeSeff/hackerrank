package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 12-Mar-2020
 *
 */

public class Solution {
	
	public static String getSmallest(String sOne, String sTwo) {
		if (sOne.compareTo(sTwo) <= 0) {
			return sOne;
		}
		return sTwo;
	}
	
	public static String getLargest(String sOne, String sTwo) {
		if (sOne.compareTo(sTwo) > 0) {
			return sOne;
		} 
		return sTwo;
	}

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        char oArray[] = s.toCharArray();
        String sArray[] = new String[s.length() - (k-1)];
        
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        // intialize array values
        for(int m = 0; m < sArray.length; m++) {
        	sArray[m] = "";
        }
        	
        // Populate with substrings
        for(int i = 0; i < s.length() - (k-1); i++ ) {
        	for (int j = i; j < (i+k); j++) {
        		sArray[i] = sArray[i] + oArray[j];
        	}
        }
        
        smallest = sArray[0];
        largest = sArray[0];
        
        for( int x = 1; x < sArray.length; x++ ) {
        	smallest = getSmallest(smallest, sArray[x]);
        	largest = getLargest(largest, sArray[x]);
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
