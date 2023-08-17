package practice;

import org.testng.annotations.Test;

public class TestNGTest {
	
	
	@Test(dependsOnMethods = "beforeExecution", invocationCount = 2, priority = 0)
public void execute() {
	System.out.println("Executed method");
}
	
	@Test(priority = 2, dataProviderClass = TestNGDataProviderTest.class, dataProvider = "data")
public void afterExecution(String name, String city, String area) {
	System.out.println(name+"--->"+city+"--->"+area);
}
	
	@Test(dependsOnMethods = "afterExecution")
public void beforeExecution() {
	System.out.println("Execute before execute()");
}
}
