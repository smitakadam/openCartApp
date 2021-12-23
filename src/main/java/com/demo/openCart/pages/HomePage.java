package com.demo.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.openCart.utils.ElementUtil;

public class HomePage {
	public WebDriver driver;
	public ElementUtil elementUtil;
	
//	1. Object Repository
	private By myAccount = By.xpath("//a[@title='My Account']/span[@class='caret']");
	private By loginLink = By.linkText("Login");
	private By registerLink = By.linkText("Register");
	
//	2. Constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	3. Page actions
	public LoginPage navigateToLoginPage()
	{
		elementUtil.doClick(myAccount);
		elementUtil.doClick(loginLink);
		return new LoginPage(driver);
	}
	

	public RegistrationPage navigateToRegistrationPage() 
	{
		elementUtil.doClick(myAccount);
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
}
