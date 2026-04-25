package utilities;

import java.io.FileInputStream;
import java.util.Properties;

	public class ConfigReader {

	    private Properties prop;

	    // Constructor (runs when object is created)
	    public ConfigReader() {
	        try {
	            FileInputStream fis = new FileInputStream(
	                System.getProperty("user.dir") + "/src/test/resources/config.properties"
	            );
	            prop = new Properties();
	            prop.load(fis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to get value using key
	    public String getProperty(String key) {
	        return prop.getProperty(key);
	    }

		
	}

