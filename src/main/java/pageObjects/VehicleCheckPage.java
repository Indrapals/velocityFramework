package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsLibrary.CommonActionUtil;
import genericLibrary.BrowserUtilities;



public class VehicleCheckPage {
	
	final WebDriver driver;

	public VehicleCheckPage(WebDriver driver){
		this.driver=driver;
	
	}
	
	@FindBy(id ="vehicle-check-manage-fleet")
	@CacheLookup
	public WebElement MANAGEFLEET_TILE;
	
	@FindBy(id ="vehicle-check-manage-groups")
	@CacheLookup
	public WebElement MANAGEGROUPS_TILE;
	
	@FindBy(id ="vehicle-check-reports")
	@CacheLookup
	public WebElement REPORTS_TILE;
	
	@FindBy(id ="vehicle-check-manage-questions")
	@CacheLookup
	public WebElement MANAGEQUESTION_TILE;
	
	@FindBy(id ="vehicle-check-defect-management")
	@CacheLookup
	public WebElement DEFECTMANAGEMENT_TILE;

	@FindBy(id ="vehicle-due-dates-dashboard")
	@CacheLookup
	public WebElement DUEDATES_TILE;

	@FindBy(id ="vehicle-check-dashboard")
	@CacheLookup
	public WebElement VEHICLECHECKDASH_TILE;
	
	@FindBy(id ="vehicle-check-alerts")
	@CacheLookup
	public WebElement ALERTS_TILE;
	
	@FindBy(xpath ="//h2[text()='Manage Fleet']")
	@CacheLookup
	public WebElement MANAGEFLEET_MENU;
	
	@FindBy(xpath ="//a[@href='/vehicle-check/manage-vehicles/']")
	@CacheLookup
	public WebElement VEHICLES_TILE;
	
	@FindBy(xpath ="//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li")
	@CacheLookup
	public List<WebElement> VEHICLECHECK_DROPDOWNLIST;
	
	
	@FindBy(xpath ="//div[text()='Vehicles']")
	@CacheLookup
	public WebElement VEHICLES_TILE_TEXT;
	
	@FindBy(xpath ="//div[text()='Drivers']")
	@CacheLookup
	public WebElement DRIVERS_TILE;
	
	@FindBy(xpath ="//h2[text()='Manage Vehicles']")
	@CacheLookup
	public WebElement MANAGEVEHICLES_MENU;
	
	@FindBy(xpath ="//table[@id='data-table']/thead/tr[1]/th")
	@CacheLookup
	public List<WebElement> MANAGEVEHICLES_HEADERLIST;
	
	@FindBy(xpath ="//td[@class='vehicle-active']/img[@title='Active']")
	@CacheLookup
	public List<WebElement> ACTIVECHECK_LIST;
	
	@FindBy(xpath ="//button[contains(text(),'Show Removed Vehicles')]")
	@CacheLookup
	public WebElement SHOWREMOVED_VEHICLES_BUTTON;
	
	@FindBy(xpath ="//button[contains(text(),'Hide Removed Vehicles')]")
	@CacheLookup
	public WebElement HIDEREMOVED_VEHICLES_BUTTON;
	
	@FindBy(xpath ="//td[@class='vehicle-active']/img[@title='Inactive']")
	@CacheLookup
	public List<WebElement> INACTIVECHECK_LIST;
	
	@FindBy(id ="add-objects")
	@CacheLookup
	public WebElement ADDOBJECTS_BUTTON;
	
	@FindBy(id ="edit-objects")
	@CacheLookup
	public WebElement EDITOBJECTS_BUTTON;
	
	@FindBy(xpath ="//div[@id='formset-modal']/div/div/form/table/thead/tr/th[contains(text(),'Vehicle Type')]")
	@CacheLookup
	public WebElement VEHICLETYPE_HEADER;
	
	@FindBy(xpath ="//div[@id='formset-modal']/div/div[1]/form/table/thead/tr/th")
	@CacheLookup
	public List<WebElement> VEHICLETYPE_HEADER_LIST;
	
