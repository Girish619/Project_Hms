package hmsSmoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.FileUtility;
import com.hms.genericutility.IPathConstants;
import com.hms.genericutility.WebDriverUtility;
import com.hms.objectRepository.AdminDashboardPage;
import com.hms.objectRepository.AdminLoginPage;
import com.hms.objectRepository.HomePage;
import com.hms.objectRepository.ManageUsersPage;

public class AdminManageUserPageTest {
public static void main(String[] args) throws Exception {

	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	
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
	//close browser
	driver.quit();
}
}
