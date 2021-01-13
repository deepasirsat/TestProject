package com.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
@CucumberOptions(features="src/test/java/feature"
,glue={"stepdefinition"},
tags={"@Login"},plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests   {
	public  static WebDriver driver=null;
	private TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass
	public void setUpCucumber()
	{
		 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		 System.out.println("setUpCucumber");
		 

	}
	@Test(dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberfeature)
	{
		testNGCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
	}
  @DataProvider(parallel = false)
   public Object[][]features()
   { return testNGCucumberRunner.provideFeatures();
	 
   }

}
