package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.LoginPageElements;

public class LoginPage {
	public WebDriver driver;
	LoginPageElements lpe = new LoginPageElements();
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement usernameInput() {
		return driver.findElement(lpe.getUserInput());
	}
	public WebElement passwordInput() {
		return driver.findElement(lpe.getPassInput());
	}
}
