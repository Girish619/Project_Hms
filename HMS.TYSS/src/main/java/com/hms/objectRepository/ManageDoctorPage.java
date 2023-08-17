package com.hms.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDoctorPage {

	//Declaration
	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> serialNumbers;
	
	//Initialization
	public ManageDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public List<WebElement> getSerialNumbers() {
		return serialNumbers;
	}
	
	//Business Libraries
	public boolean manageDoctor(WebDriver driver, String specialization, String docName) {
		boolean actualResult = false;
		if(serialNumbers.size()>0) {
			WebElement particularDoctor = driver.findElement(By.xpath("//td[text()='"+specialization+"']/following-sibling :: td[text()='"+docName+"']"));
			if(particularDoctor.isDisplayed()) {
				actualResult = true;
			}
		}
		return actualResult;
	}
	
}
