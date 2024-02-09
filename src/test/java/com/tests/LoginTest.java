package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Login_Functionality;
import com.util.Data;

public class LoginTest extends TestBase
{
	 public static Login_Functionality lf;
	public static String sheetname = "login";
	
	
	public LoginTest() {
		
		super();
	}
	
	
	@DataProvider
	public String[][] exl() throws Throwable{
		
		
         return Data.setdata(sheetname);
		
		
	}
	
	@BeforeMethod
	public void initialize() {
		
		Setup();
		
		 lf= new Login_Functionality(driver);
	}
	
	@Test(dataProvider = "exl", dataProviderClass= LoginTest.class)
	public void cd(String username, String password) throws Throwable  {
		
	      lf.validateLogin(username, password);
	      String tit= driver.getTitle();
	     // Assert.assertEquals("Marolix HRMS -     Login", tit);
	}
 
	}
