package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyHomePageHeaderText(){
		System.out.println("Home Page header text is : "+homePage.getHomePageHeader());
		Assert.assertTrue(homePage.verifyHomePageHeaderIsDisplayed());
		Assert.assertEquals(homePage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
