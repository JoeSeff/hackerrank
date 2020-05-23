package com.joeseff.hackerrank;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * @author JWachiuri
 * @created Friday 03-Apr-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			String actualReturnDateString = scanner.nextLine().trim().replace(" ", "/");
			String expectedReturdDateString = scanner.nextLine().trim().replace(" ", "/");
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date actualReturnDate = simpleDateFormat.parse(actualReturnDateString);
			Date expectedReturnDate = simpleDateFormat.parse(expectedReturdDateString);
			
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate actualDate = LocalDate.parse(simpleDateFormat.format(actualReturnDate));
			LocalDate expectedDate = LocalDate.parse(simpleDateFormat.format(expectedReturnDate));
			
			if ( actualReturnDate.after(expectedReturnDate) ) {
				
				Calendar calendar = Calendar.getInstance();
				
				calendar.setTime(actualReturnDate);
				int actualMonth = calendar.get(Calendar.MONTH);
				int actualYear = calendar.get(Calendar.YEAR);
				
				calendar.setTime(expectedReturnDate);
				int expectedMonth = calendar.get(Calendar.MONTH);
				int expectedYear = calendar.get(Calendar.YEAR);
				
				long diffInMillies = actualReturnDate.getTime() - expectedReturnDate.getTime();
				long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				
				long fine = 0;
				if ( actualMonth == expectedMonth && actualYear == expectedYear ) {
					fine = diffInDays * 15;
				} else if ( actualMonth!= expectedMonth && actualYear == expectedYear ) {
					long diffInMonths = ChronoUnit.MONTHS.between(expectedDate, actualDate);
					fine = diffInMonths * 500;
				} else {
					fine = 10000;
				}
				System.out.println(fine);
				
			} else {
				System.out.println("0");
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
