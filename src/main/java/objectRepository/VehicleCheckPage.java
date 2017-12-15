package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actionsLibrary.GenericActionUtil;
import genericLibrary.*;


public class VehicleCheckPage {
	
	final WebDriver driver;
	public VehicleCheckPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(BrowserUtilities.driver, this);
	}
	
	@FindBy(id ="vehicle-check-manage-fleet")
	public WebElement MANAGEFLEET_TILE;
	
	@FindBy(id ="vehicle-check-manage-groups")
	public WebElement MANAGEGROUPS_TILE;
	
	@FindBy(id ="vehicle-check-reports")
	public WebElement REPORTS_TILE;
	
	@FindBy(id ="vehicle-check-manage-questions")
	public WebElement MANAGEQUESTION_TILE;
	
	@FindBy(id ="vehicle-check-defect-management")
	public WebElement DEFECTMANAGEMENT_TILE;

	@FindBy(id ="vehicle-due-dates-dashboard")
	public WebElement DUEDATES_TILE;

	@FindBy(id ="vehicle-check-dashboard")
	public WebElement VEHICLECHECKDASH_TILE;
	
	@FindBy(id ="vehicle-check-alerts")
	public WebElement ALERTS_TILE;
	
	@FindBy(xpath ="//h2[text()='Manage Fleet']")
	public WebElement MANAGEFLEET_MENU;
	
	@FindBy(xpath ="//a[@href='/vehicle-check/manage-vehicles/']")
	public WebElement VEHICLES_TILE;
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li")
	public List<WebElement> VEHICLECHECK_DROPDOWNLIST;
	
	
	@FindBy(xpath ="//div[text()='Vehicles']")
	public WebElement VEHICLES_TILE_TEXT;
	
	@FindBy(xpath ="//div[text()='Drivers']")
	public WebElement DRIVERS_TILE;
	
	@FindBy(xpath ="//h2[text()='Manage Vehicles']")
	public WebElement MANAGEVEHICLES_MENU;
	
	@FindBy(xpath ="//table[@id='data-table']/thead/tr[1]/th")
	public List<WebElement> MANAGEVEHICLES_HEADERLIST;
	
	@FindBy(xpath ="//td[@class='vehicle-active']/img[@title='Active']")
	public List<WebElement> ACTIVECHECK_LIST;
	
	@FindBy(xpath ="//button[contains(text(),'Show Removed Vehicles')]")
	public WebElement SHOWREMOVED_VEHICLES_BUTTON;
	
	@FindBy(xpath ="//button[contains(text(),'Hide Removed Vehicles')]")
	public WebElement HIDEREMOVED_VEHICLES_BUTTON;
	
	
	
	@FindBy(xpath ="//td[@class='vehicle-active']/img[@title='Inactive']")
	public List<WebElement> INACTIVECHECK_LIST;
	
	@FindBy(id ="add-objects")
	public WebElement ADDOBJECTES_BUTTON;
	
	@FindBy(id ="edit-objects")
	public WebElement EDITOBJECTS_BUTTON;
	
	@FindBy(xpath ="//div[@id='formset-modal']/div/div/form/table/thead/tr/th[contains(text(),'Vehicle Type')]")
	public WebElement VEHICLETYPE_HEADER;
	
	@FindBy(xpath ="//div[@id='formset-modal']/div/div[1]/form/table/thead/tr/th")
	public List<WebElement> VEHICLETYPE_HEADER_LIST;
	
	
	
	
	
	
	public String getManagementFleetTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(MANAGEFLEET_TILE);
	}
	
	public String getManageGroupsTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(MANAGEGROUPS_TILE);
	}
	public String getReportsTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(REPORTS_TILE);
	}
	public String getManageQuestionTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(MANAGEQUESTION_TILE);
	}
	public String getDefectManagementTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(DEFECTMANAGEMENT_TILE);
	}
	public String getDueDatesTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(DUEDATES_TILE);
	}
	public String getVechicleCheckDashboardTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(VEHICLECHECKDASH_TILE);
	}
	
	public String getAlertTileColor() throws Exception
	{
		PageFactory.initElements(BrowserUtilities.driver,LoginPage.class);
	    return GenericActionUtil.getcolor(ALERTS_TILE);
	}
	
	
}
