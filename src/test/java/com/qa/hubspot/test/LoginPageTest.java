package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifySignUpLinkText(){
		System.out.println("Sign up link text is "+loginPage.verifySignUpLinkDisplayed());
		Assert.assertTrue(loginPage.verifySignUpLinkDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyAccountText(){
		System.out.println("Account text is : "+loginPage.verifyAccountTxt());
		Assert.assertEquals(loginPage.verifyAccountTxt(), Constants.ACCOUNT_LABEL);
	}
	
	@Test(priority = 4)
	public void verifyEmailAddressText(){
		System.out.println("Email text is : "+loginPage.verifyEmailLabel());
		Assert.assertEquals(loginPage.verifyEmailLabel(), Constants.EMAIL_ADDRESS_LABEL);
	}
	
	@Test(priority = 5)
	public void verifyPasswordText(){
		System.out.println("Password text is : "+loginPage.verifyPasswordLabel());
		Assert.assertEquals(loginPage.verifyPasswordLabel(), Constants.PASSWORD_LABEL);
	}
	
	@Test(priority = 6)
	public void verifyShowPasswordText(){
		System.out.println("Show password text is "+loginPage.verifyShowPasswordLinkDisplayed());
		Assert.assertTrue(loginPage.verifyShowPasswordLinkDisplayed());
	}
	
	@Test(priority = 7)
	public void verifyForgotPasswordLink(){
		System.out.println("Forgot password link is : "+loginPage.verifyForgotPasswordDisplayed());
		Assert.assertTrue(loginPage.verifyForgotPasswordDisplayed());
	}
	
	@Test(priority = 8)
	public void verifyRememberMeCheckbox(){
		System.out.println("Remember me checkbox is : "+loginPage.verifyRememberMeCheckboxDisplayed());
		Assert.assertTrue(loginPage.verifyRememberMeCheckboxDisplayed());
	}
	
	@Test(priority = 9)
	public void verifyRememberMeText(){
		System.out.println("Remember me text is :"+loginPage.verifyRememberMeLabel());
		Assert.assertEquals(loginPage.verifyRememberMeLabel(), Constants.REMEMBER_ME_LABEL);
	}
	
	@Test(priority = 10)
	public void verifyGoogleButton(){
		System.out.println("Google button is : "+loginPage.verifyGoogleButtonDisplayed());
		Assert.assertTrue(loginPage.verifyGoogleButtonDisplayed());
	}
	
	@Test(priority = 11)
	public void verifySSOButton(){
		System.out.println("SSO button is : "+loginPage.verifySSOButtonDisplayed());
		Assert.assertTrue(loginPage.verifySSOButtonDisplayed());
	}
	
	@Test(priority = 12)
	public void loginTestWithCorrectCredential(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}