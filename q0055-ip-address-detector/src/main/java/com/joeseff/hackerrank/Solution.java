package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Monday 23-Mar-2020
 *
 */

class MyRegex {
	public static final String pattern = "\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b";
}

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
