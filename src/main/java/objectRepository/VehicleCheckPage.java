package objectRepository;

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
	
	@FindBy(xpath ="//div[text()='Vehicles']")
	public WebElement VEHICLES_TILE;
	
	@FindBy(xpath ="//div[text()='Drivers']")
	public WebElement DRIVERS_TILE;
	
	@FindBy(xpath ="//h2[text()='Manage Vehicles']")
	public WebElement MANAGEVEHICLES_MENU;
	
	
	
	
	
	
	
	
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
