package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import pages.PageBase;



public class Screenshot {

	
	
	public static void takeScreenshot(String name) {
		WebDriver driver = PageBase.driver;
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.move(screenshot, new File("src\\test\\resources\\screenshots\\"+name+".png"));
			} catch (IOException e) {
				System.out.println("Failed to create screenshot");
				e.printStackTrace();
			
		}
	}
}