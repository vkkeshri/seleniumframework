package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;

public class ContactsPage extends BasePage {

	ElementActions elementActions;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	

}
