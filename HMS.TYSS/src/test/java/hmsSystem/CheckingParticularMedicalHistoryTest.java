package hmsSystem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.MedicalHistoryPage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;

public class CheckingParticularMedicalHistoryTest {
public static void main(String[] args) throws Exception {

	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	String browser = fLib.readPropertyFile("browser");
	String url = fLib.readPropertyFile("Domainurl");
	String username = fLib.readPropertyFile("patientUN");
	String password = fLib.readPropertyFile("patientPwd");
	
	//initialize webdriver
	WebDriver driver = null;
	if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	//Precondition
	wLib.maximize(driver);
	wLib.pageLoadTimeout(driver);
	driver.get(url);
	//domain
	DomainPage dPage = new DomainPage(driver);
	dPage.selectDomain(driver);
	//Home page
	HomePage hPage = new HomePage(driver);
	hPage.selectPatient();
	//Login page
	PatientLoginPage plPage = new PatientLoginPage(driver);
	plPage.patientLogin(username, password);
	//Medical History
	PatientDashboardPage pdPage = new PatientDashboardPage(driver);
	pdPage.clickOnmedicalHistory();
	//Medical History list
	String serialNo = eLib.getValue(IPathConstants.appointment, 10, 1);
	MedicalHistoryPage mhPage = new MedicalHistoryPage(driver);
	String actualResult = mhPage.viewMedicalHistory(driver, serialNo);
	//Detail view of Medical history and Validate TC
	String expectedResult = eLib.getValue(IPathConstants.patientMedicalHistory, 0, 1);
	if(actualResult.equalsIgnoreCase(expectedResult)) {
		System.out.println("Pass: Medical History page is displaying");
	}else {
		System.out.println("Fail: Medical History page is not displaying");
	}
	driver.quit();
}
}
