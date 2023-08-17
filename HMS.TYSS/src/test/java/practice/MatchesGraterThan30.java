package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MatchesGraterThan30 {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	List<WebElement> allTeams = driver.findElements(By.xpath("(//table//td[@class='rankings-block__banner--matches'] | //td[@class='table-body__cell u-center-text'][1][text()>30]/preceding-sibling :: td/span[@class='u-hide-phablet'] | //span[text()='India' and @class='u-hide-phablet'])[position()!=2]"));
	List<WebElement> allMatches = driver.findElements(By.xpath("//table//td[@class='rankings-block__banner--matches'] | //td[@class='table-body__cell u-center-text'][1][text()>30]"));
	for (int i = 0; i < allMatches.size(); i++) {
		System.out.println(allTeams.get(i).getText()+"-->"+allMatches.get(i).getText());
	}
}
}
