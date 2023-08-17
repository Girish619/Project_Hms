package com.hms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericutility.WebDriverUtility;

public class BookAppointmentPage {
	//Declaration
		@FindBy(name="Doctorspecialization")
		private WebElement doctorSpecializationDropDown;
		
		@FindBy(name="doctor")
		private WebElement doctorDropDown;
		
		@FindBy(name="appdate")
		private WebElement calenderTField;
		
		@FindBy(name="apptime")
		private WebElement timeTField;
		
		@FindBy(name="submit")
		private WebElement submitButton;
		
		//Initialization
		public BookAppointmentPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getDoctorSpecializationDropDown() {
			return doctorSpecializationDropDown;
		}

		public WebElement getDoctorDropDown() {
			return doctorDropDown;
		}

		public WebElement getCalenderTField() {
			return calenderTField;
		}

		public WebElement getTimeTField() {
			return timeTField;
		}

		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		//Business Libraries
		public String bookAppointment(WebDriver driver, String specialization, String doctor, String date, String time) {
			WebDriverUtility wLib = new WebDriverUtility();
			wLib.select(specialization, doctorSpecializationDropDown);
			wLib.select(doctor, doctorDropDown);
			String actualResult = "";
			try {
				calenderTField.sendKeys(date);
				timeTField.clear();
				timeTField.sendKeys(time);
				submitButton.click();
				actualResult = wLib.alertGetText(driver);
				wLib.acceptAlert(driver);
				
			} catch (Exception e) {
				System.err.println("Check date and time format and it should not past");
			}
			return actualResult;
		}

}
