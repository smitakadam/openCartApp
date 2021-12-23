package com.demo.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.openCart.utils.Constants;
import com.demo.openCart.utils.ElementUtil;

public class MyAccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
//	1. Object Repository
	private By logoutLink = By.xpath("//div/a[text()='Logout']");
	private By searchField = By.name("search");
//	By searchIcon = By.xpath("//div[@id=\"search\"]/span/button");
	private By searchIcon = By.cssSelector("div#search span button");
	
//	2. Constructor
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	3. Page Actions
	public boolean verifyPageTitle(String title)
	{
		if(elementUtil.getElement(By.xpath("//h1/*")).getText().contains(title))
			return true;
		return false;
		
	}
	public String getPageTitle()
	{
		return elementUtil.getElement(By.xpath("//h1/*")).getText();
		
	}
	
	public boolean verifyIfLogoutLinkExists()
	{
//		return elementUtil.checkIsEnabled(logoutLink);

		if(elementUtil.waitForElementsToVisible(logoutLink, Constants.DEFAULT_TIMEOUT_WAIT).size()==1)
			return true;
		return false;

	}
	public boolean verifyIfSearchFieldExists()
	{
		if(elementUtil.waitForElementsToVisible(searchField, Constants.DEFAULT_TIMEOUT_WAIT).size()==1)
			return true;
		return false;
//		return elementUtil.checkIsEnabled(searchField);
	}
	
	public SearchResultPage searchProduct(String seacrhValue )
	{
		System.out.println("searchProduct: "+ seacrhValue);
		elementUtil.doSendKeys(searchField, seacrhValue);
		elementUtil.doClick(searchIcon);
		return new SearchResultPage(driver);
	}
}
