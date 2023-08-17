package hmsIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.AppointmentHistoryPage;
import com.hms.objectRepository.BookAppointmentPage;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;

public class BookAppointmentAndCheckAppointmentHistoryTest {
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
	pdPage.clickOnBookAppointment();
	//Book Appointment Page
	BookAppointmentPage baPage = new BookAppointmentPage(driver);
	String specialization = eLib.getValue(IPathConstants.appointment, 0, 1);
	String doctor = eLib.getValue(IPathConstants.appointment, 1, 1);
	String date = eLib.getValue(IPathConstants.appointment, 2, 1);
	String time = eLib.getValue(IPathConstants.appointment, 3, 1);
	String actualResult = baPage.bookAppointment(driver, specialization, doctor, date, time);
	String expectedResult = eLib.getValue(IPathConstants.appointment, 6, 1);
	if (actualResult.contains(expectedResult)) {
		System.out.println("Pass: Appointment booked successfully");
	} else {
		System.out.println("Fail: Appointment not booked");
	}
	//Check Appointment History
	pdPage.clickOnAppointmentHistory();
	//validate TC
	AppointmentHistoryPage apPage = new AppointmentHistoryPage(driver);
	apPage.verifyAppointment(driver, doctor, date, time);
	driver.quit();
}
}
