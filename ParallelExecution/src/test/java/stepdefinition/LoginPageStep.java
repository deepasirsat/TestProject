package stepdefinition;

import com.mb.screens.LoginPage;
import com.mobile.base.MobileBaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep extends MobileBaseClass { 

		String device,UDID,plateformVersion,url;
		LoginPage page;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		
	System.out.println("Login page");
	 MobileBaseClass.capabilities(device, UDID, plateformVersion, url);
		
	}

	@When("^user enter username$")
	public void user_enter_username() throws Throwable {
		new LoginPage(driver);
		page.validation();
		

	}

	@When("^user eneter pass$")
	public void user_eneter_pass() throws Throwable {
		new LoginPage(driver);
		page.validation();
 
	}

	@Then("^user on home page$")
	public void user_on_home_page() throws Throwable {
		new LoginPage(driver);
		page.validation();
	}

	
}
