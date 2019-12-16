package com.joeseff.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long min = 0l, max = 0l;

    	// Sort Array
    	Arrays.sort(arr);
    	for ( int x = 0; x < arr.length; x++ ) {
    		if ( x < 4 ) {
    			min = min + arr[x];
    		}
    		if ( x > 0 ) {
    			max = max + arr[x];
    		}
    	}
    	System.out.println(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();*/
    	int[] arr = {1, 5, 3, 8, 4};
    	miniMaxSum(arr);
    }

}
