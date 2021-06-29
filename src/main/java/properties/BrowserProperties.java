package properties;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserProperties {

	private static String browserPropertiesFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\properties\\browser.properties";
	private static String browserName ;
	private static boolean headless ;
	private static Properties browserOptions ;


	public static WebDriver getBrowserProperties() {
		WebDriver driver;
		ChromeOptions options ;
		browserOptions = PropertiesLoader.loadProperties(browserPropertiesFilePath);
		browserName = browserOptions.getProperty("browserName", "chrome");
		headless = Boolean.parseBoolean(browserOptions.getProperty("headless", "false"));

		switch (browserName) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			if(headless ) {
				options.addArguments("--headless");
			}
			driver =new ChromeDriver(options);
			break;
			
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			if(headless ) {
				edgeOptions.addArguments("--headless");
			}
			driver =new EdgeDriver(edgeOptions);
			break;

			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setHeadless(headless);
			driver =new FirefoxDriver(ffOptions);
			break;

			
		default:
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			if(headless ) {
				options.addArguments("--headless");
			}
			driver =new ChromeDriver(options);
			break;
		}
		return driver ;
	}



}
