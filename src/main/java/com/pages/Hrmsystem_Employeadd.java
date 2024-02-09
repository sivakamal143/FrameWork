package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class Hrmsystem_Employeadd extends TestBase
{
	@FindBy(xpath="//span[text()='HRM System']")
	WebElement hrmsys;
	
	@FindBy(xpath="//a[text()='Employee']")
	WebElement employ;
	
	@FindBy(xpath="//i[@class='ti ti-pencil']")
	WebElement edit;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement add;
	
	
	public Hrmsystem_Employeadd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void changeAddress()
	{
		hrmsys.click();
		employ.click();
		edit.click();
		add.sendKeys(p.getProperty("address"));
	}
	
	

}
