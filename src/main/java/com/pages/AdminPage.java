package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.SeleniumUtils;

public class AdminPage {
	
	private WebDriver driver;
	
    @FindBy(xpath="//span[text()='User Management ']")
    private WebElement userManagement;
    
    @FindBy(xpath="//span[text()='Job ']")
    private WebElement job;
    
    public AdminPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public boolean visibilityOfUserManagement()
    {
    	return SeleniumUtils.seleniIsdisplayed(driver, userManagement);
    }
    public boolean visibilityOfJob()
    {
    	return SeleniumUtils.seleniIsdisplayed(driver, job);
    }
}
