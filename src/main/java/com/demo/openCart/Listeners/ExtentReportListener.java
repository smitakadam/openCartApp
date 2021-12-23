package com.demo.openCart.Listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demo.openCart.factory.DriverFactory;


public class ExtentReportListener extends DriverFactory implements ITestListener {

	private static ExtentReports extent = init();
	
	private static final String OUTPUT_FOLDER = "./buildReports/";
	private static final String FILE_NAME = "TestExecutionReport.html";
	public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	private static ExtentReports init()
	{
		ExtentReports extentReport;
		Path path = Paths.get(OUTPUT_FOLDER);
//		if path does not exist, then create directory
		if(!Files.exists(path))
		{
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		extentReport = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("System", "Windows");
		extentReport.setSystemInfo("Author", "Smita");
		extentReport.setSystemInfo("Build#", "1.23");
		return extentReport;
	}
	
	public synchronized void onStart(ITestContext context) {
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName
				.substring(0, last)
				.lastIndexOf(".");
		
		String className = qualifiedName.substring(mid + 1, last);
		 
		ExtentTest extentTest = extent.createTest(methodName, result.getMethod().getDescription());
		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
		
	}

	
	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed.");		
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	
	
	@Override
	public synchronized void onTestFailure(ITestResult result) {
		
		test.get().fail(result.getThrowable(), 
				MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		 
		
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	
	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		
		test.get().skip(result.getThrowable(), 
				MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		 
		
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	 
	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
		test.remove();
	}
	
	private Date getTime(long millis)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
}
