package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginToHMSFromProperty {
public static void main(String[] args) throws Exception {
	Properties property = new Properties();
	property.load(new FileInputStream(".\\src\\test\\resources\\HmsCommonData.Properties"));
	
	String browser = property.getProperty("browser");
	String url = property.getProperty("url");
	String username = property.getProperty("un");
	String password = property.getProperty("pwd");
	
	WebDriver driver = null;
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
}
}
