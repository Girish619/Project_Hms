package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class RmgYantraCreateProject {
public static void main(String[] args) throws Throwable {
	String projectName = "Cern Tech";
	//WebDriverManage.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RmgCreateProjectCmnData.Properties");
	Properties properties = new Properties();
	properties.load(fis);
	
	String url = properties.getProperty("url");
	String username = properties.getProperty("un");
	String password = properties.getProperty("pwd");
	
	driver.get(url);
	
	driver.findElement(By.id("usernmae")).sendKeys(username);
	driver.findElement(By.id("inputPassword")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Sign in']")).submit();	

	driver.findElement(By.xpath("//a[text()='Projects']")).click();	
	
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	
	driver.findElement(By.name("projectName")).sendKeys("Cern Tech");
	driver.findElement(By.name("createdBy")).sendKeys("Girish");
	WebElement projectStatus = driver.findElement(By.name("status"));
	Select select = new Select(projectStatus);
	select.selectByValue("Created");
	driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	
	Driver sqlDriver = new Driver();
	DriverManager.registerDriver(sqlDriver);
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	
	Statement statement = connection.createStatement();
	String query = "select * from project;";
	ResultSet result = statement.executeQuery(query);
	boolean flag = false;
	while(result.next()) {
		String actualResult = result.getString(4);
		if(actualResult.equalsIgnoreCase(projectName)) {
			flag = true;
			break;
		}
		
	}
	if(flag) {
		System.out.println("Project created successfully");
	}else {
		System.out.println("Project not created");
	}
	
	connection.close();
}
}
