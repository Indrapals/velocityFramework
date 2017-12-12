package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.*;


public class LoginPage {

	final WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(BrowserUtilities.driver, this);
	}
	
		
	@FindBy(id ="id_username")
	public WebElement USERNAME;
	
	@FindBy(id ="id_password")
	public WebElement PASSWORD; 
	
	@FindBy(css =".image-button.btn-primary-colour.login-image-button")
	public WebElement LOGIN_BTN; 

	@FindBy(css =".image-button.btn-primary-colour.login-image-button")
	public WebElement RESETPASSWORD_BTN; 

	@FindBy(css =".logo>img")
	public WebElement LOGO_IMAGE;

	@FindBy(css =".tiny.round>img")
	public WebElement LANG_FLAG;

	@FindBy(xpath ="//span[text()='English']")
	public WebElement LANG_ENG;

	@FindBy(xpath ="//span[text()='American-English']")
	public WebElement LANG_AMERICAN_ENG;

	
	/*@FindBy(how=How.ID,using ="txtPassword")
	public WebElement PASSWORD; 
	
	@FindBy(how=How.ID,using ="btnLogin")
	public WebElement LOGIN_BTN; 
*/	
	public void login_User() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	
		USERNAME.sendKeys(ConfigProperties.getObject("userName"));
		PASSWORD.sendKeys(ConfigProperties.getObject("passWord"));
		LOGIN_BTN.click();
	 
	}
	public void login_Invalid_Credential() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	
		USERNAME.sendKeys(ConfigProperties.getObject("usrName"));
		PASSWORD.sendKeys(ConfigProperties.getObject("pasWord"));
		LOGIN_BTN.click();
	 
	}
		
	
	
	
	
	
}
