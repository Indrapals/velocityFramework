package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LivemapPage {

	final WebDriver driver;

	public LivemapPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(id = "nav_live_map")
	@CacheLookup
	public WebElement livemapModule;

	@FindBy(id = "map_canvas")
	@CacheLookup
	public WebElement mapCanvas;

	@FindBy(xpath = "//div[contains(@class,'info_window_wrapper device_wrapper')]")
	@CacheLookup
	public List<WebElement> independentVehicleList;

	@FindBy(xpath = "//div[contains(@class,'info_window_outer_wrapper')]")
	@CacheLookup
	public List<WebElement> independentVehicleListWithDropdown;

	@FindBy(xpath = "//div[contains(@style,'m1.png')]")
	@CacheLookup
	public List<WebElement> vehicleClustorList;

	@FindBy(css = ".fa.fa-stop.ignition_state_icon")
	@CacheLookup
	public List<WebElement> parkedVehicleList;

	@FindBy(css = ".fa.fa-play.ignition_state_icon")
	@CacheLookup
	public List<WebElement> movingVehicleList;

	@FindBy(css = ".options_button.tab_button")
	@CacheLookup
	public WebElement optionsButton;

	@FindBy(css = ".reset_button.tab_button")
	@CacheLookup
	public WebElement restmapButton;

	@FindBy(css = ".service_list_tab_button.tab_button")
	@CacheLookup
	public WebElement summaryButton;

	@FindBy(css = ".fullscreen_tab_button.tab_button")
	@CacheLookup
	public WebElement fullScreenButton;

	@FindBy(css = ".options_button.tab_button")
	@CacheLookup
	public WebElement optionsCloseButton;

	@FindBy(css = ".service_list_tab_button.tab_button")
	@CacheLookup
	public WebElement serviceSummaryCloseButton;

	@FindBy(xpath = "//div[contains(text(),'Vehicle Display')]")
	@CacheLookup
	public WebElement vehicleDisplayTextbox;

	@FindBy(xpath = "//div[contains(text(),'Vehicle Registration')]")
	@CacheLookup
	public WebElement vehicleRegistrationTextbox;

	@FindBy(xpath = "//div[contains(text(),'Driver Name')]")
	@CacheLookup
	public WebElement drivernameTextbox;

	@FindBy(xpath = "//div[contains(text(),'Map Style')]")
	@CacheLookup
	public WebElement mapstyleTextbox;

	@FindBy(xpath = "//div[contains(text(),'Standard')]")
	@CacheLookup
	public WebElement standardTextbox;

	@FindBy(xpath = "//div[contains(text(),'Satellite')]")
	@CacheLookup
	public WebElement satelliteTextbox;

	@FindBy(xpath = "//div[contains(text(),'Traffic')]")
	@CacheLookup
	public WebElement trafficTextbox;

	@FindBy(xpath = "//div[contains(text(),'Points of Interest')]")
	@CacheLookup
	public WebElement pointofinterestTextbox;

	@FindBy(xpath = "//div[contains(text(),'Vehicle Registration')]//following-sibling::div")
	@CacheLookup
	public WebElement vehicleRegistrationCheckbox;

	@FindBy(xpath = "//div[contains(text(),'Driver Name')]//following-sibling::div")
	@CacheLookup
	public WebElement drivernameCheckbox;

	@FindBy(xpath = "//div[contains(text(),'Standard')]//following-sibling::div")
	@CacheLookup
	public WebElement standardCheckbox;

	@FindBy(xpath = "//div[contains(text(),'Satellite')]//following-sibling::div")
	@CacheLookup
	public WebElement satelliteCheckbox;

	@FindBy(xpath = "//div[contains(text(),'Show')]//following-sibling::div[contains(@class,'traffic_enable')]")
	@CacheLookup
	public WebElement trafficCheckbox;

	@FindBy(id = "points_of_interest_enable")
	@CacheLookup
	public WebElement pointofInterestCheckbox;

	@FindBy(xpath = "//button[text()='Manage']")
	@CacheLookup
	public WebElement manageButton;

	// SERVICE SUMMARY

	@FindBy(id = "services_list_table")
	@CacheLookup
	public WebElement vehicleServiceTable;

	@FindBy(xpath = "//td[@class='service_row_reg']")
	@CacheLookup
	public List<WebElement> vehicleRegisteredList;

	@FindBy(xpath = "//td[@class='service_row_name']")
	@CacheLookup
	public List<WebElement> driverNameList;

	@FindBy(css = ".select_all_vehicles_button.gradient_button_primary")
	@CacheLookup
	public WebElement summarySelectDeselectButton;

	@FindBy(css = ".select_by_group.gradient_button_primary")
	@CacheLookup
	public WebElement SUMMARY_GROUP_BUTTON;

	@FindBy(xpath = "//div[@id='vehicle_select_panel']/div/div/button[text()='Go']")
	@CacheLookup
	public WebElement SUMMARY_BOTTOM_GO_BUTTON;

	@FindBy(xpath = "//td[contains(@id,'service_display')]")
	@CacheLookup
	public List<WebElement> SUMMARY_CHECKBOX_LIST;

	@FindBy(xpath = "//span[@class='group_color']")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_COLORSYMBAL_LIST;

	@FindBy(xpath = "//td[@class='group_row_name']")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_NAME_LIST;

	@FindBy(xpath = "//td[contains(@class,'group_display')]")
	@CacheLookup
	public List<WebElement> VEHICLE_GROUP_CHECKBOX_LIST;

	@FindBy(xpath = "//div[@id='vehicle_group_select_panel']/div/div/button[text()='Go']")
	@CacheLookup
	public WebElement VEHICLE_GROUP_GO_BUTTON;

	// @FindBy(xpath
	// ="//tbody[contains(@id,'group-details')]/tr[contains(@class,'service_row')]/td[@class='service_row_reg']")
	@FindBy(xpath = "//tbody[@id='group-details-1515']/tr/td[@class='service_row_reg']")
	@CacheLookup
	public List<WebElement> SELECTED_DRIVER_GROUP_LIST;

}
