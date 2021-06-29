package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.PageBase;
import properties.BrowserProperties;
import utils.Screenshot;

public class TestBase {

	private WebDriver driver ;
	private PageBase pageBaseObject = new PageBase();

	@BeforeMethod
	public void setUp() {
		//get browser type and options from properties file
		driver = BrowserProperties.getBrowserProperties();
		driver.manage().window().maximize();
		driver.get("https://evernote.com/");
		pageBaseObject.setDriver(driver);

	}

	@AfterMethod
	public void returnHome(ITestResult result) {
		
			if(result.getStatus() ==ITestResult.FAILURE) {
				Screenshot.takeScreenshot(result.getName());
			}
		
		driver.quit();
	}

}
