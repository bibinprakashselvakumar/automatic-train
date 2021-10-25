package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.HomePageElements;

public class HomePage{
	public WebDriver driver;
	HomePageElements hpl = new HomePageElements();
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement searchBar() {
		return driver.findElement(hpl.getSearchBarElement());
	}
	public WebElement selectPhone() {
		return driver.findElement(hpl.getPhoneElement());
	}
	public WebElement getPriceElement() {
		return driver.findElement(hpl.getPrice());
	}
	public WebElement appliances() {
		return driver.findElement(hpl.getapplianceElement());
	}

	public WebElement AccountBox() {
		return driver.findElement(hpl.getAccountInfo());
	}
}
