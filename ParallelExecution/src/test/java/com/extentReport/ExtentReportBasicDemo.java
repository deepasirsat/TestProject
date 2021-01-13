package com.extentReport;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class ExtentReportBasicDemo {
	public static void main (String args[]) 
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentreport.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test=extent.createTest("myFirstTest");
		test.pass("testcase is pass");
		test.info("testcompleted");
		extent.flush();
	}
			
	
	

}
