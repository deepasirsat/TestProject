package com.mb.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage{
	
@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter email address*']")

public WebElement emailTxt;

@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter Password*']")
public WebElement passwordTxt;

@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Login']")
public WebElement loginBtn;

public LoginPage( AndroidDriver<AndroidElement> driver)
{
	PageFactory.initElements(driver, this);
}
 public void validation()
 {
	 emailTxt.sendKeys("deepa");
	 passwordTxt.sendKeys("123");
	 loginBtn.click();
 }

}