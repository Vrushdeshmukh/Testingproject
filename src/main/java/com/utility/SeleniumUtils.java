package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	 private static final int DEFAULT_TIMEOUT=15;
	 
   public static void pageLoadTimeout(WebDriver driver) 
	 {
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
     }
	public static void deleteAllCookies(WebDriver driver)
	{
	 driver.manage().deleteAllCookies();	
	}
	public static void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public static void scrollVertically(WebDriver driver,int pix)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pix+")");
	}
	public static void scrollHorizontally(WebDriver driver,int pix)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+pix+ ",0)");
	}
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true):",element);
	}
	public static String takescreenshot(WebDriver driver,String filename)
	{
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path=System.getProperty("user.dir")+"/screenshot/"+filename+"_"+timestamp+".png";
		
		try 
		{
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(path));
		} catch (IOException e)
		{
			System.out.println("x ss capture failed:" +e.getMessage());
		}
		return path;
	}
	public static WebElement waitForVisibility(WebDriver driver,WebElement element,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}	
	public static void SwitchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public static void SwitchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public static void SwitchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public static void DefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public static void click(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	public static void doubleClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).doubleClick().build().perform();
	}
	public static void moveToElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public static void sendKeys(WebDriver driver,WebElement element,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
		WebElement ele=wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).click().sendKeys(text).build().perform();
	}
	public static void seleniumclick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		
	}
	public static boolean seleniIsdisplayed(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	public static void selenniumsendKeys(WebDriver driver,WebElement element,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
		WebElement ele =wait.until(ExpectedConditions.visibilityOf(element));
		ele.clear();
		ele.sendKeys(text);
		
	}
	
	
	
	
	
	
	
	
		
		
	

}
