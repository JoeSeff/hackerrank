package com.joeseff.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Saturday 14-Mar-2020
 *
 */

public class Solution {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			
			int a = scanner.nextInt();
			scanner.nextLine();
			int b = scanner.nextInt();
			
			if ( a > (Math.pow(2, 31) - 1) 
					|| b > (Math.pow(2, 31) - 1)) {
				throw new InputMismatchException("");
			}
			
			System.out.println(a/b);
		} catch(ArithmeticException ae) {
			System.out.println(ae);
		} catch(InputMismatchException ime) {
			System.out.println(ime.getClass().getName());
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
