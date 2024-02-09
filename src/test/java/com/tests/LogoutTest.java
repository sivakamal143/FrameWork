package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Login_Functionality;
import com.pages.Logout_Functionality;

public class LogoutTest extends TestBase
{
	Login_Functionality lf;
	Logout_Functionality lo;
	
//	public LogoutTest()
//	{
//		super();
//	}
	
	@BeforeMethod
	public void intialize()
	{
		Setup();
		
		 lf=new Login_Functionality(driver);
		 
		  lo=new Logout_Functionality(driver);
		 
	}
	
	@Test
	public void loginlogout() throws Throwable
	{
		lf.validateLogin();
		lo.validateLogout();
	}
	

}
