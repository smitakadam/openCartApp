package com.demo.openCart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.openCart.utils.Constants;
import com.demo.openCart.utils.ElementUtil;

import io.qameta.allure.Step;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
//	1. Object Repository
	private By resultDesc = By.xpath("//div[@class='caption']/h4/a");
	
//	2. Constructor
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	3. Page actions
	
	public int getSearchProductResultCount()
	{
		return elementUtil.waitForElementsToVisible(resultDesc, Constants.DEFAULT_TIMEOUT_WAIT).size();
	}
	@Step("Step - Select Product: {0}")
	public ProductDetailsPage selectProduct(String selectProduct)
	{
		List<WebElement> elements = elementUtil.waitForElementsToVisible(resultDesc, Constants.DEFAULT_TIMEOUT_WAIT);
		if(elements.size()>0)
		{
			for(WebElement e: elements)
			{
				if(e.getText().equalsIgnoreCase(selectProduct))
				{	
					e.click();
					return new ProductDetailsPage(driver);
				}	
			}
		}
		return null;
	}
}
