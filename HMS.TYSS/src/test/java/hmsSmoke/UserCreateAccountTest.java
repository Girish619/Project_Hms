package hmsSmoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.JavaUtility;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientLoginPage;
import com.hms.objectRepository.PatientRegistrationPage;

public class UserCreateAccountTest {
public static void main(String[] args) throws Exception {

	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	String browser = fLib.readPropertyFile("browser");
	String url = fLib.readPropertyFile("Domainurl");
	
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
	//Login Page
	PatientLoginPage plPage = new PatientLoginPage(driver);
	plPage.clickOnCreateAccount();
	//Patient Registration
	//Test Data
	int randomNum = jLib.createRandomNumber();
	
	String name = eLib.getValue(IPathConstants.registerSheet, 1, 0)+randomNum;
	String address = eLib.getValue(IPathConstants.registerSheet, 1, 1);
	String city = eLib.getValue(IPathConstants.registerSheet, 1, 2);
	String email = name+eLib.getValue(IPathConstants.registerSheet, 1, 3);
	String password = eLib.getValue(IPathConstants.registerSheet, 1, 4)+randomNum;
	
	//Fill Form
	PatientRegistrationPage prPage = new PatientRegistrationPage(driver);
	String actualResult = prPage.registerUser(driver, name, address, city, email, password);
	//Validate TC
	int row=1, cell=5;
	String expectedResult = eLib.getValue(IPathConstants.registerSheet, row, cell);
	if (actualResult.contains(expectedResult)) {
	//	int lastRow = eLib.lastRowNumber(IPathConstants.registerSheet);
		eLib.writeData(IPathConstants.writeRegister, 0, 0, name);
		eLib.writeData(IPathConstants.writeRegister, 0, 1, email);
		eLib.writeData(IPathConstants.writeRegister, 0, 2, password);
		System.out.println("Pass: Successfully Registered");
	} else {
		System.out.println("Fail: couldn't Registered");
	}
	//post condition
	driver.quit();
}
}
