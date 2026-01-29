package com.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.ConfigReader;
import com.driver.DriverFactory;
import com.utility.SeleniumUtils;

public class BaseTest {
	
protected WebDriver driver;
@BeforeMethod
public void setUp() throws IOException
{
	ConfigReader.loadConfig();
	driver=DriverFactory.initDriver();//webdriver driver=new chromedriver;
	SeleniumUtils.deleteAllCookies(driver);
	driver.get(ConfigReader.get("baseurl"));
	SeleniumUtils.maximizeWindow(driver);
	SeleniumUtils.pageLoadTimeout(driver);
	
}	
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}

