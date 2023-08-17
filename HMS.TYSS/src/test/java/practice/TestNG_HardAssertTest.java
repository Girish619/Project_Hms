package practice;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class TestNG_HardAssertTest {

	@Test
	public void hardAssert() {
		System.out.println("1 line");
		System.out.println("2 line");
		assertEquals("A", "B");
		System.out.println("3 line");
	}
	
	@Test
	public void hardDessert() {
		System.out.println("4 line");
		System.out.println("5 line");
		assertEquals("A", "C");
		System.out.println("6 line");
	}
	
}
