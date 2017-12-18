package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import genericLibrary.*;


public class LoginPage {

	final WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	
		
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
		USERNAME.sendKeys(ConfigProperties.getObject("userName"));
		PASSWORD.sendKeys(ConfigProperties.getObject("passWord"));
		LOGIN_BTN.click();
	 
	}
	
		
	
	
	
	
	
}
