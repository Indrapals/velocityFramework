package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.*;


public class LoginPage {

	final WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;

	}
	
	
	@FindBy(xpath ="//a[contains(text(),'I agree')]")
	@CacheLookup
	public WebElement I_AGREE;
	
	@FindBy(id ="id_username")
	@CacheLookup
	public WebElement USERNAME;
	
	@FindBy(id ="id_password")
	@CacheLookup
	public WebElement PASSWORD; 
	
	@FindBy(css =".image-button.btn-primary-colour.login-image-button")
	@CacheLookup
	public WebElement LOGIN_BTN; 

	@FindBy(css =".image-button.btn-primary-colour.login-image-button")
	@CacheLookup
	public WebElement RESETPASSWORD_BTN; 

	@FindBy(css =".logo>img")
	@CacheLookup
	public WebElement LOGO_IMAGE;

	@FindBy(css =".tiny.round>img")
	@CacheLookup
	public WebElement LANG_FLAG;

	@FindBy(xpath ="//span[text()='English']")
	@CacheLookup
	public WebElement LANG_ENG;

	@FindBy(xpath ="//span[text()='American-English']")
	@CacheLookup
	public WebElement LANG_AMERICAN_ENG;

	
		
	public void login_User() throws Exception
	{
		I_AGREE.click();
		USERNAME.sendKeys(ConfigProperties.getObject("userName"));
		PASSWORD.sendKeys(ConfigProperties.getObject("passWord"));
		LOGIN_BTN.click();
	 
	}
	
	public void testweb() throws IOException{
		BrowserUtilities.getBrowser();
		USERNAME.sendKeys(ConfigProperties.getObject("userName"));
		PASSWORD.sendKeys(ConfigProperties.getObject("passWord"));
		LOGIN_BTN.click();
		
		
        }
	
		
	
	
	
	

}
