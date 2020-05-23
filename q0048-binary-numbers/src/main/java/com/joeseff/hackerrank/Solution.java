package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 17-Mar-2020
 *
 */

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static int getMaximum(int counter, int largest) {
    	if ( counter > largest ) {
			return counter;
		} 
    	return largest;
    }
    
    private static int maxConsecutiveOnes(int n) {
    	String binaryString = Integer.toBinaryString(n);
    	int counter = 0;
    	int largest = 0;
    	int index = 0;
    	
    	char[] charArr = binaryString.toCharArray();
    	int[] resultsArr = new int[binaryString.length()];
    	
    	for( int i = 0; i < binaryString.length(); i++ ) {
    		if (charArr[i] == '1') {
    			counter++;
    		} else {    			
    			resultsArr[index] = counter;
    			index++;
    			counter = 0;
    		}
    		if (i == (binaryString.length() -1) && (charArr[i] == '1')) {
    				resultsArr[index] = counter;    				
    		}
    	}
    	
    	for(int x = 0; x < resultsArr.length; x++) {
    		largest = getMaximum(resultsArr[x], largest);
    	}
    	
    	return largest;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        
        System.out.println(maxConsecutiveOnes(n));
    }

}
