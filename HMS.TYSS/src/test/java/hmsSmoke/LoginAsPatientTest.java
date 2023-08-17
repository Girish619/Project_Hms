package hmsSmoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientLoginPage;

public class LoginAsPatientTest {
public static void main(String[] args) throws Exception {
	
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	String browser = fLib.readPropertyFile("browser");
	String url = fLib.readPropertyFile("Domainurl");
	String username = fLib.readPropertyFile("patientUN");
	String password = fLib.readPropertyFile("patientPwd");
	
	//initialize web driver
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
	//Validate TC
	String actualResult = driver.getTitle();
	int row = 0, cell = 1;
	String expectedResult = eLib.getValue(IPathConstants.patientLoginPage, row, cell);
	if (actualResult.contains(expectedResult)) {
		System.out.println("Pass: User logged in successfully");
	} else {
		System.out.println("Fail: User couldn't log in successfully");
	}
	driver.quit();
}
}
