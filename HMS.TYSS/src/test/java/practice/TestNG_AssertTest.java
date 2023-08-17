package practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_AssertTest {

	@Test
	public void assertTest() {
		System.out.println("line 1");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A", "B");
		System.out.println("line 2");
		assertEquals("A", "C");
		System.out.println("line 3");
		sa.assertAll();
	}
	
	@Test
	public void assertionTest() {
		System.out.println("line 1");
		assertEquals("A", "C");
		System.out.println("line 2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A", "B");
		System.out.println("line 3");
		sa.assertAll();
	}
	
}
