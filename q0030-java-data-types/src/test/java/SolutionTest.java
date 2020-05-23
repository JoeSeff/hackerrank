import static org.junit.Assert.*;

import org.junit.Test;

import com.joeseff.hackerrank.Solution;

/*
 * @author JWachiuri
 * @created Thursday 05-Mar-2020
 *
 */

public class SolutionTest {

	@Test
	public void testIsByte() {
		assertTrue(Solution.isByte(50));
	}

	@Test
	public void testIsShort() {
		assertTrue(Solution.isShort(1000));
	}

	@Test
	public void testIsInt() {
		assertTrue(Solution.isInt(100_000));
	}

	@Test
	public void testIsLong() {
		assertTrue(Solution.isLong(2_000_000_000));
	}

	// Finish
	@Test
	public void testIsNotByte() {
		assertFalse(Solution.isByte(500));
	}

	@Test
	public void testIsNotShort() {
		assertFalse(Solution.isShort(32768));
	}

	@Test
	public void testIsNotInt() {
		assertFalse(Solution.isInt((long)Math.pow(2, 31)));
	}

}
