package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author VDK
 *
 */
public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method is used to initialize the webdriver
	 * @param prop
	 * @return driver
	 */
	public WebDriver initialize_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else{
			System.out.println("Browser "+browserName+" is not defined in properties file, please give the correct browser name.");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		
		return driver;
	}
	/**
	 * This method is used to initialize properties and it will return properties reference
	 * @return prop
	 */
	public Properties initialize_properties(){
		prop = new Properties();
		try {
			//FileInputStream ip = new FileInputStream("C:/AerisAutomation/eclipse/workspace/seleniumframework/src/main/java/com/qa/hubspot/configuration/config.properties");
			InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
