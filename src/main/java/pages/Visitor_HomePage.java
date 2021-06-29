package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Visitor_HomePage {

	private WebDriver driver = PageBase.driver;
	private By loginPageLink = By.className("login-cta");
	private WebDriverWait wait ;
	
	public void navigateToLoginPage() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageLink));
		driver.findElement(loginPageLink).click();
	}
	

	
}
