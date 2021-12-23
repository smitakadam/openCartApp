package com.demo.openCart.pages;

import org.openqa.selenium.WebDriver;

import com.demo.openCart.utils.ElementUtil;

public class ProductFeature {

	public WebDriver driver;
	public ElementUtil elementUtils;

//	2. Page Constructor
	/**
	 * Page Constructor accepts WebDriver and initializes ElementUtil using driver.
	*/
	public ProductFeature(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtil(driver);
	}

	public void method1()
	{}
	public void method2()
	{}

	public void method11()
	{}
	public void method12()
	{}
}
