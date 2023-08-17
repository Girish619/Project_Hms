package com.hms.objectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistoryInAdminPage {

	//Declaration
	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> serialNumbers;
	
	//Initialization
	public AppointmentHistoryInAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public List<WebElement> getSerialNumbers() {
		return serialNumbers;
	}
	
	//Business Libraries
	public boolean appointmentHistory(WebDriver driver, String docName, String patient, String date, String time ) {/*String expectedResult*/
		boolean actualResult = false;
		if(serialNumbers.size()>0) {
//			String action = driver.findElement(By.xpath("//td[text()='"+docName+"']/following-sibling :: td[text()='"+patient+"']/following-sibling :: td[contains(text(),'"+date+" / "+time+"')]/following-sibling :: td//div[@class='visible-md visible-lg hidden-sm hidden-xs']")).getText();
//			if(action.contains(expectedResult)){
//				actualResult = true;
//			}
			WebElement particularAppointment = driver.findElement(By.xpath("//td[text()='"+docName+"']/following-sibling :: td[text()='"+patient+"']/following-sibling :: td[contains(text(),'"+date+" / "+time+"')]"));
			if(particularAppointment.isDisplayed()) {
				actualResult = true;
			}
		}
		return actualResult;
	}
	
}
