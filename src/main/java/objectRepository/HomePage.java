package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	final WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]")
	@CacheLookup
	public WebElement VEHICLECHECK_MENU;
		
	@FindBy(xpath ="//img[@alt='Vehicle Check']")
	@CacheLookup
	public WebElement VEHICLECHECK_TILE;
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li")
	@CacheLookup
	public WebElement VEHICLECHECK_DROPDOWN;
	
	
	
}
