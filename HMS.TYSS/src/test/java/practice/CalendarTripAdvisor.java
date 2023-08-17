package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarTripAdvisor {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		driver.get("https://www.tripadvisor.in/");
		
		driver.findElement(By.xpath("//button[@aria-haspopup='menu']/descendant::span[@class='pJLKe H0']")).click();
		driver.findElement(By.id("menu-item-1")).click();	
		driver.findElement(By.id("global-nav-flights")).click();
		driver.findElement(By.xpath("(//input[@class='query destWithLabel'])[1]")).sendKeys("Delhi");
		driver.findElement(By.xpath("//span[@data-datetype='DEPARTURE']")).click();
		WebElement fromDate = driver.findElement(By.xpath("//span[@data-date='2023-7-5']"));
		WebElement toDate = driver.findElement(By.xpath("(//span[text()='6'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(fromDate));
		fromDate.click();
		wait.until(ExpectedConditions.stalenessOf(toDate));
		toDate.click();
		
		driver.findElement(By.xpath("(//span[text()='Find flights '])[1]")).click();

		
	}
}
