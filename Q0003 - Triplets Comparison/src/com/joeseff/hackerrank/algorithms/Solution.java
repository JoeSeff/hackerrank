package com.joeseff.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	int pointsA = 0;
    	int pointsB = 0;
    	List<Integer> resultList = new ArrayList<>();

    	for ( int j = 0; j < 3; j++ ) {
    		if ( a.get(j) < 1 || a.get(j) > 100 || b.get(j) < 1 || b.get(j) > 100 )
    			throw new IllegalArgumentException("Value is invalid. Comparison not done.");
    		
    		if ( a.get(j) > b.get(j) ) {
    			// Alice has more points that Bob
    			pointsA = pointsA + 1;
    		} else if ( a.get(j) < b.get(j) ) {
    			// Bob has more points than Alice
    			pointsB = pointsB + 1;
    		}
    	}
    	resultList.add(pointsA);
    	resultList.add(pointsB);
    	return resultList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
