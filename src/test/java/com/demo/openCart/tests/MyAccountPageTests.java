package com.demo.openCart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.openCart.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 101: OpenCart App: My Accounts Page Tests")
@Story("User Story: My Accounts Page features..." )
public class MyAccountPageTests extends BaseTest{
	
	@BeforeClass
	public void MyAccountPageSetup()
	{
		System.out.println("@BeforeClass: MyAccountPageTests");
		loginPage = homePage.navigateToLoginPage();
		myAccountPage  = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@BeforeClass
	public void MyAccountPageSetup1()
	{
		System.out.println("@BeforeClass: MyAccountPageTests 1");
//		loginPage = homePage.navigateToLoginPage();
//		myAccountPage  = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@BeforeMethod
	public void MyAccountPageSetup2()
	{
		System.out.println("@@BeforeMethod: MyAccountPageTests");
//		loginPage = homePage.navigateToLoginPage();
//		myAccountPage  = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void MyAccountPageAfterMethod()
	{
		System.out.println("@AfterMethod: MyAccountPageTests");
//		loginPage = homePage.navigateToLoginPage();
//		myAccountPage  = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void LogoutLinkTest()
	{
		System.out.println("@Test: LogoutLinkTest");
		Assert.assertEquals(myAccountPage.verifyIfLogoutLinkExists(), true, "Verify if Logout link exists.");
	}
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void SearchFieldExistsTest()
	{
		System.out.println("@Test: SearchFieldExistsTest");
		Assert.assertEquals(myAccountPage.verifyIfSearchFieldExists(), true, "Verify if Search field exists.");
		
	}

	@DataProvider
	public Object[][] productsSearch()
	{
		return new Object[][] {
			{"macbook"},
			{"imac"},
			{"apple"}
			
		};
	}
	
	@Test(dataProvider = "productsSearch")
	public void SearchTest(String product)
	{
		System.out.println("@Test: SearchTest");
		searchResultPage = myAccountPage.searchProduct(product);
		
		Assert.assertTrue(searchResultPage.getSearchProductResultCount()>0, "Verify result count...");
	}
	
	@DataProvider
	public Object[][] productsSelectData()
	{

		return new Object[][] {
			{"macbook", "MacBook Pro"},
			{"imac", "iMac"},
			{"apple","Apple Cinema 30\""}
			
		};
	}
	@Test(dataProvider="productsSelectData")
	public void SearchAndSelectProductTest(String searchProduct, String selectProduct)
	{
		System.out.println("@Test: SearchTest");
		searchResultPage = myAccountPage.searchProduct(searchProduct);
		productDetailsPage = searchResultPage.selectProduct(selectProduct);
		productDetailsPage.getProductName();
		
//		Assert.assertTrue(searchResultPage.getSearchProductResultCount()>0, "Verify result count...");
	}
	
	@AfterClass
	public void logout()
	{
		System.out.println("@AfterClass: MyAccountPageTests");
	}
	
}
