package com.joeseff.hackerrank;

import java.util.*;
/*
 * @author JWachiuri
 * @created Saturday 14-Mar-2020
 *
 */

interface AdvancedArithmetic{
  int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

	@Override
	public int divisor_sum(int n) {
		int sum  = 0;
		
		Set<Integer> divisorSet = getDivisors(n);
		for (Integer num : divisorSet) {
			sum = sum + num;
		}
		
		return sum;
	}
	
	public Set<Integer> getDivisors(int n) { 
		Set<Integer> divisorSet = new HashSet<>();
		
        // Note that this loop runs till square root 
        for (int i=1; i<=Math.sqrt(n); i++) 
        { 
            if (n%i==0) 
            { 
                // If divisors are equal, print only one 
                if (n/i == i) 
                    divisorSet.add(i); 
                else { 
                	// Otherwise print both 
                    divisorSet.add(i);
                    divisorSet.add(n/i);
                }
            } 
        }
        return divisorSet;
    } 
	
}

public class Solution {
	public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
