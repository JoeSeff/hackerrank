package com.joeseff.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * @author JWachiuri
 * @created Tuesday 07-Apr-2020
 *
 */

public class Solution {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			Deque<Integer> deque = new ArrayDeque<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
               deque.add(num);
            }

            
            Integer max = 0;
            int counter = 0;
            int counter2 = 0;
            Set<Integer> set = new HashSet<>(m*2);
            int[] array = new int[n];
            
            for (int b = 0; b < n; b++) {
            	array[counter2] = deque.pop();
            	
            	counter++;
            	counter2++;
            	
            	if ( counter == m ) {
                    
            		for (int i = m; i > 0; i--) {
						set.add(array[counter2 - i]);
					}
            		
            		Integer size = set.size();
            		if ( size > max ) {
            			max = size;
            		}
            		
            		set = new HashSet<>(m*2);
            		counter--;
            	}
            }
            
            System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
