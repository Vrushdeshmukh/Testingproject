package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.SeleniumUtils;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pim;
	
	@FindBy(xpath="//span[text()='Time']")
	private WebElement time;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean visibilityOfAdminTab()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, admin);
	}
	
	public boolean visibilityOfPimTab()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, pim);
	}
	
	public boolean visibilityOfTimeTab()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, time);
	}
	public boolean clickToAdminTab()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, admin);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

}
