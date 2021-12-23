package com.demo.openCart.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.openCart.factory.DriverFactory;

import io.qameta.allure.Attachment;

public class AllureReportListeners extends DriverFactory implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

//	@Attachment (value= "Page screenshot", type="image/png")
//	public static byte[] saveScreenshotPNG(WebDriver driver)
//	{
//		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	}
	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment (value= "{0}", type="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	@Attachment (value= "{0}", type="text/html")
	public static String saveHTMLLog(String html)
	{
		return html;
	}
	@Override
	public void onStart(ITestContext iTestcontext) {
		System.out.println("In onStart Method: "+ iTestcontext.getName());
	}
	
	@Override
	public void onFinish(ITestContext iTestcontext) {
		System.out.println("In onFinish Method: "+ iTestcontext.getName());
	}

	@Override
	public void onTestFailure(ITestResult iTestresult) {
		
		System.out.println("In onTestFailure Method: "+ getTestMethodName(iTestresult));
		if (getDriver() instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestresult));
			saveScreenshotPNG(getDriver());
		}
		saveTextLog(getTestMethodName(iTestresult) + " failed and screenshot is taken...");
	}

	@Override
	public void onTestStart(ITestResult iTestresult) {
		System.out.println("In onTestStart Method: "+ getTestMethodName(iTestresult));
	}

	@Override
	public void onTestSuccess(ITestResult iTestresult) {
		System.out.println("In onTestSuccess Method: "+ getTestMethodName(iTestresult));
	}
	
	
	
	
	
	

}
