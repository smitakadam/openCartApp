package com.demo.openCart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.demo.openCart.Listeners.ExtentReportListener;
import com.demo.openCart.factory.DriverFactory;
import com.demo.openCart.pages.HomePage;
import com.demo.openCart.pages.LoginPage;
import com.demo.openCart.pages.MyAccountPage;
import com.demo.openCart.pages.ProductDetailsPage;
import com.demo.openCart.pages.RegistrationPage;
import com.demo.openCart.pages.SearchResultPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;
	public LoginPage loginPage;
	public RegistrationPage registrationPage;
	public HomePage homePage;
	public MyAccountPage myAccountPage;
	public SearchResultPage searchResultPage;
	public ProductDetailsPage productDetailsPage;
	
	public SoftAssert softAssert;
	
	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("@BeforeSuite: ");	
	}
	
	@BeforeTest
	public void setup()
	{
		System.out.println("BeforeTest: ");
		
		df = new DriverFactory();
		prop = df.initProperties();
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("@AfterTest: ");
		
		driver.quit();
	}
	@AfterSuite
	public void suiteCleanUp()
	{
		System.out.println("@AfterSuite: ");	
	}
	
}
