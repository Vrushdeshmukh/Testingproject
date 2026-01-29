package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.SeleniumUtils;

public class Loginpage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public Loginpage(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements(driver,this);//initilize elements
	}
	
	public void inputUserName(String name)
	{
		SeleniumUtils.sendKeys(driver, username, name);
	}
	
	public void inputPassword(String passd)
	{
		SeleniumUtils.sendKeys(driver, password,passd);
	}
	
	public void clickToLoginBtn()
	{
		SeleniumUtils.seleniumclick(driver, login);
	}
	
	public boolean isusernameDisplayed()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, username);
	}
	
	public boolean isPasswordfieldDisplayed()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, password);
	}
	
	public boolean isLoginBtnDisplayed()
	{
		return SeleniumUtils.seleniIsdisplayed(driver, login);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void Login(String name,String pass) throws InterruptedException
	{
	inputUserName(name);
	Thread.sleep(4000);
	inputPassword(pass);
	Thread.sleep(4000);
	clickToLoginBtn();
	}
	
	public void InvalidLogin(String name,String pass)
	{
		inputUserName(name);
		inputPassword(pass);
		clickToLoginBtn();
	}
}
