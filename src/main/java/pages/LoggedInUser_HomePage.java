package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInUser_HomePage {

	private WebDriver driver = PageBase.driver;
	private By UserNameOrEmail = By.cssSelector("div._2nB_7KEJsuhQKdDMrrWUp8");
	private WebDriverWait wait ;
	
	public String getUserNameOREmail() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameOrEmail));
		return driver.findElement(UserNameOrEmail).getText();
	}
}
