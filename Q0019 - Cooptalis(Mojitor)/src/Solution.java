import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * @author ONYX
 * @created 21 Feb 2020 23:56:27 
 * @project Q0019 - Cooptalis(Mojitor)
 * 
 */

class Result {

    /*
     * Complete the 'mojitor' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER startOfCount
     *  2. INTEGER endOfCount
     */

    public static String mojitor(int startOfCount, int endOfCount) {
    	int lineLimit = 11;
    	
    	String line = "";
    	for ( int i = startOfCount; i <= endOfCount; i++ ) {
    		String word = "" + i;
    		
    		if ( ((i % 3) == 0) && ((i % 5) == 0) && ((i % 7) == 0) ) {
				word = "MentheGlaceRhum=Mojito";
			} else if ( ((i % 5) == 0) && ((i % 7) == 0) ) {
				word = "GlaceRhum";
			} else if ( ((i % 3) == 0) && ((i % 7) == 0) ) {
				word = "MentheRhum";
			} else if ( ((i % 3) == 0) && ((i % 5) == 0) ) {
				word = "MentheGlace";
			}  else if ( ((i % 7) == 0) ) {
				word = "Rhum";
			} else if ( ((i % 5) == 0) ) {
				word = "Glace";
			} else if ( ((i % 3) == 0)  ) {
				word = "Menthe";
			} else {
				word = i + "";
			}
    		
    		line = line + word + " ";
    		
    		if ( (i % lineLimit) == 0 ) {
        		line = line.trim() + "\n";
        	} 

    	}
    	
    	return line;
    }

}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	System.out.println( Result.mojitor(1, 110) );
	}

}
