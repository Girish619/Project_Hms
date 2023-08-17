package com.hms.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;

public class BaseClass {

	DatabaseUtility dLib = new DatabaseUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver;
	
	
	public void beforeSuite() throws Throwable {
		dLib.registerDriver();
		System.out.println("DataBase Connection Established");
	}
	
	public void afterSuit() throws Throwable {
		dLib.closeDbConnection();
		System.out.println("Disconnected from database");
	}
	
	
	public void beforeClass() throws Throwable {
		String browser = fLib.readPropertyFile("browser");
		String url = fLib.readPropertyFile("Domainurl");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		wLib.maximize(driver);
		wLib.pageLoadTimeout(driver);
		driver.get(url);
		DomainPage dPage = new DomainPage(driver);
		dPage.selectDomain(driver);
		HomePage hPage = new HomePage(driver);
		hPage.selectPatient();
		System.out.println("Browser successfully opened");
	}
	
	public void afterClass() {
		driver.quit();
		System.out.println("Browser successfully closed");
	}
	
	public void beforeMethod() throws Throwable {
		String username = fLib.readPropertyFile("patientUN");
		String password = fLib.readPropertyFile("patientPwd");
		PatientLoginPage plPage = new PatientLoginPage(driver);
		plPage.patientLogin(username, password);
		System.out.println("Successfully Logged in User");
	}
	
	public void afterMethod() {
		PatientDashboardPage pdPage = new PatientDashboardPage(driver);
		pdPage.logout();
		System.out.println("Successfully Logged out from User");
	}
}
