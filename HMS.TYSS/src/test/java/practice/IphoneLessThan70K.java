package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneLessThan70K {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	List<WebElement> name = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2"));
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"));
	for (int i = 0; i < name.size(); i++) {
		String priceText = price.get(i).getText();
		String priceTextReplaced = priceText.replace(",", "");
		//int priceValue1 = Integer.parseInt(priceTextReplaced);
		Integer priceValue = Integer.valueOf(priceTextReplaced);
		if(priceValue<=70000) {
			System.out.println(name.get(i).getText()+"-->"+price.get(i).getText());
		}
	}
}
}
