package patient_Module;

import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.hms.genericutility.BaseClass_Patient;
import com.hms.genericutility.IPathConstants;
import com.hms.objectRepository.AppointmentHistoryPage;
import com.hms.objectRepository.MedicalHistoryPage;
import com.hms.objectRepository.PatientDashboardPage;
import com.hms.objectRepository.PatientLoginPage;
import com.hms.objectRepository.PatientRegistrationPage;

@Listeners(com.hms.genericutility.ListnerImpClass.class)
public class Patient_Test extends BaseClass_Patient{
	
	@DataProvider
	public Object[][] dataRegister() throws Throwable {
		Object[][] obj = eLib.getMultipleDataFromDPByExcel(IPathConstants.registerSheet);
		return obj;
	}
	
	@Test(dataProvider = "dataRegister", groups = {"smoke", "regression"}, enabled = true)
	public void userRegistrationTest(String name, String address, String city, String email, String password, String expectedResult) throws Exception {

		//Login Page
		PatientLoginPage plPage = new PatientLoginPage(driver);
		plPage.clickOnCreateAccount();
		//Patient Registration
		//Test Data
		int randomNum = jLib.createRandomNumber();
		name=name+randomNum;
		email= name+email;
		password=password+randomNum;
		//Fill Form
		PatientRegistrationPage prPage = new PatientRegistrationPage(driver);
		String actualResult = prPage.registerUser(driver, name, address, city, email, password);
		//Validate TC
		if (actualResult.contains(expectedResult)) {
			eLib.writeData(IPathConstants.writeRegister, 0, 0, name);
			eLib.writeData(IPathConstants.writeRegister, 0, 1, email);
			eLib.writeData(IPathConstants.writeRegister, 0, 2, password);
			System.out.println("Pass: Successfully Registered");
		} else {
			System.out.println("Fail: couldn't Registered");
		}
		
	}
	
	@Test(groups = {"smoke", "regression"}, enabled = true)
	public void loginAsPatientTest() throws Exception {
		//Validate TC
		String actualResult = driver.getTitle();
		int row = 0, cell = 1;
		String expectedResult = eLib.getValue(IPathConstants.patientLoginPage, row, cell);
		if (actualResult.contains(expectedResult)) {
			System.out.println("Pass: User logged in successfully");
		} else {
			System.out.println("Fail: User couldn't log in successfully");
		}
	
	}
	
	@DataProvider
	public Object[][] dataAppointment() throws Throwable {
		Object[][] obj = eLib.getMultipleDataFromDPByExcel(IPathConstants.appointments);
		return obj;
	}
	
	@Test(dataProvider = "dataAppointment", groups = {"system", "regression"}, enabled = true, retryAnalyzer = com.hms.genericutility.RetryImpClass.class)
	public void cancelTheAppointmentTest(String special, String doctorName, String date, String time, String Book, String expectedResult) throws Exception {
		//Dashboard
		PatientDashboardPage pdPage = new PatientDashboardPage(driver);
		pdPage.clickOnAppointmentHistory();
		//Cancel Appointment
		AppointmentHistoryPage apPage = new AppointmentHistoryPage(driver);
		String actualResult = apPage.cancelAppointment(driver, doctorName, date, time);
		//validate TC
		if(actualResult.contains(expectedResult)) {
			System.out.println("Pass: Appointment cancelled successfully");
		}else {
			System.out.println("Fail: Appointment couldn't be cancelled");
		}
	}
	
	@DataProvider
	public Object[][] dataMedicalHistory() throws Throwable {
		Object[][] obj = eLib.getMultipleDataFromDPByExcel(IPathConstants.patientMedicalHistory);
		return obj;
	}
	
	@Test(dataProvider = "dataMedicalHistory", groups = {"system", "regression"}, enabled = true)
	public void checkingParticularMedicalHistoryTest(String expectedResult, String serialNo) throws Exception {
		
		//Medical History
		PatientDashboardPage pdPage = new PatientDashboardPage(driver);
		pdPage.clickOnmedicalHistory();
		//Medical History list
		MedicalHistoryPage mhPage = new MedicalHistoryPage(driver);
		String actualResult = mhPage.viewMedicalHistory(driver, serialNo);
		//Detail view of Medical history and Validate TC
		if(actualResult.equalsIgnoreCase(expectedResult)) {
			System.out.println("Pass: Medical History page is displaying");
		}else {
			System.out.println("Fail: Medical History page is not displaying");
		}
	}
}
