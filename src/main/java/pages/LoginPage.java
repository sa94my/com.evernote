package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver = PageBase.driver;
	private By userNameTextField = By.id("username");
	private By passwordTextField = By.id("password");
	private By signInButton = By.id("loginButton");
	private By userName_errorMsg = By.id("responseMessage");
	private By password_errorMsg = By.cssSelector("#password-wrapper div");
	private WebDriverWait wait ;
	
	
	
	
	public void loginWithCredintials(String userName,String password) {
		
		enterUserName(userName);
		enterPassword(password);
		
	}
	
	
	public String getUserNameErrorMessage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName_errorMsg));
		return driver.findElement(userName_errorMsg).getText();
	}
	
	public String getPasswordErrorMessage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(password_errorMsg));
		return driver.findElement(password_errorMsg).getText();
	}
	
	
	public void enterUserName(String userName) {
		// wait for username text field to be present & then enter username 
				wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTextField));
				driver.findElement(userNameTextField).sendKeys(userName);
				//press enter to show password field
				driver.findElement(userNameTextField).sendKeys(Keys.ENTER);
	}
	
	public void enterPassword(String password) {
		//wait for password text field to be present & then enter password 
				wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextField));
				driver.findElement(passwordTextField).sendKeys(password);
				driver.findElement(signInButton).click();

	}
	
	
	
}
