package com.joeseff.hackerrank;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * @author JWachiuri
 * @created Tuesday 10-Mar-2020
 *
 */

public class SolutionTest {

	/**
	 * Test method for {@link com.joeseff.hackerrank.SolutionTest#appendAndDelete(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testAppendAndDelete() {
		assertEquals("Yes", Solution.appendAndDelete("aaa", "a", 5));
		assertEquals("Yes", Solution.appendAndDelete("zzzzz", "zzzzzzz", 4));
		assertEquals("Yes", Solution.appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
		assertEquals("Yes", Solution.appendAndDelete("hackerhappy", "hackerrank", 9));
		assertEquals("Yes", Solution.appendAndDelete("aba", "aba", 7));
		assertEquals("No", Solution.appendAndDelete("ashley", "ash", 2));
		assertEquals("No", Solution.appendAndDelete("qwerasdf", "qwerbsdf", 6));
	}

}
