package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage{
	
	ElementActions elementActions; 

	//Define locators without page factory
	By email = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By signUpLbl = By.xpath("//*[@id='hs-login']/div[1]/i18n-string");
	By emailAddressLbl = By.xpath("//*[@id='hs-login']/div[3]/div/div/div[1]/label/i18n-string");
	By passwordLbl = By.xpath("//*[@id='hs-login']/div[4]/div/div/div[1]/label/i18n-string");
	By showPassword = By.xpath("//*[@id='password-help']/button/span");
	By forgotPassword = By.linkText("Forgot my password");
	By rememberMeCheckBox = By.className("private-checkbox__indicator");
	By rememberMeLbl = By.xpath("//*[@id='hs-login']/div[5]/label/span/span[2]/i18n-string");
	By signInWithGoogleBtn = By.className("google-sign-in");
	By logInWithSSOBtn = By.id("ssoBtn");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	public String getLoginPageTitle(){
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
	}
	
	public boolean verifySignUpLinkDisplayed(){
		return elementActions.elementIsDisplayed(signUpLink);
	}
	
	public String verifyAccountTxt(){
		return elementActions.getElementText(signUpLbl);
	}
	
	public String verifyEmailLabel(){
		return elementActions.getElementText(emailAddressLbl);
	}
	
	public String verifyPasswordLabel(){
		return elementActions.getElementText(passwordLbl);
	}
	
	public boolean verifyShowPasswordLinkDisplayed(){
		return elementActions.elementIsDisplayed(showPassword);
	}
	
	public boolean verifyForgotPasswordDisplayed(){
		return elementActions.elementIsDisplayed(forgotPassword); 
	}
	
	public boolean verifyRememberMeCheckboxDisplayed(){
		return elementActions.elementIsDisplayed(rememberMeCheckBox);
	}
	
	public String verifyRememberMeLabel(){
		return elementActions.getElementText(rememberMeLbl);
	}
	
	public boolean verifyGoogleButtonDisplayed(){
		return elementActions.elementIsDisplayed(signInWithGoogleBtn);
	}
	
	public boolean verifySSOButtonDisplayed(){
		return elementActions.elementIsDisplayed(logInWithSSOBtn);
	}
	
	public HomePage doLogin(String username, String pwd){
		elementActions.elementSendKeys(email, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
		TimeUtil.mediumWait();
		
		return new HomePage(driver);
	}

}
