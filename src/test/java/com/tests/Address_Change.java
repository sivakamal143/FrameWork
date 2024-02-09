package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Hrmsystem_Employeadd;
import com.pages.Login_Functionality;
import com.pages.Logout_Functionality;

public class Address_Change extends TestBase
{
	Login_Functionality lf;
	Logout_Functionality lo;
	Hrmsystem_Employeadd add;
	
	@BeforeMethod
	public void intialize()
	{
		Setup();
		
		 lf= new Login_Functionality(driver);
		 lo= new Logout_Functionality(driver);
		 add= new Hrmsystem_Employeadd(driver);
	}
	
	@Test
	public void validatingAdd() throws Throwable
	{
		lf.validateLogin();
		add.changeAddress();
		lo.validateLogout();
	}
	

}
