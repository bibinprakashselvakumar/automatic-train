package com.mindtree.runner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.reusableComponents.Base;
import com.relevantcodes.extentreports.ExtentReports;

public class Tester extends Base {
	@BeforeMethod
	public void openWebpage() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		log.info("Landed on " + props.getProperty("url"));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReports/ExtentReport.html", true);

	}

	@AfterMethod
	public void closeInstance() {
		driver.quit();
	}

	@Test
	public void checkGooglePixel() {
		logger = extent.startTest("checkGooglePixel");
		HomePage hp = new HomePage(driver);
		hp.searchBar().click();
		log.info("Clicked on the search Bar");
		hp.searchBar().sendKeys("Google Pixel 4a", Keys.ENTER);
		log.info("Sent search Keys");
		hp.selectPhone().click();
		log.info("Clicked on the phone");
		Assert.assertTrue(hp.getPriceElement().getText().toString().contains("31,999"));
		log.info("Price is " + hp.getPriceElement().getText().toString());

	}

	@Test
	public void printThreeLinksUnderAppliances() {
		logger = extent.startTest("printThreeLinksUnderAppliances");
		HomePage hp = new HomePage(driver);
		hp.appliances().click();
		int i = 0;
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			if (link.getAttribute("href") != null) {
				System.out.println("Link " + i++ + ":" + " - " + link.getAttribute("href"));
				if (i == 3) {
					break;
				}
			}
		}
		extent.endTest(logger);
		extent.flush();
	}
}
