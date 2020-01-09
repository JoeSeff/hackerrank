package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        List< List<Integer> > rList = new ArrayList<>();
        
        int t=in.nextInt();
        for ( int i = 0; i < t; i++ ){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            if (in.hasNextLine()) {
            	in.nextLine();
            }
                        
            List<Integer> cList = new ArrayList<>();
            for ( int j = 1; j <= n; j++ ) {
            	int multiple = 0;
            	
            	for ( int k = 0; k < j; k++ ) {
            		multiple = multiple + (int)Math.pow(2, k) * b;
            	}
            	
            	cList.add(a + multiple);
            }
            rList.add(cList);
        }
        in.close();
        
        // output        
        for ( List<Integer> cList : rList ) {
        	for ( Integer result : cList ) {
        			System.out.print(result + " ");
        	}
        	System.out.println();
        }
    }

}
