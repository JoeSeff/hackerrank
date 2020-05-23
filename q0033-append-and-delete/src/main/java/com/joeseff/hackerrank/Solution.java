package com.joeseff.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.kerberos.KerberosKey;

/*
 * @author JWachiuri
 * @created Tuesday 10-Mar-2020
 *
 */

public class Solution {

	private static boolean isEven(int k) {
		return (k % 2) == 0 ? true : false;
	}

	// Complete the appendAndDelete function below.
	static String appendAndDelete(String s, String t, int k) {

    	// Get length of each String
    	int sLen = s.length();
    	int tLen = t.length();
    	
    	// Use the length of the smaller String as the upper limit
    	int upperLimit = (sLen > tLen) ? tLen : sLen;
    	    	
    	// Convert both Strings into char arrays
    	char[] sArray = s.toCharArray();
    	char[] tArray = t.toCharArray();
     	
    	// Loop through both checking if the characters match
    	int noOfMatchingChars = 0;
    	for ( int i = 0; i < upperLimit; i++ ) {
    		
    		if ( sArray[i] == tArray[i] ) {
    			noOfMatchingChars++;
    		} else {
    			break;
    		}
    	}
    	
    	/*if ( noOfMatchingChars == 0 && k >= (sLen + tLen) ) {
    		return "Yes";
    	}*/
    	
    	if ( k >= (sLen + tLen) ) {
    		return "Yes";
    	}
    	if (noOfMatchingChars > 0 && sLen > tLen && isEven(k - (sLen - noOfMatchingChars))) {
			return "Yes";
		} else if (noOfMatchingChars > 0 && sLen < tLen && isEven(k - (tLen - noOfMatchingChars))) {
			return "Yes";
		} else if (noOfMatchingChars > 0 && sLen == tLen ) {
			if ( (k == (sLen - noOfMatchingChars) * 2) 
					|| ( k <= (sLen * 2) && isEven(k) && k > ( ( (sLen - noOfMatchingChars) * 2) + 1 ) ) 
					|| k > (sLen * 2)
				) {
				return "Yes";
			} else {
				return "No";
			}
		} else {
    		return "No";
    	}
    		
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String t = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = appendAndDelete(s, t, k);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
