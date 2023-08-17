package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarMakeMyTrip {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	Actions action = new Actions(driver);
	action.moveByOffset(40, 40).click().perform();
	
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	for(;;) {
		try {
			WebElement date = driver.findElement(By.xpath("//div[text()='July 2024']/descendant::p[text()='5']"));
			wait.until(ExpectedConditions.elementToBeClickable(date));
			date.click();
			break;

		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
}
}
}
