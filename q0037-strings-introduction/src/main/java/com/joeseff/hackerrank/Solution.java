package com.joeseff.hackerrank;

import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 12-Mar-2020
 *
 */

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(compareStrings(A, B));
        System.out.println(capitalizeFirstLetter(A) + " " + capitalizeFirstLetter(B));
    }
    
    public static String compareStrings(String A, String B) {
    	if (A.compareToIgnoreCase(B) <= 0) {
    		return "No";
    	} else {
    		return "Yes";
    	}
    }
    
    public static String capitalizeFirstLetter(String S) {
    	if(S == null || S.isEmpty()) {
    		return S;
    	} else {
    		return S.substring(0, 1).toUpperCase() 
    				+ S.substring(1);
    	}
    }

}
