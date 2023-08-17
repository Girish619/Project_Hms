package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	//Declaration
@FindBy(name="username")
private WebElement usernameTField;

@FindBy(name="password")
private WebElement passwordTField;

@FindBy(name="submit")
private WebElement loginButton;

@FindBy(xpath ="//a[contains(.,'Forgot Password ?')]")
private WebElement forgotPasswordLink;

@FindBy(xpath="//a[contains(.,'Create an account')]")
private WebElement createAccountLink;

//Initialization
public PatientLoginPage(WebDriver driver) {
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

public WebElement getCreateAccountLink() {
	return createAccountLink;
}

//Business Libraries
public void patientLogin(String username, String password) {
	usernameTField.sendKeys(username);
	passwordTField.sendKeys(password);
	loginButton.click();
}

public void clickOnCreateAccount() {
	createAccountLink.click();
}

}
