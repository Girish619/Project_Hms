package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_SoftAssertTest {

	@Test
	public void softAssert() {
		System.out.println("line 1");
		System.out.println("line 2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A", "B");
 		System.out.println("line 3");
 		sa.assertAll();
	}
	@Test
	public void softDessert() {
		System.out.println("line 4");
		System.out.println("line 5");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A", "C");
		System.out.println("line 6");
		
	}
	
}
