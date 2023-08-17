package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {
//Declaration
	@FindBy(xpath="//a[contains(.,'Update Profile')]")
	private WebElement updateProfileLink;
	
	@FindBy(xpath="//a[contains(.,'View Appointment History')]")
	private WebElement viewAppointmentHistoryLink;
	
	@FindBy(xpath="//h2[contains(text(),'Book My Appointment')]/..//a[contains(.,'Book Appointment')]")
	private WebElement bookAppointmentLink;
	
	@FindBy(xpath="//a[@data-toggle-class='app-sidebar-closed']")
	private WebElement sideBarMenu;
	
	@FindBy(xpath="//span[contains(text(),'Dashboard') and @class='title']")
	private WebElement dashboardOption;
	
	@FindBy(xpath="//span[contains(text(),'Book Appointment')]")
	private WebElement bookAppointmentOption;
	
	@FindBy(xpath="//span[contains(text(),'Appointment History')]")
	private WebElement appointmentHistoryOption;
	
	@FindBy(xpath="//span[contains(text(),'Medical History')]")
	private WebElement medicalHistoryOption;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement profileToggle;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	private WebElement myProfileOption;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	private WebElement changePasswordOption;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logOutOption;
	
	//Initialization
	public PatientDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}

	public WebElement getViewAppointmentHistoryLink() {
		return viewAppointmentHistoryLink;
	}

	public WebElement getBookAppointmentLink() {
		return bookAppointmentLink;
	}

	public WebElement getSideBarMenu() {
		return sideBarMenu;
	}

	public WebElement getDashboardOption() {
		return dashboardOption;
	}

	public WebElement getBookAppointmentOption() {
		return bookAppointmentOption;
	}

	public WebElement getAppointmentHistoryOption() {
		return appointmentHistoryOption;
	}

	public WebElement getMedicalHistoryOption() {
		return medicalHistoryOption;
	}

	public WebElement getProfileToggle() {
		return profileToggle;
	}

	public WebElement getMyProfileOption() {
		return myProfileOption;
	}

	public WebElement getChangePasswordOption() {
		return changePasswordOption;
	}

	public WebElement getLogOutOption() {
		return logOutOption;
	}
	
	//Business Libraries
	public void clickOnBookAppointment() {
		bookAppointmentLink.click();
	}
	
	public void clickOnAppointmentHistory() {
		appointmentHistoryOption.click();
	}
	
	public void clickOnmedicalHistory() {
		medicalHistoryOption.click();
	}
	
	public void logout() {
		profileToggle.click();
		logOutOption.click();
	}
	
}
