package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllTeamDataICC {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	List<WebElement> tableRow = driver.findElements(By.xpath("//table//tr"));
	for (WebElement rowData : tableRow) {
		System.out.println(rowData.getText());
	}
	
}
}
