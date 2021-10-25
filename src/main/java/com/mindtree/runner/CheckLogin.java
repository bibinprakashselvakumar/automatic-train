package com.mindtree.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.LoginPage;
import com.mindtree.reusableComponents.Base;

public class CheckLogin extends Base {
	@BeforeMethod
	public void openWebpage() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		log.info("Landed on " + props.getProperty("url"));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	@Test
	public void checkIfLoggedIn() {
		HomePage hp = new HomePage(driver);
		if (hp.AccountBox().getText().toString().equalsIgnoreCase("Login")) {
			log.info("User not logged in");
		}
	}

	@Test(dependsOnMethods = { "checkIfLoggedIn" })
	public void login() {
		HomePage hp = new HomePage(driver);
		hp.AccountBox().click();
		LoginPage lp = new LoginPage(driver);
		lp.usernameInput().sendKeys("bibinprakashselvakumar@gmail.com");
		lp.passwordInput().sendKeys("uJL95shG5np#", Keys.ENTER);
	}

	@AfterMethod
	public void closeInstance() {
		driver.quit();
	}
}
