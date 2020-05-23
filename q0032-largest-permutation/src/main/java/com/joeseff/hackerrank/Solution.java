package com.joeseff.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Monday 09-Mar-2020
 *
 */

public class Solution {
	
	// Check if array is sorted already if so, return
	public static boolean isArrayReverseSorted(int[] originalArray) {
		int[] copyArray = new int[originalArray.length];
		
		// Sorting int Array in descending order
		for(int i = 0; i < originalArray.length; i++ ) {
			copyArray[i] = originalArray[i] * -1;
		}
		Arrays.sort(copyArray);
		for(int i = 0; i < copyArray.length; i++ ) {
			copyArray[i] = copyArray[i] * -1;
		}
		
		return Arrays.equals(originalArray, copyArray);
	}
	
	// Function to find the index of an element in a primitive array in Java
	public static int findIndex(int[] a, int target, int start)
	{
		for (int i = start; i < a.length; i++)
			if (a[i] == target)
				return i;

		return -1;
	}
	
	public static int[] swap(int[] a, int largestIndex, int swapItemIndex) {	
		int temp = a[swapItemIndex];
		a[swapItemIndex] = a[largestIndex];
		a[largestIndex] = temp;
		
		return a;
	}

    // Complete the largestPermutation function below.	
    static int[] largestPermutation(int k, int[] arr) {
    	if (isArrayReverseSorted(arr))
    		return arr;
    	
    	int counter = 0;
    	for(int i = 0; (i < arr.length && counter < k); i++ ) {
    		int largest = arr.length - i;
    		int largestIndex = findIndex(arr, largest, i);
    		if ( arr[largestIndex] != arr[i] ) {
        		swap(arr, largestIndex, i);
        		counter++;
    		}
    	}

    	return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
