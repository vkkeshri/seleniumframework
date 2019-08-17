package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage{
	
	ElementActions elementActions;
	
	By homePageHeader = By.xpath("//h1[@class='private-header__heading']");
	By parentContactMenu = By.id("nav-primary-contacts-branch");
	By childContactMenu = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	public String getHomePageTitle(){
		elementActions.waitForTitlePresent(Constants.HOME_PAGE_TITLE);
		return elementActions.getPageTitle();
	}
	
	public boolean verifyHomePageHeaderIsDisplayed(){
		return elementActions.elementIsDisplayed(homePageHeader);
	}
	
	public String getHomePageHeader(){
		return elementActions.getElementText(homePageHeader);
	}
	
	public void clickOnContacts(){
		elementActions.elementClick(parentContactMenu);
		TimeUtil.shortWait();
		elementActions.elementClick(childContactMenu);
	}
	
	public ContactsPage goToContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
}
