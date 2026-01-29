package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.config.ConfigReader;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();//to handle multiple thread at a time-----encapsulation
	public static WebDriver initDriver()
	{
		String browser=ConfigReader.get("browser");//method call with class name
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			boolean isheadless=Boolean.parseBoolean(ConfigReader.get("headless"));
			if(isheadless)
			{
				options.addArguments("--headless=new");
			}
			driver.set(new ChromeDriver(options));
		}else if(browser.equalsIgnoreCase("edge"))
		{
	
		}
		return getDriver();
		
	}
	public static WebDriver getDriver()
	{
		return driver.get();
	}

}
