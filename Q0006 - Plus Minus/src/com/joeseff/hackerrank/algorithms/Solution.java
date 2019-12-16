package com.joeseff.hackerrank.algorithms;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	DecimalFormat df = new DecimalFormat("0.000000");
    	int countPositive = 0;
    	int countNegative = 0;
    	int countZero = 0;

    	for ( int i = 0; i < arr.length; i++ ) {
    		if ( arr[i] < -100 || arr[i] > 100 ) {
    			throw new IllegalArgumentException("Invalid value for array at index ( " + i + " )" );
    		}
    		
    		if ( arr[i] >= 1 ) {
    			countPositive++;
    		} else if ( arr[i] <= -1 ) {
    			countNegative++;
    		} else {
    			countZero++;
    		}
    	}
    	double fractionPositive = (double)countPositive/arr.length;
    	double fractionNegatie = (double)countNegative/arr.length;
    	double fractionZero = (double)countZero/arr.length;
    	
    	System.out.printf(df.format(fractionPositive) + "\n");
    	System.out.printf(df.format(fractionNegatie) + "\n");
    	System.out.printf(df.format(fractionZero) + "\n");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }*/
    	
    	int[] arr = {4, 3, -9, 0, 4, 1};

        plusMinus(arr);

        // scanner.close();
    }

}
