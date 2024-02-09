package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class Logout_Functionality extends TestBase
{
	@FindBy(xpath="//span[@class='theme-avtar']")
	
	WebElement path;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement logout;
	
	public  Logout_Functionality(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateLogout() throws Throwable
	{
		
		Thread.sleep(2000);
		
		path.click();
		
		logout.click();
		
	}
	

}
