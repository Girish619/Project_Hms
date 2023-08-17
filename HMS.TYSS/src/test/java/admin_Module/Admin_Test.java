package admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.hms.genericutility.BaseClass_Admin;
import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.JavaUtility;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.AdminDashboardPage;
import com.hms.objectRepository.AdminLoginPage;
import com.hms.objectRepository.AppointmentHistoryInAdminPage;
import com.hms.objectRepository.BookAppointmentPage;
import com.hms.objectRepository.DomainPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.ManageUsersPage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;
import com.hms.objectRepository.PatientRegistrationPage;

public class Admin_Test extends BaseClass_Admin {
	
	@Test(groups = {"smoke", "regression"}, enabled = true)
	public void AdminManageUserPageTest() throws Exception {

		//Dashboard
		AdminDashboardPage adPage = new AdminDashboardPage(driver);
		adPage.clickOnTotalUsers();
		//validate TC
		ManageUsersPage muPage = new ManageUsersPage(driver);
		int row = 0, cell = 0;
		String patientName = eLib.getValue(IPathConstants.writeRegister, row, cell);
		boolean flag = muPage.verifyUser(driver, patientName);
		if (flag) {
			System.out.println("Pass: Manage User page displayed and user exist in it");
		} else {
			System.out.println("Fail: Manage User page not displayed or user not exist");
		}
		
	}
	
	@Test(dependsOnMethods = {"patient_Module.Patient_Test.userRegistrationTest", "patient_Module.Patient_Test.loginAsPatientTest"})
	public void UserAndAdminIntegrationTest() throws Exception {

//		FileUtility fLib = new FileUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		
//		String browser = fLib.readPropertyFile("browser");
//		String url = fLib.readPropertyFile("Domainurl");
//		
//		//initialize web driver
//		WebDriver driver = null;
//		if (browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}else if(browser.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//		//Precondition
//		wLib.maximize(driver);
//		wLib.pageLoadTimeout(driver);
//		driver.get(url);
//		//domain
//		DomainPage dPage = new DomainPage(driver);
//		dPage.selectDomain(driver);
//		//Home page
//		HomePage hPage = new HomePage(driver);
//		hPage.selectPatient();
//		//Login Page
//		PatientLoginPage plPage = new PatientLoginPage(driver);
//		plPage.clickOnCreateAccount();
//		//Patient Registration
//		//Test Data
//		int randomNum = jLib.createRandomNumber();
//		
//		String name = eLib.getValue(IPathConstants.registerSheet, 1, 0)+randomNum;
//		String address = eLib.getValue(IPathConstants.registerSheet, 1, 1);
//		String city = eLib.getValue(IPathConstants.registerSheet, 1, 2);
//		String email = name+eLib.getValue(IPathConstants.registerSheet, 1, 3);
//		String password = eLib.getValue(IPathConstants.registerSheet, 1, 4)+randomNum;
//		
//		//Fill Form
//		PatientRegistrationPage prPage = new PatientRegistrationPage(driver);
//		String actualResult = prPage.registerUser(driver, name, address, city, email, password);
//		//Validate TC
//		String expectedResult = eLib.getValue(IPathConstants.registerSheet, 1, 5);
//		if (actualResult.contains(expectedResult)) {
//		//	int lastRow = eLib.lastRowNumber(IPathConstants.registerSheet);
//			eLib.writeData(IPathConstants.writeRegister, 0, 0, name);
//			eLib.writeData(IPathConstants.writeRegister, 0, 1, email);
//			eLib.writeData(IPathConstants.writeRegister, 0, 2, password);
//			System.out.println("Pass: Successfully Registered");
//		} else {
//			System.out.println("Fail: couldn't Registered");
//		}
//		//Login As patient
//		String username = eLib.getValue("RegisterNew", 0, 1);
//		password = eLib.getValue("RegisterNew", 0, 2);
//		prPage.login();
//		//Login page
//		plPage.patientLogin(username, password);
//		//Dashboard
//		PatientDashboardPage pdPage = new PatientDashboardPage(driver);
//		pdPage.clickOnBookAppointment();
//		//Book Appointment Page
//		BookAppointmentPage baPage = new BookAppointmentPage(driver);
//		String specialization = eLib.getValue(IPathConstants.appointment, 0, 1);
//		String doctor = eLib.getValue(IPathConstants.appointment, 1, 1);
//		String date = eLib.getValue(IPathConstants.appointment, 2, 1);
//		String time = eLib.getValue(IPathConstants.appointment, 3, 1);
//		actualResult = baPage.bookAppointment(driver, specialization, doctor, date, time);
//		expectedResult = eLib.getValue(IPathConstants.appointment, 6, 1);
//		if (actualResult.contains(expectedResult)) {
//			System.out.println("Pass: Appointment booked successfully");
//		} else {
//			System.out.println("Fail: Appointment not booked");
//		}
//		//logout
//		pdPage.logout();
//		
//		//Login As Admin-Home Page
//		String adminUsername = fLib.readPropertyFile("adminUN");
//		String adminPassword = fLib.readPropertyFile("adminPwd");
//		//HomePage
//		hPage.selectAdmin();
//		//LoginPage
//		AdminLoginPage alPage = new AdminLoginPage(driver);
//		alPage.adminLogin(adminUsername, adminPassword);
		//Dashboard
		AdminDashboardPage adPage = new AdminDashboardPage(driver);
		adPage.clickOnAppointmentHistory();
		//Validate TC
		String docName = eLib.getValue(IPathConstants.appointment, 1, 1);
		String patient = eLib.getValue(IPathConstants.writeRegister, 0, 0);
		String date = eLib.getValue(IPathConstants.appointment, 2, 1);
		String time = eLib.getValue(IPathConstants.appointment, 3, 1);
		AppointmentHistoryInAdminPage ahaPage = new AppointmentHistoryInAdminPage(driver);
		boolean flag = ahaPage.appointmentHistory(driver, docName, patient, date, time);
		if(flag) {
			System.out.println("Pass: User Appointment is appearing in Admin");
	}
			else {
				System.out.println("Fail: User Appointment is not appearing in Admin");
			}
		//post condition
//		driver.quit();
	}
}
