import static org.junit.Assert.*;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void testcompose() {
		assertEquals("zero", Program.compose(0));
		assertEquals("one", Program.compose(1));
		assertEquals("nine", Program.compose(9));
		assertEquals("one hundred twenty-three million, six hundred seventy-eight", Program.compose(123000678));
	}
	@Test
	public void testoneDigit() {
		assertEquals("one", Program.oneDigit(1));
		assertEquals("nine", Program.oneDigit(9));
	}
	@Test
	public void testtwoDigit() {
		assertEquals("one", Program.twoDigit(1));
		assertEquals("nine", Program.twoDigit(9));
		assertEquals("ten", Program.twoDigit(10));
		assertEquals("fifteen", Program.twoDigit(15));
		assertEquals("thirty", Program.twoDigit(30));
		assertEquals("forty-two", Program.twoDigit(42));
		assertEquals("ninety-nine", Program.twoDigit(99));
	}
	@Test
	public void testthreeDigit() {
		assertEquals("", Program.threeDigit(0));
		assertEquals("fifty-seven", Program.threeDigit(57));
		assertEquals("one hundred one", Program.threeDigit(101));
		assertEquals("three hundred", Program.threeDigit(300));
		assertEquals("three hundred seventy-six", Program.threeDigit(376));
	}
	@Test
	public void testmain() {
		Program.main(new String[0]);
	}
	@Test
	public void testsortNumbersAlphabetically() {
		Program.sortNumbersAlphabetically(42);
	}

//	@Test (expected = IllegalArgumentException.class)
//	public void testoneDigitExceptionsNeg() {
//		Program.oneDigit(-1);
//	}
//	@Test (expected = IllegalArgumentException.class)
//	public void testoneDigitExceptionsOverflow() {
//		Program.oneDigit(10);
//	}
//	@Test (expected = IllegalArgumentException.class)
//	public void testtwoDigitExceptionsNeg() {
//		Program.twoDigit(-1);
//	}
//	@Test (expected = IllegalArgumentException.class)
//	public void testtwoDigitExceptionsOverflow() {
//		Program.twoDigit(100);
//	}
//	@Test (expected = IllegalArgumentException.class)
//	public void testthreeDigitExceptionsNeg() {
//		Program.threeDigit(-1);
//	}
//	@Test (expected = IllegalArgumentException.class)
//	public void testthreeDigitExceptionsOverflow() {
//		Program.threeDigit(1000);
//	}

}
