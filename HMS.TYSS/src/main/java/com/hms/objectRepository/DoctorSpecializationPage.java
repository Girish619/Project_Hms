package com.hms.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSpecializationPage {

	//Declaration
	@FindBy(name="doctorspecilization")
	private WebElement specializationTField;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	//Initialization
	public DoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getspecializationTField() {
		return specializationTField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business Libraries
	public String addSpecialization(WebDriver driver, String specialization) {
		specializationTField.sendKeys(specialization);
		submitButton.click();
		String actualResult = driver.findElement(By.xpath("//p[@style='color:red;']")).getText();
		return actualResult;
	}
	
}
