package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericutility.WebDriverUtility;

public class AddDoctorPage {

	//Declaration
	@FindBy(name="Doctorspecialization")
	private WebElement specializationDropDown;
	
	@FindBy(name="docname")
	private WebElement docNameTField;
	
	@FindBy(name="clinicaddress")
	private WebElement clinicAddressTArea;
	
	@FindBy(name="docfees")
	private WebElement docFeesTField;
	
	@FindBy(name="doccontact")
	private WebElement docContactTField;
	
	@FindBy(name="docemail")
	private WebElement docEmailTField;
	
	@FindBy(name="npass")
	private WebElement newPasswordTField;
	
	@FindBy(name="cfpass")
	private WebElement confirmPasswordTField;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	//Initialization
	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getSpecializationDropDown() {
		return specializationDropDown;
	}

	public WebElement getDocNameTField() {
		return docNameTField;
	}

	public WebElement getClinicAddressTArea() {
		return clinicAddressTArea;
	}

	public WebElement getDocFeesTField() {
		return docFeesTField;
	}

	public WebElement getDocContactTField() {
		return docContactTField;
	}

	public WebElement getDocEmailTField() {
		return docEmailTField;
	}

	public WebElement getNewPasswordTField() {
		return newPasswordTField;
	}

	public WebElement getConfirmPasswordTField() {
		return confirmPasswordTField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public String addDoctor(WebDriver driver, String specialization, String docName, String address, String fees, String contact, String email, String password) {
		String actualResult = "";
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.select(specialization, specializationDropDown);
		docNameTField.sendKeys(docName);
		clinicAddressTArea.sendKeys(address);
		docFeesTField.sendKeys(fees);
		docContactTField.sendKeys(contact);
		docEmailTField.sendKeys(email);
		newPasswordTField.sendKeys(password);
		confirmPasswordTField.sendKeys(password);
		submitButton.click();
		actualResult = wLib.alertGetText(driver);
		wLib.acceptAlert(driver);
		return actualResult;
	}
		
}
