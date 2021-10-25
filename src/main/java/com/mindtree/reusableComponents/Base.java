package com.mindtree.reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static WebDriver driver;
	public Properties props;
	public static Logger log = LogManager.getLogger(Base.class);
	public static ExtentReports extent;
	public static ExtentTest logger;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		props = new Properties();
		props.load(file);
		String browserName = props.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
