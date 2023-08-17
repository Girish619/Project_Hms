package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandSelectionInAmazon {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	WebElement brand = driver.findElement(By.xpath("//li[@aria-label='Samsung']/span"));
	brand.click();
	List<WebElement> allPhones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	List<WebElement> allPhonePrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	for (int i = 0; i < allPhones.size(); i++) {
		System.out.println(allPhones.get(i).getText()+"="+allPhonePrices.get(i).getText());
	}
	
}
}
