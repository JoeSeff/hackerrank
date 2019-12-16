package com.joeseff.hackrrank.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

	/*
	 * Complete the 'diagonalDifference' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {
		int sumLeft = 0;
		int sumRight = 0 ;
		
		for ( int i = 0; i < arr.size(); i++ ) {
			List<Integer> innerArr = arr.get(i);
			int innerArrLength = innerArr.size() - 1;
			
			for ( int j = 0; j < innerArr.size(); j++ ) {
				
				if ( innerArr.get(j) < -100 || innerArr.get(j) > 100 ) {
					throw new IllegalArgumentException("Invalid value for array at index ( " + i + ", " + j + " )" );
				}
				
				if ( i == j ) {
					sumLeft = sumLeft + innerArr.get(j);
				}
				
				if ( (innerArrLength - i) == j ) {
					sumRight = sumRight + innerArr.get(j);
				}
			}
		}

		int difference = sumLeft - sumRight;
		return Math.abs(difference);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> arrRowItems = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				int arrItem = Integer.parseInt(arrRowTempItems[j]);
				arrRowItems.add(arrItem);
			}

			arr.add(arrRowItems);
		}

		int result = Result.diagonalDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
