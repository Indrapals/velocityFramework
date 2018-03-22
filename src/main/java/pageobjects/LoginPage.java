package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import genericlibrary.ConfigProperties;

public class LoginPage {

	final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	public WebElement usernameField;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	public WebElement passwordField;

	@FindBy(css = ".btn.btn-primary.btn-block")
	@CacheLookup
	public WebElement loginButton;

	public void loginUser() throws IOException {

		usernameField.sendKeys(ConfigProperties.getObject("userName"));
		passwordField.sendKeys(ConfigProperties.getObject("passWord"));
		loginButton.click();

	}

}
