package com.joeseff.hackrrank;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String[] s = new String[3];
		int[] x = new int[3];
		
        for(int i=0;i<3;i++){
            s[i]=sc.next();
            x[i]=sc.nextInt();

            if (sc.hasNextLine()) {
            	sc.nextLine();
            }
            
        }
        sc.close();

        System.out.println("================================");
        for(int i=0;i<3;i++){
        	String num = String.format("%03d", x[i]);
        	System.out.printf("%-15s%3s\n", s[i], num);
        }
        System.out.println("================================");
	}

}
