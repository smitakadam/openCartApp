package com.demo.openCart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public WebDriver driver;
	public JavaScriptUtils jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtils(driver);

	}

	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
//		WebElement e = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[contains(@href,'logout')]"));
		jsUtil.flash(ele);
		return ele;
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClick(By locator) {
		driver.findElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
		
	}

	public boolean checkIsDisplayed(By locator)
	{
		System.out.println("========"+ getElement(locator).isDisplayed());

		return getElement(locator).isDisplayed();
	}
	public boolean checkIsEnabled(By locator)
	{
		System.out.println("========"+ getElement(locator).isEnabled());

		return getElement(locator).isEnabled();
	}
	
	public List<WebElement> waitForElementsToVisible(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	}
}
