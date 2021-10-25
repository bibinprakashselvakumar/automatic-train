package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginPageElements {
	By usernameInput = By.className("_2IX_2-");
	By passInput = By.className("_3mctLh");

	public By getUserInput() {
		return usernameInput;
	}

	public By getPassInput() {
		return passInput;
	}
}
