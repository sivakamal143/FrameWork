package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class Login_Functionality extends TestBase
{
	@FindBy(name="email")
	WebElement usr;
	
	
	@FindBy(id="password")
	WebElement pass;
	
	
	
	@FindBy(id="login_button")
	WebElement login;
	
	
	public Login_Functionality(WebDriver driver) 
	{
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void validateLogin(String username , String password) throws Throwable 
	{
		
		usr.sendKeys(username);
		pass.sendKeys(password);
		//usr.sendKeys(p.getProperty(username));
		//pass.sendKeys(p.getProperty(password));
		Thread.sleep(2000);
		login.click();
		
		
		
		
		
	}
	
	

}
