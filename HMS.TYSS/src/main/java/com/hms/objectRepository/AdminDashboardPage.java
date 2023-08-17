package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	//Declaration
	@FindBy(xpath="//a[contains(.,'Total Users :')]")
	private WebElement totalUserLink;
	
	@FindBy(xpath="//a[contains(.,'Total Doctors :')]")
	private WebElement totalDoctorLink;
	
	@FindBy(xpath="//a[contains(.,'Total Appointments :')]")
	private WebElement totalAppointmentLink;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement adminToggle;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logoutOption;
	
	@FindBy(xpath="//div[@class='item-inner']/span[contains(text(),'Doctors')]")
	private WebElement doctorsOption;
	
	@FindBy(xpath="//span[contains(text(),'Doctor Specialization')]")
	private WebElement doctorSpecializationOption;
	
	@FindBy(xpath="//span[contains(text(),'Add Doctor')]")
	private WebElement addDoctorOption;
	
	@FindBy(xpath="//span[contains(text(),'Manage Doctors')]")
	private WebElement manageDoctorOption;
	
	@FindBy(xpath="//div[@class='item-inner']/span[contains(text(),'Users')]")
	private WebElement usersOption;
	
	@FindBy(xpath="//span[contains(text(),'Manage Users')]")
	private WebElement manageUsersOption;
	
	@FindBy(xpath="//div[@class='item-inner']/span[contains(text(),'Patients')]")
	private WebElement patientsOption;
	
	@FindBy(xpath="//span[contains(text(),'Manage Patients')]")
	private WebElement managePatientOption;
	
	@FindBy(xpath="//span[contains(text(),'Appointment History')]")
	private WebElement appointmentHistoryOption;
	
	//Initialization
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getTotalUserLink() {
		return totalUserLink;
	}

	public WebElement getTotalDoctorLink() {
		return totalDoctorLink;
	}

	public WebElement getTotalAppointmentLink() {
		return totalAppointmentLink;
	}

	public WebElement getAdminToggle() {
		return adminToggle;
	}

	public WebElement getLogoutOption() {
		return logoutOption;
	}

	public WebElement getDoctorsOption() {
		return doctorsOption;
	}

	public WebElement getDoctorSpecializationOption() {
		return doctorSpecializationOption;
	}

	public WebElement getAddDoctorOption() {
		return addDoctorOption;
	}

	public WebElement getManageDoctorOption() {
		return manageDoctorOption;
	}

	public WebElement getUsersOption() {
		return usersOption;
	}

	public WebElement getManageUsersOption() {
		return manageUsersOption;
	}

	public WebElement getPatientsOption() {
		return patientsOption;
	}

	public WebElement getManagePatientOption() {
		return managePatientOption;
	}

	public WebElement getAppointmentHistoryOption() {
		return appointmentHistoryOption;
	}
	
	//Business Libraries
	public void clickOnTotalUsers() {
		totalUserLink.click();
	}
	
	public void clickOnAppointmentHistory() {
		appointmentHistoryOption.click();
	}
	
	public void clickOnDoctorSpecialization() {
		doctorsOption.click();
		doctorSpecializationOption.click();
	}
	
	public void clickOnAddDoctor() {
		doctorsOption.click();
		addDoctorOption.click();
	}
	
	public void clickOnManageDoctor() {
		totalDoctorLink.click();
	}
	
	public void logout() {
		adminToggle.click();
		logoutOption.click();
	}
}
