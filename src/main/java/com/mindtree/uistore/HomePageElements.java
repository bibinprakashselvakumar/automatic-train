package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HomePageElements {
	By searchBarElement = By.xpath("//input[@title='Search for products, brands and more']");
	By phoneElement = By.xpath("//div[@data-id='MOBFUSBNAZGY7HQU']");
	By priceElement = By.className("_30jeq3");
	By getappliance = By.className("xtXmba");
	By account = By.className("_1_3w1N");
	public By getSearchBarElement() {
		return searchBarElement;
	}
	public By getPhoneElement() {
		return phoneElement;
	}
	public By getPrice() {
		return priceElement;
	}
	public By getapplianceElement() {
		return getappliance;
	}
	public By getAccountInfo() {
		return account;
	}
}
