package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericutility.WebDriverUtility;

public class DomainPage {
	
	//Declaration
		@FindBy(xpath="//h3[text()='Domain: Health Care']/../descendant :: button")
		private WebElement hmsButton;
		
		//Initialization
		public DomainPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement gethmsButton() {
			return hmsButton;
		}
		
		//Business Libraries
		public void selectDomain(WebDriver driver) {
			hmsButton.click();
			WebDriverUtility wLib = new WebDriverUtility();
			wLib.switchToWindow(driver, "Hospital Management system");
		}
}
