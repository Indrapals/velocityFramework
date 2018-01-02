package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsLibrary.AndroidAction;
import genericLibrary.ApplicationSetup;
import genericLibrary.ConfigProperties;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAppPage {

	/*public static final By EMAIL_CLEAR = By.id("email_clear");

	public static final By LOGIN_USERNAME = By.id("login_username");
	public static final By CODE_CLEAR = By.id("code_clear");
	public static final By LOGIN_PASSWORD = By.id("login_password");
	public static final By login_button = By.id("login_button");
	*/
	
	
	final WebDriver driver;
	public AndroidAppPage(WebDriver driver){
		this.driver=driver;		
		 PageFactory.initElements(new AppiumFieldDecorator(ApplicationSetup.driver), this);
	}
	

	@FindBy(id ="email_clear")
	@CacheLookup
	public WebElement EMAIL_CLEAR;
	
	@FindBy(id ="login_username")
	@CacheLookup
	public WebElement LOGIN_USERNAME;
		
	@FindBy(id ="code_clear")
	@CacheLookup
	public WebElement CODE_CLEAR;
	
	@FindBy(id ="login_password")
	@CacheLookup
	public WebElement LOGIN_PASSWORD;
	
	@FindBy(id ="login_button")
	@CacheLookup
	public WebElement LOGIN_BUTTON;
	
	@FindBy(id ="navbackbutton")
	@CacheLookup
	public WebElement NAVBACK_BUTTON;
	
	@FindBy(id ="message")
	@CacheLookup
	public WebElement MESSAGE_POPUP;
	
	@FindBy(id ="button1")
	@CacheLookup
	public WebElement OK_BUTTON;
	
	//Home Screen
	
	@FindBy(id ="nav_button")
	@CacheLookup
	public WebElement EXIT_ICON;
	
	@FindBy(id ="navtitle")
	@CacheLookup
	public WebElement TITLE_VEHICLE_CHECK;
	
	@FindBy(id ="home_button")
	@CacheLookup
	public WebElement BELL_ICON;
	
	@FindBy(id ="selector_companyname")
	@CacheLookup
	public WebElement COMPANY_NAME;
	
	@FindBy(id ="selector_selectvehicle")
	@CacheLookup
	public WebElement VEHICLE_SELECT_DROPDOWN;
	
	@FindBy(id ="refresh_vehicles")
	@CacheLookup
	public WebElement REFRESH_ICON;
	
	@FindBy(id ="layout_remember_driver")
	@CacheLookup
	public WebElement REMEMBERCHOICE_CHECKBOX_CHECKED;
	
	@FindBy(id ="layout_remember_driver")
	@CacheLookup
	public WebElement USEWIFI_CHECKBOX_UNCHECKED;
	
	@FindBy(id ="select_button")
	@CacheLookup
	public WebElement VEHICLECHECK_SUBMITBUTTON;
	
	@FindBy(id ="unlink_button")
	@CacheLookup
	public WebElement PREVIOUS_VEHICLECHECK_BUTTON;
	
	@FindBy(id ="filter_cancel")
	@CacheLookup
	public WebElement SELECTVEHICLE_CANCEL_BUTTON;
	
	@FindBy(id ="filter_select")
	@CacheLookup
	public WebElement SELECTVEHICLE_OK_BUTTON;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Hire Van 1')]")
	@CacheLookup
	public WebElement SELECT_HIREVAN1;
	
	//van select page
	
	@FindBy(id ="navtitle")
	@CacheLookup
	public WebElement PLSESE_SELECT_TITLE;
	
	@FindBy(id ="navrightbutton")
	@CacheLookup
	public WebElement HOME_ICON;
	
	@FindBy(id ="type_chooser_vc")
	@CacheLookup
	public WebElement VEHICLE_CHECK_ICON;
	
	@FindBy(id ="type_chooser_ir")
	@CacheLookup
	public WebElement REPORT_INCIDENT_ICON;
	
	@FindBy(id ="intext_topviewbutton")
	@CacheLookup
	public WebElement INTERIOR_QUESTIONS_ICON;
	
	@FindBy(id ="intext_bottomviewbutton")
	@CacheLookup
	public WebElement EXTERIOR_QUESTION_ICON;
	
	@FindBy(id ="question_text")
	@CacheLookup
	public WebElement INTERIOR_QUESTION_TEXT;
	
	//Login Inactive user without entering code
	public void login_InactiveUser_Without_Code() throws Exception
	{
		EMAIL_CLEAR.click();	
		LOGIN_USERNAME.sendKeys("jen.littletom@kinesisdemo.com");
		CODE_CLEAR.click();
		LOGIN_BUTTON.click();
	 
	}
	
	//Login Inactive user after entering code
		public void login_InactiveUser_With_Code() throws Exception
		{
			AndroidAction.implicit_wait(10, TimeUnit.SECONDS);
			OK_BUTTON.click();
			EMAIL_CLEAR.click();	
			LOGIN_USERNAME.sendKeys("jen.littletom@kinesisdemo.com");
		
			LOGIN_PASSWORD.sendKeys("783234307");
			LOGIN_BUTTON.click();
		 
		}
		
		//Login Active user with incorrect code
		public void login_ActiveUser_With_IncorrectCode() throws Exception
		{
			AndroidAction.implicit_wait(10, TimeUnit.SECONDS);
			OK_BUTTON.click();
			EMAIL_CLEAR.click();	
			LOGIN_USERNAME.sendKeys("adam.thopliss@kinesisdemo.com");
			CODE_CLEAR.click();
			LOGIN_PASSWORD.sendKeys("222137053");
			LOGIN_BUTTON.click();
		 
		}
	
		//Login Active user with correct code
		public void login_ActiveUser_With_CorrectCode() throws Exception
			{
			AndroidAction.implicit_wait(10, TimeUnit.SECONDS);
			OK_BUTTON.click();	
			AndroidAction.implicit_wait(10, TimeUnit.SECONDS);
			EMAIL_CLEAR.click();	
			LOGIN_USERNAME.sendKeys("adam.thopliss@kinesisdemo.com");
			CODE_CLEAR.click();
			LOGIN_PASSWORD.sendKeys("115137053");
			LOGIN_BUTTON.click();
				 
				}	
}
