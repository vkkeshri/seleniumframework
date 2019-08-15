package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage{
	
	ElementActions elementActions;
	
	By homePageHeader = By.xpath("//h1[@class='private-header__heading']");
	By accountMenu = By.xpath("//*[@id='account-menu']/svg");
	
	
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
	
	public void accountMenuClick(){
		
	}
}
