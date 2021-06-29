package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	
	public static  Properties loadProperties(String PropertiesFilePath) {
		Properties propertiesFile = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(PropertiesFilePath);
			propertiesFile.load(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("error with the file path ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error reading from properties file ");
			e.printStackTrace();
		}
		return propertiesFile;
	
	}
}