	@FindBy(id ="id_form-0-vehicle_type")
	@CacheLookup
	public WebElement VEHICLETYPE_DROPDOWN;
	
	@FindBy(xpath ="//select[@id='id_form-0-vehicle_type']/option")
	@CacheLookup
	public List<WebElement> VEHICLETYPE_DROPDOWN_LIST;
	
	@FindBy(id ="id_form-0-registration")
	@CacheLookup
	public WebElement VEHICLEREGISTRATION_TEXTBOX;
	
	@FindBy(xpath ="//input[@id='id_form-0-can_attach_trailer']//following-sibling::img")
	@CacheLookup
	public WebElement ATTACHTRAILER_CHECKBOX;
	
	@FindBy(id ="id_form-0-groups")
	@CacheLookup
	public WebElement GROUP_DROPDOWN;
	
	@FindBy(xpath ="//input[@id='id_form-0-visible']//following-sibling::img")
	@CacheLookup
	public WebElement ACTIVE_CHECKBOX;
	
	@FindBy(xpath ="//input[@id='id_form-0-removed']//following-sibling::button")
	@CacheLookup
	public WebElement MANAGEVEHICLEPOPUP_REMOVEBUTTON;
	
	
	@FindBy(xpath ="//div[@id='formset-modal']/div/div/form/table/tbody/tr/td/div/label")
	@CacheLookup
	public List<WebElement> DUEDATES_CALENDER_LIST;
		
	@FindBy(name ="add_objects")
	@CacheLookup
	public WebElement MANAGEVEHICLEPOPUP_ADDBUTTON;
	
	@FindBy(name ="submit_formset")
	@CacheLookup
	public WebElement MANAGEVEHICLEPOPUP_SUBMITBUTTON;
	
	@FindBy(name ="cancel-button")
	@CacheLookup
	public WebElement MANAGEVEHICLEPOPUP_CANCELBUTTON;
	

	@FindBy(xpath ="//td[contains(@class,'vehicle-reg sorting')]")
	@CacheLookup
	public List<WebElement> ACTIVEVEHICLE_LIST;
	
	
	
	@FindBy(xpath ="//img[@alt='Vehicle Check']")
	@CacheLookup
	public WebElement VEHICLECHECK_TILE;
	
	public String getManagementFleetTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEFLEET_TILE);
	}
	
	public String getManageGroupsTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEGROUPS_TILE);
	}
	public String getReportsTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(REPORTS_TILE);
	}
	public String getManageQuestionTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEQUESTION_TILE);
	}
	public String getDefectManagementTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(DEFECTMANAGEMENT_TILE);
	}
	public String getDueDatesTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(DUEDATES_TILE);
	}
	public String getVechicleCheckDashboardTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(VEHICLECHECKDASH_TILE);
	}
	
	public String getAlertTileColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(ALERTS_TILE);
	}
	
	public String getManageVehiclepopupAddButtonColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEVEHICLEPOPUP_ADDBUTTON);
	}
	
	public String getManageVehiclepopupSubmitButtonColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEVEHICLEPOPUP_SUBMITBUTTON);
	}
	public String getManageVehiclepopupCancelButtonColor() throws Exception
	{
		
	    return CommonActionUtil.getcolor(MANAGEVEHICLEPOPUP_CANCELBUTTON);
	}
	
	public void clickonSubmitButton() throws Exception
	{
		MANAGEVEHICLEPOPUP_SUBMITBUTTON.click();
	}
	
	public void getaction(){
		
		VEHICLECHECK_TILE.click();
		MANAGEFLEET_TILE.click();
		VEHICLES_TILE.click();

		List<String> lstMovedItem=new ArrayList<String>();
        for(int i=0;i<ACTIVECHECK_LIST.size();i++){
           lstMovedItem.add(ACTIVECHECK_LIST.get(i).getText());
        }}
}
