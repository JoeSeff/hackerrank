package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 05-Mar-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        // Declare vars
        boolean isByte;
        boolean isShort;
        boolean isInt;
        boolean isLong;
        String dataTypes;

        for(int i=0;i<t;i++)
        {
        	// Initialise vars
        	isByte = false;
        	isShort = false;
        	isInt = false;
        	isLong = false;
        	dataTypes = "";

            try
            {
                long n=sc.nextLong();
                
                // Verbose but saves program execution time
                isByte = isByte(n);
                
                if (!isByte) {
                	isShort = isShort(n);
                }
                
                if (!isShort) {
                	isInt = isInt(n);
                }
                
                if (!isInt) {
                	isLong = isLong(n);
                }
                
                // Construct the data types
                if ( isByte ) {
                	dataTypes = "* byte\n";
                }
                
                if ( isByte || isShort ) {
                	dataTypes = dataTypes + "* short\n";
                }
                
                if ( isByte || isShort || isInt ) {
                	dataTypes = dataTypes + "* int\n";
                }
                
                if ( isByte || isShort || isInt || isLong ) {
                	dataTypes = dataTypes + "* long\n";
                }
                
                // final result
                System.out.println(n + " can be fitted in:");
                System.out.print(dataTypes);
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }

	}
	
	// check byte
	public static boolean isByte(long num) {
		if ( num >= -128 && num <= 127 ) {
			return true;
		}
		return false;
	}
	
	// check short
	public static boolean isShort(long num) {
		if ( num >= -32768 && num <= 32767 ) {
			return true;
		}
		return false;
	}
	
	// check int
	public static boolean isInt(long num) {
		if ( num >= (-1 * Math.pow(2, 31)) && num <= (Math.pow(2, 31) - 1) ) {
			return true;
		}
		return false;
	}
	
	// check long
	public static boolean isLong(long num) {
		if ( num >= (-1 * Math.pow(2, 63)) && num <= (Math.pow(2, 63) - 1) ) {
			return true;
		}
		return false;
	}

}
