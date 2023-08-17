package com.hms.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;

public class BaseClass_Patient {

	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(enabled = false, alwaysRun = true)
	public void beforeSuite() throws Throwable {
		dLib.registerDriver();
		System.out.println("DataBase Connection Established");
	}
	
	@AfterSuite(enabled = false, alwaysRun = true)
	public void afterSuit() throws Throwable {
		dLib.closeDbConnection();
		System.out.println("Disconnected from database");
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Throwable {
		String browser = fLib.readPropertyFile("browser");
		String url = fLib.readPropertyFile("Domainurl");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		wLib.maximize(driver);
		wLib.pageLoadTimeout(driver);
		driver.get(url);
		DomainPage dPage = new DomainPage(driver);
		dPage.selectDomain(driver);
		HomePage hPage = new HomePage(driver);
		hPage.selectPatient();
		System.out.println("Browser successfully opened");
	}
	
	@AfterClass	(alwaysRun = true)
	public void afterClass() {
		driver.quit();
		System.out.println("Browser successfully closed");
	}
	
	@BeforeMethod(enabled = true, alwaysRun = true)
	public void beforeMethod() throws Throwable {
		String username = fLib.readPropertyFile("patientUN");
		String password = fLib.readPropertyFile("patientPwd");
		PatientLoginPage plPage = new PatientLoginPage(driver);
		plPage.patientLogin(username, password);
		System.out.println("Successfully Logged in as User");
	}
	
	@AfterMethod(enabled = true, alwaysRun = true)
	public void afterMethod() {
		PatientDashboardPage pdPage = new PatientDashboardPage(driver);
		pdPage.logout();
		System.out.println("Successfully Logged out from User");
	}
}
