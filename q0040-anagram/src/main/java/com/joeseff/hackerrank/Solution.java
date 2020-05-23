package com.joeseff.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 12-Mar-2020
 *
 */

public class Solution {
	static boolean isAnagram(String a, String b) {
        char[] aArr = a.toLowerCase().toCharArray();
        char[] bArr = b.toLowerCase().toCharArray();
        
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        
        String sortedA = new String(aArr);
        String sortedB = new String(bArr);
        
        return sortedA.equalsIgnoreCase(sortedB);
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
