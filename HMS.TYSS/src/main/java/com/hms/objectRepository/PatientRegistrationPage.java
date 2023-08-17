package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericutility.WebDriverUtility;

public class PatientRegistrationPage {
	//Declaration
			@FindBy(name="full_name")
			private WebElement fullNameTField;
			
			@FindBy(name="address")
			private WebElement addressTField;
			
			@FindBy(name="city")
			private WebElement cityTField;
			
			@FindBy(xpath="//label[contains(text(),'Female')]")
			private WebElement femaleRadioButton;
			
			@FindBy(xpath="//label[contains(text(),'Male')]")
			private WebElement MaleRadioButton;
			
			@FindBy(name="email")
			private WebElement emailTField;
			
			@FindBy(name="password")
			private WebElement passwordTField;
			
			@FindBy(name="password_again")
			private WebElement passwordAgainTField;
			
			@FindBy(xpath="//label[contains(text(),'I agree')]")
			private WebElement iAgreeCheckBox;
			
			@FindBy(name="submit")
			private WebElement submitButton;
			
			@FindBy(xpath="//a[contains(text(),'Log-in')]")
			private WebElement loginLink;
			
			//Initialization
			public PatientRegistrationPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//Utilization
			public WebElement getFullNameTField() {
				return fullNameTField;
			}

			public WebElement getAddressTField() {
				return addressTField;
			}

			public WebElement getCityTField() {
				return cityTField;
			}

			public WebElement getFemaleRadioButton() {
				return femaleRadioButton;
			}

			public WebElement getMaleRadioButton() {
				return MaleRadioButton;
			}

			public WebElement getEmailTField() {
				return emailTField;
			}

			public WebElement getPasswordTField() {
				return passwordTField;
			}

			public WebElement getPasswordAgainTField() {
				return passwordAgainTField;
			}

			public WebElement getiAgreeCheckBox() {
				return iAgreeCheckBox;
			}

			public WebElement getSubmitButton() {
				return submitButton;
			}

			public WebElement getLoginLink() {
				return loginLink;
			}	
			
			//Business Libraries
			public String registerUser(WebDriver driver, String name, String address, String city, String email, String password) {
				fullNameTField.sendKeys(name);
				addressTField.sendKeys(address);
				cityTField.sendKeys(city);
				MaleRadioButton.click();
				emailTField.sendKeys(email);
				passwordTField.sendKeys(password);
				passwordAgainTField.sendKeys(password);
				submitButton.click();
				WebDriverUtility wLib = new WebDriverUtility();
				String actualResult = wLib.alertGetText(driver);
				wLib.acceptAlert(driver);
				return actualResult;
			}
			
			public void login() {
				loginLink.click();
			}
}
