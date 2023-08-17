package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class HmsBrokenLinks {
public static void main(String[] args) throws Throwable {
	
	//WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
	Properties pr = new Properties();
	pr.load(fis);
	
	String webUrl = pr.getProperty("rmg");
	
	driver.get(webUrl);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	List<WebElement> linkList = driver.findElements(By.xpath("//a"));
	System.out.println(linkList.size());
	
	ArrayList<String> brokenLinks = new ArrayList<String>();
	
	for (int i = 0; i < linkList.size(); i++) {
		String linkValue = linkList.get(i).getAttribute("href");
		
		//URL url = null;
		int statusCode = 0;
		
		try {
			URL url = new URL(linkValue);
			HttpURLConnection makeConnection = (HttpURLConnection)url.openConnection();
			statusCode = makeConnection.getResponseCode();
			if(statusCode>=400) {
				brokenLinks.add(linkValue+"---->"+statusCode);
			}
		} catch (Exception e) {
			brokenLinks.add(linkValue+"---->"+statusCode);
		}
	}
	System.out.println(brokenLinks);
	System.out.println("Done");
}
}
