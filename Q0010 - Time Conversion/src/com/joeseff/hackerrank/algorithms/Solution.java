package com.joeseff.hackerrank.algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
    	SimpleDateFormat hourFormat12 = new SimpleDateFormat("hh:mm:ssa");
    	SimpleDateFormat hourFormat24 = new SimpleDateFormat("HH:mm:ss");
    	try {
			return hourFormat24.format(hourFormat12.parse(s));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return "";
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();*/
    	System.out.println(timeConversion("07:05:45PM"));
    }

}
