package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Friday 03-Apr-2020
 *
 */

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        List<String> firstNameList = new ArrayList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            
            if ( emailID.contains(firstName) && emailID.contains("@gmail.com") ) {
            	firstNameList.add(firstName);
            }
        }
        scanner.close();
        
        Collections.sort(firstNameList);
        for ( String name : firstNameList) {
        	System.out.println(name);
        }
    }
}
