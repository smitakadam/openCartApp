package com.demo.openCart.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.openCart.utils.ElementUtil;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	

//	1. Object Repo
	private By productName = By.xpath("//div[@id='content']/div/div[@class='col-sm-4']/h1");
	private By productDesc = By.xpath("//div[@id='tab-description']/div");
	private By productPrice = By.xpath("//div[@id='content']//ul[@class='list-unstyled' and position()=2]/li/h2");
	private By prodFeatures = By.xpath("//div[@id='content']//ul[@class='list-unstyled' and position()=1]/li");
//	2. Constructor
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	3. Page Actions

	public ArrayList<String> getProductDetails()
	{
		ArrayList<String> prodDetails = new ArrayList<>();
				 
		prodDetails.add(getProductName());
		prodDetails.add(getProductDesc());
		prodDetails.add(getProductPrice().replace("$", ""));
		
		return prodDetails;
		
	}
	public HashMap<String, String> getProductFeatures()
	{
		HashMap<String, String> prodFeatures = new HashMap<>();
		List<WebElement> li  = elementUtil.getElements(this.prodFeatures);
		for(WebElement e: li)
		{
			String[] a = e.getText().split(":");
			if(a.length>1)
				prodFeatures.put(a[0].trim(), a[1].trim());
			else
				prodFeatures.put("Price", a[0]);
				
		}
		
		prodFeatures.forEach((k,v) -> System.out.println(k + " : " + v ));
		
		return prodFeatures;
		
	}
	public HashMap<String , String> getProductPriceData()
	{
		HashMap<String, String> prodPriceData = new HashMap<>();
		List<WebElement> li = elementUtil.getElements(this.productPrice);
		for(WebElement e:li)
		{
			String[] a = e.getText().split(":");
			if(a.length>1)
				prodPriceData.put(a[0].trim(), a[1].trim());
			else
				prodPriceData.put("Price", a[0]);
			
		}

		prodPriceData.forEach((k,v) -> System.out.println(k + " : " + v ));
		
		return prodPriceData;
	}
	public String getProductName() {
		
//		System.out.println("........"+ elementUtil.getElement(productName).getText());
		return elementUtil.getElement(productName).getText();
	}
	public String getProductDesc() {
		return elementUtil.getElement(productDesc).getText();
	}
	public String getProductPrice() {
//		System.out.println("........"+ elementUtil.getElement(productPrice).getText());
		return elementUtil.getElement(productPrice).getText();
	}
}
