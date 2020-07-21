package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

// All the reuseables , Drivers and properties are declared here 

// This acts as the parent class from here the child class that is the pages and methods will inherit the methods and properties

public class TestBase {

	// Defining webdriver and properties variables globally

	public static WebDriver driver;

	public static Properties prop;

	// Creating a constructor - Constructor name should be same as class name

	public TestBase() {

		// Here in test base we need to write the code to read the properties from
		// config file by creating an object
		// for fileinputstream class and loading it using the properties object

		// Initializing the properties which has been defined gloablly

		try {

			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Karthikeyan\\eclipse-workspace\\15_Mar\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");

			prop.load(ip);

			// Handling the filenot found exception
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			// Handling the input output exception
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	// Browser initialization method

	public static void initialization() {

		// Here we need to call the read property from property file using the object
		// created for properties

		// Syntax is : prop.getProperty("");

		// Storing the browser in a variable - browsername whichs data type will be
		// string

		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Seljars\\WebBrowserDrivers\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			System.setProperty("webdriver.geckodriver.driver", "C:\\Seljars\\WebBrowserDrivers\\geckodriver.exe\\");

			driver = new FirefoxDriver();

		} else if (browserName.equals("Edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\Seljars\\WebBrowserDrivers\\msedgedriver.exe");

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		// Setting time for page loading , using the test util class for calling the
		// values instead of hardcoding

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
