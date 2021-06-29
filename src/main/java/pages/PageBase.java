package pages;

import org.openqa.selenium.WebDriver;

public class PageBase {

	public static WebDriver driver ;

	

	public void setDriver(WebDriver driver) {
		PageBase.driver = driver;
	}

}
