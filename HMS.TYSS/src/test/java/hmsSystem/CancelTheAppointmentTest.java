package hmsSystem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.AppointmentHistoryPage;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;

public class CancelTheAppointmentTest {
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
	//Dashboard
	PatientDashboardPage pdPage = new PatientDashboardPage(driver);
	pdPage.clickOnAppointmentHistory();
	//Cancel Appointment
	String doctorName = eLib.getValue(IPathConstants.appointment, 1, 1);
	String date = eLib.getValue(IPathConstants.appointment, 2, 1);
	String time = eLib.getValue(IPathConstants.appointment, 3, 1);
	AppointmentHistoryPage apPage = new AppointmentHistoryPage(driver);
	String actualResult = apPage.cancelAppointment(driver, doctorName, date, time);
	//validate TC
	String expectedResult = eLib.getValue(IPathConstants.appointment, 7, 1);
	if(actualResult.contains(expectedResult)) {
		System.out.println("Pass: Appointment cancelled successfully");
	}else {
		System.out.println("Fail: Appointment couldn't be cancelled");
	}
	driver.quit();
}
}
