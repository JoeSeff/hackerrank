package com.joeseff.hackerrank;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * @author JWachiuri
 * @created Sunday 22-Mar-2020
 *
 */

public class SolutionTest {

	/**
	 * Test method for
	 * {@link com.joeseff.hackerrank.Solution#getFinalNumberOfNegativeArrays(int, int[])}.
	 */
	@Test
	public void testGetFinalNumberOfNegativeArrays() {
		int[] elementsArr = { 1, -2, 4, -5, 1 };
		int arraySize = 5;
		assertEquals(9, Solution.getFinalNumberOfNegativeArrays(arraySize, elementsArr));
		
		int[] elementsArr2 = {-100};
		arraySize = 1;
		assertEquals(1, Solution.getFinalNumberOfNegativeArrays(arraySize, elementsArr2));

		int[] elementsArr3 = { 463, 589, -321, 164, -613, 246, -869, -889, -712, -251, 969, -603, 49, 185, 439, 479,
				255, -660, 848, 157, 644, 498, -722, 82, -275, -645, -268, -255, 573, 910, 303, 267, -162, 487, 103,
				-823, 400, 612, -61, -260, 732, 286, 505, -22, 37, 443, 27, 603, 341, -904, -87, -895, -753, 314, 257,
				856, 832, -695, -387, 416, 354, 117, 273, -275, 811, -114, -962, -90, 868, 883, -330, 467, 233, 852,
				232, -44, 831, -672, -883, -774, -830, 297, -897, -860, 143, 594, 186, -988, 928, 391, -812, 99, 302,
				-803, -422, 583, 817, 748, -619, 183 };
		arraySize = 100;
		assertEquals(953, Solution.getFinalNumberOfNegativeArrays(arraySize, elementsArr3));
		
		int[] elementsArr4 = {-1, -100};
		arraySize = 2;
		assertEquals(3, Solution.getFinalNumberOfNegativeArrays(arraySize, elementsArr4));
	}

}
