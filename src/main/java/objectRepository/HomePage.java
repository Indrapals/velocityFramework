package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericLibrary.*;

public class HomePage {

	final WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(BrowserUtilities.driver, this);
	}
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]")
	public WebElement VEHICLECHECK_MENU;
		
	@FindBy(xpath ="//img[@alt='Vehicle Check']")
	public WebElement VEHICLECHECK_TILE;
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li")
	public WebElement VEHICLECHECK_DROPDOWN;
	
	
	
}
