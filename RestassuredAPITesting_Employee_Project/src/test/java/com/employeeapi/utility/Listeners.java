package com.employeeapi.utility;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	//@Override
	public void onTestStart(ITestResult result) {
		
		
//	}
	
	//@Override
	//public void onStart(ITestContext context) {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");//title of report
		htmlReporter.config().setReportName("Rest API Testing Report");//name of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","Employee Database API");
		extent.setSystemInfo("Host name","localhost");
		//extent.setSystemInfo("Environment","QA");
		//extent.setSystemInfo("QA","Avancer");
		

	}
	

	//@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test case passed is "+result.getName());
		
	}

//	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case failed is  "+result.getName());//to add name in extent report
		test.log(Status.FAIL,"Test case failed is  " +result.getThrowable());// to add error/exception in extent report
		
	}

	//@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case Skipped is  "+result.getName());
		
	}

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

//	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

	
	
	
}
