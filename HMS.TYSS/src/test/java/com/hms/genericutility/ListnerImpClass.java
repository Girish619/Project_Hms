package com.hms.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		//Execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"---> Test Script execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---> Passed");
		Reporter.log(methodName+"--->TestScript Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String failedScript = methodName + new JavaUtility().getSystemDateInFormat();
		TakesScreenshot tScreenshot = (TakesScreenshot) BaseClass_Patient.sDriver;
//		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass_Patient.sDriver);
		File src = tScreenshot.getScreenshotAs(OutputType.FILE);
		String path = "./ScreenShots/"+failedScript+".png";
		File dst = new File(path);
		try {
			FileUtils.copyFile(src, dst);
			test.addScreenCaptureFromPath(failedScript);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, methodName+"---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName+"---> TestScript Failed");
	
//		try {
//			String failedScript = WebDriverUtility.getScreenShot(BaseClass_Patient.sDriver, result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(failedScript);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"---> TestScript Skipped");
	}

	public void onStart(ITestContext context) {
		
		//Create HTML Report
		ExtentSparkReporter eReporter = new ExtentSparkReporter("./ExtentReport/Report.html");
		eReporter.config().setDocumentTitle("TYSS");
		eReporter.config().setTheme(Theme.DARK);
		eReporter.config().setReportName("HMS");
		
		report = new ExtentReports();
		report.attachReporter(eReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-Url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter Name", "Girish");
		
	}

	public void onFinish(ITestContext context) {
		
		//Consolidate the report
		report.flush();
	}

	
	
}
