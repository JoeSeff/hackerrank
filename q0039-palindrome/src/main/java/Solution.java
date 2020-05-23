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
        
        StringBuilder sBuilder = new StringBuilder(A);
        String reversedString = sBuilder.reverse().toString();
        
        if (reversedString.equalsIgnoreCase(A)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
        
    }

}
