package com.joeseff.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ONYX
 * @created 18 Feb 2020 23:13:33
 * @project Q0017 - String Tokenizer
 * 
 */

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		// Write your code here.
		if (s == null || s.isEmpty() || !s.matches("[A-Za-z !,?._'@]+"))
			throw new IllegalStateException("Illegal String");

		List<String> list = Arrays.asList(s.trim().split("!|,|\\?|\\.|_|'|@| ", 0));
		List<String> filteredList = list.stream().filter(item -> item != null && !"".equals(item)).collect(Collectors.toList());
		
		System.out.println(filteredList.size());

		for (String string : filteredList) {
			System.out.println(string);
		}

		scan.close();
	}
}
