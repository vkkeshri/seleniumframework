package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class ContactsPage extends BasePage {

	ElementActions elementActions;
	
	By createContactBtn = By.xpath("//span[text()='Create contact']");
	By createContactSecondBtn = By.xpath("//li//span[text()='Create contact']");
	By email = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName = By.id("uid-ctrl-3");
	By jobTitle = By.id("uid-ctrl-5");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	public void createContact(String eMail, String fName, String lName, String jobtitle){
		WebDriverWait wait = new WebDriverWait(driver,4);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		elementActions.elementClick(createContactBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementActions.elementSendKeys(email, eMail);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		elementActions.elementSendKeys(firstName, fName);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		elementActions.elementSendKeys(lastName, lName);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		elementActions.elementSendKeys(jobTitle, jobtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		elementActions.elementClick(createContactSecondBtn);		
	}
}