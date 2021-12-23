package com.demo.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.openCart.utils.ElementUtil;

public class RegistrationPage {

	public WebDriver driver;
	public ElementUtil elementUtils;	
	
//	1. Object Repository
	private By firstname = By.xpath("//input[@id=\"input-firstname\"]");
	private By lastname = By.xpath("//input[@id=\"input-lastname\"]");
	private By email = By.xpath("//input[@id=\"input-email\"]");
	private By telephone = By.xpath("//input[@id=\"input-telephone\"]");
	private By password = By.xpath("//input[@id=\"input-password\"]");
	private By confirm = By.xpath("//input[@id=\"input-confirm\"]");
	
	private By agree = By.xpath("//input[@name=\"agree\"]");
	private By Continue = By.xpath("//input[@value=\"Continue\"]");

//	2. Page Constructor
	/**
	 * Page Constructor accepts WebDriver and initializes ElementUtil using driver.
	*/	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtil(driver);
	}

//	3. Page Actions
	
	public void registerAccount()
	{

		String firstname = "smita";

		String lastname = "k";
		String email = "smityadav@gmail.com";
		String telephone = "9876543211";
		String password = "sasa1234";
		
		
		elementUtils.doSendKeys(this.firstname, firstname);
		elementUtils.doSendKeys(this.lastname, lastname);
		elementUtils.doSendKeys(this.email, email);
		elementUtils.doSendKeys(this.telephone, telephone);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doSendKeys(this.confirm, password );

		elementUtils.doClick(agree);
		elementUtils.doClick(Continue);
		
//		 Warning: E-Mail Address is already registered! 
	}
}
