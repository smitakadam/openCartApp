package com.demo.openCart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.openCart.base.BaseTest;

public class RegistrationPageTests extends BaseTest {
	
	@BeforeClass
	public void pageSetup()
	{
		registrationPage = homePage.navigateToRegistrationPage();
	}

	@Test
	public void Test1()
	{
//		registrationPage.registerAccount();
	}
}
