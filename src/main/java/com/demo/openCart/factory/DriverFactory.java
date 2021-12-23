package com.demo.openCart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	public static ThreadLocal<WebDriver> thlDriver = new ThreadLocal<WebDriver>();	
	
	public WebDriver initDriver(Properties prop)
	{
		String browser = prop.getProperty("browser");
		
		System.out.println("Browser is "+ browser);
		
		switch (browser) {
		case "chrome":
//			System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			thlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			thlDriver.set(driver);
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			thlDriver.set(driver);
			break;
		}	

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	public synchronized WebDriver getDriver()
	{
		return thlDriver.get();
	}
	
	public Properties initProperties()
	{
		Properties prop = new Properties();
		try {
			
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public synchronized String getScreenShot()
	{
		File screenShotFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(screenShotFile, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return path;
		
	}
}
