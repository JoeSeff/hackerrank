package com.joeseff.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 12-Mar-2020
 *
 */

public class Solution {
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		Map<String, String> phonebookMap = new HashMap<>(n);
		
		in.nextLine();
		for(int i=0;i<n;i++)
		{
            String[] inputArr = in.nextLine().split(" ");
            String name=inputArr[0];
            String phone=inputArr[1];
			
			phonebookMap.put(name, phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
			if (phonebookMap.containsKey(s)) {
				System.out.printf("%s=%s\n", s, phonebookMap.get(s));
			} else {
				System.out.println("Not found");
			}
		}
		in.close();
	}

}
