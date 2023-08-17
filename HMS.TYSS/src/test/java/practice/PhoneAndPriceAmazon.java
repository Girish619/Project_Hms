package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneAndPriceAmazon {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> phoneNames = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2"));
		List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"));
		for (int i = 0; i < phoneNames.size(); i++) {			
				System.out.println(phoneNames.get(i).getText()+"="+phonePrices.get(i).getText());
		}
	}
}
