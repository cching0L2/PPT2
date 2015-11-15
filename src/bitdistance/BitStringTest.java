package bitdistance;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitStringTest {

	@Test
	public void test1() {
		assertEquals(4, BitString.countWBsubstrings("011"));
	}
	
	@Test
	public void test2() {
		assertEquals(10, BitString.countWBsubstrings("10111"));
	}
	
	@Test
	public void test3() {
		assertEquals(15, BitString.countWBsubstrings("00000"));
	}
	
	@Test
	public void test4() {
		assertEquals(91, BitString.countWBsubstrings("0000001000000"));
	}

	@Test
	public void test5() {
		assertEquals(49, BitString.countWBsubstrings("100110001001"));
	}
	
	@Test
	public void test6() {
		try {
			BitString.countWBsubstrings("0AB");
			fail("What are we doing here?");
		}
		catch (IllegalArgumentException e) {
			assertTrue("Exception caught: Illegal argument!", true);
		}
	}
}
