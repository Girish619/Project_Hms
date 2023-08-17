package com.hms.objectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalHistoryPage {
	//Declaration
		@FindBy(xpath="//td[@class='center']")
		private List<WebElement> serialNumbers;
		
		@FindBy(xpath="//td[@class='hidden-xs']")
		private List<WebElement> doctorNames;
		
		@FindBy(xpath="//i[@class='fa fa-eye']")
		private List<WebElement> viewIcons;
		
		//Initialization
		public MedicalHistoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public List<WebElement> getSerialNumbers() {
			return serialNumbers;
		}

		public List<WebElement> getDoctorNames() {
			return doctorNames;
		}

		public List<WebElement> getviewIcons() {
			return viewIcons;
		}
		
		//Business Libraries
		public String viewMedicalHistory(WebDriver driver, String serialNumber) {
			String actualResult = "";
			if(serialNumbers.size()>0) {
					WebElement viewParticular = driver.findElement(By.xpath("//td[text()='"+serialNumber+"']/following-sibling :: td//i"));
					viewParticular.click();
					actualResult = driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
			}else {
				System.out.println("There are no Medical History to show");
			}
			return actualResult;
		}
}
