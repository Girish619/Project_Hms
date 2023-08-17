package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First10Team {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	List<WebElement> allTeams = driver.findElements(By.xpath("(//table//span[@class='u-hide-phablet'])[position()<=10]"));
	for (WebElement teamName : allTeams) {
		System.out.println(teamName.getText());
	}
}
}
