package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCMDLineTest {
	@Test
public void readDataFromCmd() {

	String url = System.getProperty("url");
	System.out.println(url);
//	String username = System.getProperty("username");
//	String password = System.getProperty("password");
	
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get(url);
//	driver.findElement(By.name("username")).sendKeys(username);
//	driver.findElement(By.name("password")).sendKeys(password);
//	driver.findElement(By.name("submit")).click();
}
}
