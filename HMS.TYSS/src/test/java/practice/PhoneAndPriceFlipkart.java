package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneAndPriceFlipkart {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("samsung s23 ultra");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> phoneNames = driver.findElements(By.xpath("//div[@class='col col-7-12']//div[@class='_4rR01T']"));
		List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@class='col col-5-12 nlI3QM']//div[text()='₹']/preceding-sibling :: div"));
		for (int i = 0; i < phoneNames.size(); i++) {			
				System.out.println(phoneNames.get(i).getText()+"="+phonePrices.get(i).getText());
		}
	}
}
