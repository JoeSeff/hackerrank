package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 24-Mar-2020
 *
 */

public class Solution {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        try {
			Integer.parseInt(S);
			System.out.println(S);
		} catch (Exception e) {
			System.out.println("Bad String");
		}
		
	}
}
