package com.hms.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericutility.WebDriverUtility;

public class AppointmentHistoryPage {

	//Declaration
	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> serialNumbers;
	
	@FindBy(xpath="//td[@class='hidden-xs']")
	private List<WebElement> doctorNames;
	
	@FindBy(xpath="//a[text()='Cancel']")
	private List<WebElement> cancelButtons;
	
	//Initialization
	public AppointmentHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public List<WebElement> getSerialNumbers() {
		return serialNumbers;
	}

	public List<WebElement> getDoctorNames() {
		return doctorNames;
	}

	public List<WebElement> getCancelButtons() {
		return cancelButtons;
	}
	
	//Business Libraries
	public String cancelAppointment(WebDriver driver, String DocName, String date, String time) {
		String actualResult = "";
		if(serialNumbers.size()>0 && cancelButtons.size()>0) {
			try {
				WebElement cancelParticular = driver.findElement(By.xpath("//td[contains(text(),'"+DocName+"')]/following-sibling :: td[contains(text(),'"+date+" / "+time+"')]/following-sibling :: td//a[@tooltip='Remove']"));
				cancelParticular.click();
				WebDriverUtility wLib = new WebDriverUtility();
				wLib.acceptAlert(driver);
				actualResult = driver.findElement(By.xpath("//p[@style='color:red;']")).getText();
			} catch (Exception e) {
				System.err.println("Appointment already cancelled");
			}
		}else {
			System.out.println("There are no Appointments to cancell");
		}
		return actualResult;
	}
	public void verifyAppointment(WebDriver driver, String DocName, String date, String time) {
		if(serialNumbers.size()>0) {
			try {
				WebElement viewParticular = driver.findElement(By.xpath("//td[contains(text(),'"+DocName+"')]/following-sibling :: td[contains(text(),'"+date+" / "+time+"')]"));
				if(viewParticular.isDisplayed()) {
					System.out.println("Pass: Appointment exist in Appointment History");
				}
			} catch (Exception e) {
				System.err.println("Fail: Appointment not Booked");
			}
		}else {
			System.out.println("There are no Appointments");
		}
	}
}
