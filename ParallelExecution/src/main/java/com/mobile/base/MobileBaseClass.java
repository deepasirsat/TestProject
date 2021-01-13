package com.mobile.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBaseClass {
	public static AndroidDriver<AndroidElement> driver;
	public static Properties propconfig;
	public static String currentdir;
	
	@Parameters({"device","UDID","platformVersion","url"})
	@BeforeTest
	public  static void capabilities(String device,String UDID,String platformVersion,String url) throws MalformedURLException, InterruptedException
	{
		System.out.println("launch emulator called");
		System.out.println(device);
		System.out.println(UDID);
		System.out.println(platformVersion);
		
		
		File appDir=new File("lib");
		File app=new File(appDir,"IntelliReflex.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion );
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<>(new URL("http://"+url), cap);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 Thread.sleep(10000);
	    System.out.println("app open successfully");
	    
	}
	public  static void  getScreenShot(String s) throws IOException
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+s+".png"));
	}
	
	
	
}
