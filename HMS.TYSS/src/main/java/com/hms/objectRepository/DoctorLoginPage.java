package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	//Declaration
	@FindBy(name="username")
	private WebElement usernameTField;

	@FindBy(name="password")
	private WebElement passwordTField;

	@FindBy(name="submit")
	private WebElement loginButton;

	@FindBy(xpath ="//a[contains(.,'Forgot Password ?')]")
	private WebElement forgotPasswordLink;

	//Initialization
	public DoctorLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUsernameTField() {
		return usernameTField;
	}

	public WebElement getPasswordTField() {
		return passwordTField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	//Business Libraries
	public void doctorLogin(String username, String password) {
		usernameTField.sendKeys(username);
		passwordTField.sendKeys(password);
		loginButton.click();
	}

}
