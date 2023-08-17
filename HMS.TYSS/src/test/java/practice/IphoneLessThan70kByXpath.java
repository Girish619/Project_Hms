package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneLessThan70kByXpath {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole'][number(translate(text(),'?,',''))<70000]"));
	for (WebElement phonePrice : phonePrices) {
		System.out.println(phonePrice.getText());
	}
}
}
