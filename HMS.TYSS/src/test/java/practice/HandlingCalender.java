package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalender {
public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.goibibo.com/");
	
	driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	driver.findElement(By.xpath("//span[text()='Departure']")).click();
//	driver.findElement(By.xpath("//div[@aria-label='Sat Jul 29 2023']")).click();
//	driver.findElement(By.xpath("//span[text()='Done']")).click();
	
	for(;;) {
		try {
			driver.findElement(By.xpath("//div[@aria-label='Mon Aug 05 2024']")).click();
			driver.findElement(By.xpath("//span[text()='Done']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}
}
}
