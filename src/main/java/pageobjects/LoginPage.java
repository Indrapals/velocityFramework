package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import genericlibrary.BrowserUtilities;
import genericlibrary.ConfigProperties;

public class LoginPage {

	final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//a[contains(text(),'I agree')]")
	@CacheLookup
	public WebElement iagreeCheck;

	@FindBy(id = "id_username")
	@CacheLookup
	public WebElement usernameField;

	@FindBy(id = "id_password")
	@CacheLookup
	public WebElement passwordField;

	@FindBy(css = ".image-button.btn-primary-colour.login-image-button")
	@CacheLookup
	public WebElement loginButton;

	@FindBy(css = ".image-button.btn-primary-colour.login-image-button")
	@CacheLookup
	public WebElement resetPasswordButton;

	@FindBy(css = ".logo>img")
	@CacheLookup
	public WebElement logoImage;

	@FindBy(css = ".tiny.round>img")
	@CacheLookup
	public WebElement langFlag;

	@FindBy(xpath = "//span[text()='English']")
	@CacheLookup
	public WebElement langEng;

	@FindBy(xpath = "//span[text()='American-English']")
	@CacheLookup
	public WebElement langAmericanEng;

	public void loginUser() throws IOException {
		iagreeCheck.click();
		usernameField.sendKeys(ConfigProperties.getObject("userName"));
		passwordField.sendKeys(ConfigProperties.getObject("passWord"));
		loginButton.click();

	}

	public void testweb() throws IOException {
		BrowserUtilities.getBrowser();
		usernameField.sendKeys(ConfigProperties.getObject("userName"));
		passwordField.sendKeys(ConfigProperties.getObject("passWord"));
		loginButton.click();

	}

}
