package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Declaration
	@FindBy(xpath="//h3[text()='Patients']/..//a")
	private WebElement patientLogin;
	
	@FindBy(xpath="//h3[text()='Doctors Login']/..//a")
	private WebElement doctorLogin;
	
	@FindBy(xpath="//h3[text()='Admin Login']/..//a")
	private WebElement AdminLogin;
	
//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//Utilization

	public WebElement getPatientLogin() {
		return patientLogin;
	}

	public WebElement getDoctorLogin() {
		return doctorLogin;
	}

	public WebElement getAdminLogin() {
		return AdminLogin;
	}
	
	//Business Libraries
	public void selectPatient() {
		patientLogin.click();
	}
	
	public void selectDoctor() {
		doctorLogin.click();
	}
	
	public void selectAdmin() {
		AdminLogin.click();
	}
	
	
}
