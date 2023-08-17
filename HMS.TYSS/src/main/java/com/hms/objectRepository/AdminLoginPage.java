package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	//Declaration
		@FindBy(name="username")
		private WebElement usernameTField;

		@FindBy(name="password")
		private WebElement passwordTField;

		@FindBy(name="submit")
		private WebElement loginButton;

		//Initialization
		public AdminLoginPage(WebDriver driver) {
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
		
		//Business Libraries
		public void adminLogin(String username, String password) {
			usernameTField.sendKeys(username);
			passwordTField.sendKeys(password);
			loginButton.click();
		}

}
