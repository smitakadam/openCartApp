package com.demo.openCart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.openCart.base.BaseTest;
import com.demo.openCart.utils.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100: OpenCart App: Login Page Tests")
@Story("User Story: Login Page features..." )
public class LoginPageTests extends BaseTest{
	
	@BeforeClass
	public void pageSetup()
	{
		System.out.println("@BeforeClass : LoginPageTests");
		loginPage = homePage.navigateToLoginPage();
	}
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void LoginTest()
	{
		myAccountPage = loginPage.login("smityadav@gmail.com", "sasa1234");
		Assert.assertEquals(myAccountPage.getPageTitle(), Constants.ACC_PAGE_TITLE, "Login Status check.");
//		Assert.assertTrue(myAccountPage.verifyPageTitle(Constants.ACC_PAGE_TITLE), "Login Status successful!");
	}
	
	@AfterClass
	public void endClass()
	{
		System.out.println("@AfterClass : LoginPageTests");
	}
}
