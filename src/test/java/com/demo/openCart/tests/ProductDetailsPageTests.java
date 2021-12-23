package com.demo.openCart.tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.openCart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 102: OpenCart App: Product Details Page Tests")
@Story("User Story: Product Details..." )
public class ProductDetailsPageTests extends BaseTest{
	
	@BeforeClass
	public void productDetailsPageSetup()
	{
		System.out.println("@BeforeClass: productDetailsPageSetup");
		loginPage = homePage.navigateToLoginPage();
		myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][] productDetailsData()
	{
		return new Object[][] {
			{"macbook", "MacBook Pro", "Apple", "Out Of Stock", "Product 18"},
			{"apple", "Apple Cinema 30\"", "Apple", "Out Of Stock", "Product 15"},
			{"imac", "iMac", "Apple", "Out Of Stock", "Product 14"}
			
		};
	}
	
//	@Test(dataProvider = "productDetailsData")
	public void productDetailsPageTest(String searchProduct, String selectProduct)
	{
		System.out.println("@Test: productDetailsPageTest");
		searchResultPage = myAccountPage.searchProduct(searchProduct);
		productDetailsPage = searchResultPage.selectProduct(selectProduct);
		ArrayList<String> prodDetails = productDetailsPage.getProductDetails();
		
		Assert.assertTrue(prodDetails.get(0).equals(selectProduct),  "Verifying product name...");
	}

	@Description("check product Features: {1}, {2}, {3}, {4}")
	@Severity(SeverityLevel.NORMAL)
	@Test(dataProvider = "productDetailsData")
	public void productFeaturesTest(String searchProduct, String selectProduct, String brand, String availability, String productCode)
	{
		System.out.println("@Test: productFeaturesTest");
		searchResultPage = myAccountPage.searchProduct(searchProduct);
		productDetailsPage = searchResultPage.selectProduct(selectProduct);
		HashMap<String, String> prodDetails = productDetailsPage.getProductFeatures();
//		softAssert.assertTrue(prodDetails.get("Brand").contains(brand), "Verifying brand...");
		softAssert.assertEquals(prodDetails.get("Brand"), brand);
		
//		softAssert.assertTrue(prodDetails.get("Availability").contains(availability), "Verifying Availability...");
		
		softAssert.assertEquals(prodDetails.get("Availability"), availability);
		
//		softAssert.assertTrue(prodDetails.get("Product Code").contains(productCode), "Verifying Product Code...");

		softAssert.assertEquals(prodDetails.get("Product Code"), productCode);
		
		softAssert.assertAll();
//		prodDetails
	}
	
//	@Test(dataProvider = "productDetailsData")
	public void productPriceTest(String searchProduct, String selectProduct)
	{
		System.out.println("@Test: productPriceTest");
		searchResultPage = myAccountPage.searchProduct(searchProduct);
		productDetailsPage = searchResultPage.selectProduct(selectProduct);
		HashMap<String, String> prodDetails = productDetailsPage.getProductPriceData();
	}

	
//	@Test(dataProvider = "productDetailsData")
	public void productNameTest(String searchProduct, String selectProduct)
	{
		System.out.println("@Test: productNameTest");
		searchResultPage = myAccountPage.searchProduct(searchProduct);
		productDetailsPage = searchResultPage.selectProduct(selectProduct);
		Assert.assertTrue(productDetailsPage.getProductName().equals(selectProduct),  "Verifying product name...");
	
	}

	@BeforeMethod
	public void BMethod()
	{
		System.out.println("@BeforeMethod: BMethod");
		
	}
	@AfterMethod
	public void AMethod()
	{
		System.out.println("@AfterMethod: AMethod");
		
	}
	@AfterClass
	public void AClass()
	{
		System.out.println("@AfterClass: logout");
		
	}
}
