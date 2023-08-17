package com.hms.objectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage {

	//Declaration
	@FindBy(xpath="//td[@class='center']")
	private List<WebElement> serialNumbers;
	
	@FindBy(xpath="//td[@class='hidden-xs']")
	private List<WebElement> userNames;
	
	//Initialization
	public ManageUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public List<WebElement> getSerialNumbers() {
		return serialNumbers;
	}

	public List<WebElement> getUserNames() {
		return userNames;
	}

	//Business Libraries
	public boolean verifyUser(WebDriver driver, String userName) {
		boolean actualResult = false;
		if(serialNumbers.size()>0) {
			for (int i = 0; i < serialNumbers.size(); i++) {
			if(userNames.get(i).getText().contains(userName)){
				actualResult = true;
				break;
			}else {
				actualResult = false;
			}
			}
		}else {
			actualResult = false;
		}
		return actualResult;
	}
}
