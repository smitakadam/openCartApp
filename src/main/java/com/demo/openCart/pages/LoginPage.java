package com.demo.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.openCart.utils.ElementUtil;

public class LoginPage {

	public WebDriver driver;
	public ElementUtil elementUtils;
	
//	1. Object Repository
	private By registerLink = By.xpath("//a[text()=\"Register\" and @class=\"list-group-item\"]");

	private  By email = By.xpath("//input[@id=\"input-email\"]");
	private By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
	private By password = By.xpath("//input[@id=\"input-password\"]");
	
//	2. Page Constructor
	/**
	 * Page Constructor accepts WebDriver and initializes ElementUtil using driver.
	*/
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtil(driver);
	}

//	3. Page actions
//	
//	public RegistrationPage navigateToRegistrationPage() 
//	{
//		elementUtils.doClick(registerLink);
//		return new RegistrationPage(driver);
//	}
	
	public MyAccountPage login(String email, String password)
	{
		elementUtils.doSendKeys(this.email, email);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doClick(loginButton);
		
		return new MyAccountPage(driver);
		
	}
}
