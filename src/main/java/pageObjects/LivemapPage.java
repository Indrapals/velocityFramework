package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsLibrary.CommonActionUtil;
import genericLibrary.BrowserUtilities;

public class LivemapPage {

	
	final WebDriver driver;

	public LivemapPage(WebDriver driver){
		this.driver=driver;
		
	}
		

	@FindBy(id ="nav_live_map")
	@CacheLookup
	public WebElement LIVEMAP_MODULE;

	@FindBy(id ="map_canvas")
	@CacheLookup
	public WebElement MAP_CANVAS;

	@FindBy(xpath ="//div[contains(@class,'info_window_wrapper device_wrapper')]")
	@CacheLookup
	public List<WebElement> INDEPENDENT_VEHICLE_LIST;
	
	@FindBy(xpath ="//div[contains(@class,'info_window_outer_wrapper')]")
	@CacheLookup
	public List<WebElement> INDEPENDENT_VEHICLE_LIST_WITH_DRIVERNAME;
	
	@FindBy(xpath ="//div[contains(@style,'m1.png')]")
	@CacheLookup
	public List<WebElement> VEHICLECLUSTER_LIST;
	
	@FindBy(css =".fa.fa-stop.ignition_state_icon")
	@CacheLookup
	public List<WebElement> PARKEDVEHICLE_LIST;
	
	@FindBy(css =".fa.fa-play.ignition_state_icon")
	@CacheLookup
	public List<WebElement> MOVINGVEHICLE_LIST;
	
	@FindBy(css =".options_button.tab_button")
	@CacheLookup
	public WebElement OPTIONS_BUTTON;

	@FindBy(css =".reset_button.tab_button")
	@CacheLookup
	public WebElement RESTMAP_BUTTON;
	
	@FindBy(css =".service_list_tab_button.tab_button")
	@CacheLookup
	public WebElement SUMMARY_BUTTON;
	
	@FindBy(css =".fullscreen_tab_button.tab_button")
	@CacheLookup
	public WebElement FULLSCREEN_BUTTON;
	
	@FindBy(css =".options_button.tab_button")
	@CacheLookup
	public WebElement OPTIONS_CLOSE_BUTTON;
	
	@FindBy(css =".service_list_tab_button.tab_button")
	@CacheLookup
	public WebElement SERVICESUMMARY_CLOSE_BUTTON;
	
	@FindBy(xpath ="//div[contains(text(),'Vehicle Display')]")
	@CacheLookup
	public WebElement VEHICLEDISPLAY_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Vehicle Registration')]")
	@CacheLookup
	public WebElement VEHICLEREGISTRATION_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Driver Name')]")
	@CacheLookup
	public WebElement DRIVERNAME_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Map Style')]")
	@CacheLookup
	public WebElement MAPSTYLE_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Standard')]")
	@CacheLookup
	public WebElement STANDARD_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Satellite')]")
	@CacheLookup
	public WebElement SATELLITE_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Traffic')]")
	@CacheLookup
	public WebElement TRAFFIC_TEXTBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Points of Interest')]")
	@CacheLookup
	public WebElement POINTSOFINTEREST_TEXTBOX;

	@FindBy(xpath ="//div[contains(text(),'Vehicle Registration')]//following-sibling::div")
	@CacheLookup
	public WebElement VEHICLEREGISTRATION_CHECKBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Driver Name')]//following-sibling::div")
	@CacheLookup
	public WebElement DRIVERNAME_CHECKBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Standard')]//following-sibling::div")
	@CacheLookup
	public WebElement STANDARD_CHECKBOX;
	
	@FindBy(xpath ="//div[contains(text(),'Satellite')]//following-sibling::div")
	@CacheLookup
	public WebElement SATELLITE_CHECKBOX;

	@FindBy(xpath ="//div[contains(text(),'Show')]//following-sibling::div[contains(@class,'traffic_enable')]")
	@CacheLookup
	public WebElement TRAFFIC_CHECKBOX;

	@FindBy(id ="points_of_interest_enable")
	@CacheLookup
	public WebElement POINTSOFINTEREST_CHECKBOX;
	
	@FindBy(xpath ="//button[text()='Manage']")
	@CacheLookup
	public WebElement MANAGE_BUTTON;
	
	//SERVICE SUMMARY
	
	@FindBy(id ="services_list_table")
	@CacheLookup
	public WebElement VEHICLE_SERVICE_TABLE;
	
	@FindBy(xpath ="//td[@class='service_row_reg']")
	@CacheLookup
	public List<WebElement> VEHICLE_REGISTERED_LIST;
	
	@FindBy(xpath ="//td[@class='service_row_name']")
	@CacheLookup
	public List<WebElement> DRIVER_NAME_LIST;
	
	@FindBy(css =".select_all_vehicles_button.gradient_button_primary")
	@CacheLookup
	public WebElement SUMMARY_SELECT_DESELECT_BUTTON;
	
	@FindBy(css =".select_by_group.gradient_button_primary")
	@CacheLookup
	public WebElement SUMMARY_GROUP_BUTTON;
	
	@FindBy(xpath ="//div[@id='vehicle_select_panel']/div/div/button[text()='Go']")
	@CacheLookup
	public WebElement SUMMARY_BOTTOM_GO_BUTTON;
	
	@FindBy(xpath ="//td[contains(@id,'service_display')]")
	@CacheLookup
	public List<WebElement> SUMMARY_CHECKBOX_LIST;	
	
	@FindBy(xpath ="//span[@class='group_color']")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_COLORSYMBAL_LIST;
	
	@FindBy(xpath ="//td[@class='group_row_name']")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_NAME_LIST;
	
	@FindBy(xpath ="//td[contains(@class,'group_display')]")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_CHECKBOX_LIST;
	
	@FindBy(xpath ="//div[@id='vehicle_group_select_panel']/div/div/button[text()='Go']")
	@CacheLookup
	public WebElement VEHICLE_GROUP_GO_BUTTON;
	
	//@FindBy(xpath ="//tbody[contains(@id,'group-details')]/tr[contains(@class,'service_row')]/td[@class='service_row_reg']")
	@FindBy(xpath ="//tbody[@id='group-details-1515']/tr/td[@class='service_row_reg']")
	@CacheLookup
	public List<WebElement> SELECTED_DRIVER_GROUP_LIST;
	
	
	
}
