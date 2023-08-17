package hmsIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.JavaUtility;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.AddDoctorPage;
import com.hms.objectRepository.AdminDashboardPage;
import com.hms.objectRepository.AdminLoginPage;
import com.hms.objectRepository.DoctorSpecializationPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.ManageDoctorPage;

public class CreateDoctorTest {
public static void main(String[] args) throws Exception {
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	
	String browser = fLib.readPropertyFile("browser");
	String url = fLib.readPropertyFile("Homeurl");
	String username = fLib.readPropertyFile("adminUN");
	String password = fLib.readPropertyFile("adminPwd");
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
	//HomePage
	HomePage hPage = new HomePage(driver);
	hPage.selectAdmin();
	//LoginPage
	AdminLoginPage alPage = new AdminLoginPage(driver);
	alPage.adminLogin(username, password);
	//Dashboard
	AdminDashboardPage adPage = new AdminDashboardPage(driver);
	String doctorSpecialization = eLib.getValue(IPathConstants.doctor, 0, 1);
	adPage.clickOnDoctorSpecialization();
	DoctorSpecializationPage dsPage = new DoctorSpecializationPage(driver);
	String expectedResult = eLib.getValue(IPathConstants.specialization, 3, 1);
	String actualResult = dsPage.addSpecialization(driver, doctorSpecialization);
	//Validate TC
	if(actualResult.contains(expectedResult)) {
		System.out.println("Pass: Doctor Specialization added successfully");
	}else {
		System.out.println("Fail: Couldn't add Doctor Specialization");
	}
	//Add Doctor
	adPage.clickOnAddDoctor();
	int random = jLib.createRandomNumber();
	String specialization = eLib.getValue(IPathConstants.doctor, 0, 1);
	String doctor = eLib.getValue(IPathConstants.doctor, 1, 1)+random;
	String address = eLib.getValue(IPathConstants.doctor, 2, 1);
	String fees = eLib.getValue(IPathConstants.doctor, 3, 1);
	String contact = eLib.getValue(IPathConstants.doctor, 4, 1)+random;
	String email = doctor+eLib.getValue(IPathConstants.doctor, 5, 1);
	password = eLib.getValue(IPathConstants.doctor, 6, 1)+random;
	String docexpectedResult = eLib.getValue(IPathConstants.doctor, 8, 1);
	AddDoctorPage adocPage = new AddDoctorPage(driver);
	String docactualResult = adocPage.addDoctor(driver, specialization, doctor, address, fees, contact, email, password);
	if(docactualResult.equals(docexpectedResult)) {
		System.out.println("Pass: Doctor created");
	}else {
		System.out.println("Fail: Doctor couldn't be created");
	}
	
	//validate TC
	ManageDoctorPage mdPage = new ManageDoctorPage(driver);
	if(mdPage.manageDoctor(driver, specialization, doctor)){
		System.out.println("Pass: Doctor present in Manage doctor page");
	}else {
		System.out.println("Fail: Doctor not present in Manage doctor page");
	}
	driver.quit();
}
}
