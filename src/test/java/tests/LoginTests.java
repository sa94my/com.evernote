package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.Visitor_HomePage;
import pages.LoggedInUser_HomePage;
import pages.LoginPage;

public class LoginTests extends TestBase{

	private String validUser_UserName = "temp@tmpbox.net" ;
	private String validUser_Password = "PASSword123";
	
	@Test
	@Description("Valid login test with correct username and password")

	public void validLogin_WithCredintials() {
		var homePageObject = new Visitor_HomePage();
		homePageObject.navigateToLoginPage();
		
		var loginPageObject = new LoginPage();
		loginPageObject.loginWithCredintials(validUser_UserName, validUser_Password);
		
		var loggedUserHomePage = new LoggedInUser_HomePage();
		assertEquals(loggedUserHomePage.getUserNameOREmail(), validUser_UserName,"user logged in but displayed name is incorrect");
		
	}
	
	@Test
	@Description("Attempt to login without username")
	public void invalidLogin_EmptyUserName() {
		var homePageObject = new Visitor_HomePage();
		homePageObject.navigateToLoginPage();
		
		//submit empty username
		var loginPageObject = new LoginPage();
		loginPageObject.enterUserName("");
	
		assertEquals(loginPageObject.getUserNameErrorMessage()
				, "This is a required field, Please enter your Email or username"
				,"Username error message is not compliant with requirements");
	
	}
	
	
	@Test
	@Description("Attempt to login without password")
	public void invalidLogin_EmptyPassword() {
		var homePageObject = new Visitor_HomePage();
		homePageObject.navigateToLoginPage();
		
		var loginPageObject = new LoginPage();
		loginPageObject.enterUserName("a");
		
		//submit empty password
		loginPageObject.enterPassword("");
	
		assertEquals(loginPageObject.getPasswordErrorMessage()
				, "This is a required field, Please enter your password"
				,"Password error message is not compliant with requirements");
	
	}
	
}
