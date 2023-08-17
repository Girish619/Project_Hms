package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotation2ClassTest {
	
@Test
public void executeScriptFirst() {
	System.out.println("Test script 1 executed of Class 2");
}

@BeforeSuite
public void config_BS() {
	System.out.println("Before suite executed of Class 2");
}
@AfterSuite
public void config_AS() {
	System.out.println("After suite executed of Class 2");
}
@BeforeClass
public void config_BC() {
	System.out.println("Before Class executed of Class 2");
}
@AfterClass
public void config_AC() {
	System.out.println("After Class executed of Class 2");
}
@BeforeMethod
public void config_BM() {
	System.out.println("Before Method executed of Class 2");
}
@AfterMethod
public void config_AM() {
	System.out.println("After Method executed of Class 2");
}
@BeforeTest
public void config_BT() {
	System.out.println("Before Test executed of Class 2");
}
@AfterTest
public void config_AT() {
	System.out.println("After Test executed of Class 2");
}
@Test(groups = "smoke")
public void executeScriptSecond() {
	System.out.println("Test script 2 executed of Class 2");
}

}
