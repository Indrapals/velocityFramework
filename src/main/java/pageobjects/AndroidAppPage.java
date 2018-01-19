package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionslibrary.AndroidAction;
import genericlibrary.ApplicationSetup;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAppPage {

	final WebDriver driver;

	public AndroidAppPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(ApplicationSetup.driver), this);
	}

	@FindBy(id = "email_clear")
	@CacheLookup
	public WebElement emailClear;

	@FindBy(id = "login_username")
	@CacheLookup
	public WebElement loginUsername;

	@FindBy(id = "code_clear")
	@CacheLookup
	public WebElement codeClear;

	@FindBy(id = "login_password")
	@CacheLookup
	public WebElement loginPassword;

	@FindBy(id = "login_button")
	@CacheLookup
	public WebElement loginButton;

	@FindBy(id = "navbackbutton")
	@CacheLookup
	public WebElement navbackButton;

	@FindBy(id = "message")
	@CacheLookup
	public WebElement messagePopup;

	@FindBy(id = "button1")
	@CacheLookup
	public WebElement okButton;

	// Home Screen

	@FindBy(id = "nav_button")
	@CacheLookup
	public WebElement exitIcon;

	@FindBy(id = "navtitle")
	@CacheLookup
	public WebElement titleVehicleCheck;

	@FindBy(id = "home_button")
	@CacheLookup
	public WebElement bellIcon;

	@FindBy(id = "selector_companyname")
	@CacheLookup
	public WebElement companyName;

	@FindBy(id = "selector_selectvehicle")
	@CacheLookup
	public WebElement vehicleSelectDropDown;

	@FindBy(id = "refresh_vehicles")
	@CacheLookup
	public WebElement refreshIcon;

	@FindBy(id = "layout_remember_driver")
	@CacheLookup
	public WebElement rememberChoiceCheckboxChecked;

	@FindBy(id = "layout_remember_driver")
	@CacheLookup
	public WebElement useWifiCheckboxUnchecked;

	@FindBy(id = "select_button")
	@CacheLookup
	public WebElement vehicleCheckSubmitButton;

	@FindBy(id = "unlink_button")
	@CacheLookup
	public WebElement previousVehicleCheckButton;

	@FindBy(id = "filter_cancel")
	@CacheLookup
	public WebElement selectVehicleCancelButton;

	@FindBy(id = "filter_select")
	@CacheLookup
	public WebElement selectVehicleOkButton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Hire')]")
	@CacheLookup
	public WebElement selectHirevan1;

	// van select page

	@FindBy(id = "navtitle")
	@CacheLookup
	public WebElement pleaseSelectTitle;

	@FindBy(id = "navrightbutton")
	@CacheLookup
	public WebElement homeIcon;

	@FindBy(id = "type_chooser_vc")
	@CacheLookup
	public WebElement vehicleCheckIcon;

	@FindBy(id = "type_chooser_ir")
	@CacheLookup
	public WebElement reportIncidentIcon;

	@FindBy(id = "intext_topviewbutton")
	@CacheLookup
	public WebElement interiorQuestionIcon;

	@FindBy(id = "intext_bottomviewbutton")
	@CacheLookup
	public WebElement exteriorQuestionIcon;

	@FindBy(id = "question_text")
	@CacheLookup
	public WebElement interiorQuestionText;

	// Login Inactive user without entering code
	public void loginInactiveUserWithoutCode() {
		emailClear.click();
		loginUsername.sendKeys("jen.littletom@kinesisdemo.com");
		codeClear.click();
		AndroidAction.implicitwait(10, TimeUnit.SECONDS);
		loginButton.click();

	}

	// Login Inactive user after entering code
	public void loginInactiveUserWithCode() {
		AndroidAction.implicitwait(10, TimeUnit.SECONDS);
		okButton.click();
		emailClear.click();
		loginUsername.sendKeys("jen.littletom@kinesisdemo.com");

		loginPassword.sendKeys("783234307");
		AndroidAction.implicitwait(20, TimeUnit.SECONDS);
		loginButton.click();

	}

	// Login Active user with incorrect code
	public void loginActiveUserWithIncorrectCode() {
		AndroidAction.implicitwait(10, TimeUnit.SECONDS);
		okButton.click();
		emailClear.click();
		loginUsername.sendKeys("adam.thopliss@kinesisdemo.com");
		codeClear.click();
		loginPassword.sendKeys("222137053");
		loginButton.click();

	}

	// Login Active user with correct code
	public void loginActiveUserWithCorrectCode() {
		okButton.click();
		AndroidAction.implicitwait(10, TimeUnit.SECONDS);
		emailClear.click();
		loginUsername.sendKeys("adam.thopliss@kinesisdemo.com");
		codeClear.click();
		loginPassword.sendKeys("115137053");
		loginButton.click();

	}
}
