package com.joeseff.hackerrank;

import java.security.MessageDigest;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 07-Apr-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			String input = scanner.nextLine();
			System.out.println(getMessageHash(input, "SHA-256"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getMessageHash(String message, String algorithm) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(message.getBytes());
			byte[] hashedBytes = messageDigest.digest();
			
			return convertByteArrayToHexString(hashedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String convertByteArrayToHexString(byte[] hashedBytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for ( int a = 0; a < hashedBytes.length; a++ ) {
			String temp = Integer.toString( (hashedBytes[a] & 0xff) + 0x100, 16 ).substring(1);
			stringBuilder.append(temp);
		}
		
		return stringBuilder.toString();
	}

}
