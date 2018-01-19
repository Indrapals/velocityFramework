package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import actionslibrary.CommonActionUtil;

public class VehicleCheckPage {

	final WebDriver driver;

	public VehicleCheckPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(id = "vehicle-check-manage-fleet")
	@CacheLookup
	public WebElement manageFleetTile;

	@FindBy(id = "vehicle-check-manage-groups")
	@CacheLookup
	public WebElement manageGroupsTile;

	@FindBy(id = "vehicle-check-reports")
	@CacheLookup
	public WebElement reportsTile;

	@FindBy(id = "vehicle-check-manage-questions")
	@CacheLookup
	public WebElement manageQuestionTile;

	@FindBy(id = "vehicle-check-defect-management")
	@CacheLookup
	public WebElement defectManagementTile;

	@FindBy(id = "vehicle-due-dates-dashboard")
	@CacheLookup
	public WebElement duedatesTile;

	@FindBy(id = "vehicle-check-dashboard")
	@CacheLookup
	public WebElement vehiclecheckDashboardTile;

	@FindBy(id = "vehicle-check-alerts")
	@CacheLookup
	public WebElement alertsTile;

	@FindBy(xpath = "//h2[text()='Manage Fleet']")
	@CacheLookup
	public WebElement manageFleetMenu;

	@FindBy(xpath = "//a[@href='/vehicle-check/manage-vehicles/']")
	@CacheLookup
	public WebElement vehiclesTile;

	@FindBy(xpath = "//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li")
	@CacheLookup
	public List<WebElement> vehiclecheckDropdownlist;

	@FindBy(xpath = "//div[text()='Vehicles']")
	@CacheLookup
	public WebElement vehiclesTileText;

	@FindBy(xpath = "//div[text()='Drivers']")
	@CacheLookup
	public WebElement driversTile;

	@FindBy(xpath = "//h2[text()='Manage Vehicles']")
	@CacheLookup
	public WebElement manageVehiclesMenu;

	@FindBy(xpath = "//table[@id='data-table']/thead/tr[1]/th")
	@CacheLookup
	public List<WebElement> manageVehiclesHeaderList;

	@FindBy(xpath = "//td[@class='vehicle-active']/img[@title='Active']")
	@CacheLookup
	public List<WebElement> activeCheckList;

	@FindBy(xpath = "//button[contains(text(),'Show Removed Vehicles')]")
	@CacheLookup
	public WebElement showRemovedVehiclesButton;

	@FindBy(xpath = "//button[contains(text(),'Hide Removed Vehicles')]")
	@CacheLookup
	public WebElement hideRemovedVehiclesButton;

	@FindBy(xpath = "//td[@class='vehicle-active']/img[@title='Inactive']")
	@CacheLookup
	public List<WebElement> inactiveCheckList;

	@FindBy(id = "add-objects")
	@CacheLookup
	public WebElement addobjectsButton;

	@FindBy(id = "edit-objects")
	@CacheLookup
	public WebElement editObjectsButton;

	@FindBy(xpath = "//div[@id='formset-modal']/div/div/form/table/thead/tr/th[contains(text(),'Vehicle Type')]")
	@CacheLookup
	public WebElement vehicleTypeHeader;

	@FindBy(xpath = "//div[@id='formset-modal']/div/div[1]/form/table/thead/tr/th")
	@CacheLookup
	public List<WebElement> vehicleTypeHeaderList;

	@FindBy(id = "id_form-0-vehicle_type")
	@CacheLookup
	public WebElement vehicleTypeDropdown;

	@FindBy(xpath = "//select[@id='id_form-0-vehicle_type']/option")
	@CacheLookup
	public List<WebElement> vehicleTypeDropdownList;

	@FindBy(id = "id_form-0-registration")
	@CacheLookup
	public WebElement vehicleRegistrationTextbox;

	@FindBy(xpath = "//input[@id='id_form-0-can_attach_trailer']//following-sibling::img")
	@CacheLookup
	public WebElement attachTrailerCheckbox;

	@FindBy(id = "id_form-0-groups")
	@CacheLookup
	public WebElement groupDropdown;

	@FindBy(xpath = "//input[@id='id_form-0-visible']//following-sibling::img")
	@CacheLookup
	public WebElement activeCheckbox;

	@FindBy(xpath = "//input[@id='id_form-0-removed']//following-sibling::button")
	@CacheLookup
	public WebElement manageVehiclePopupRemoveButton;

	@FindBy(xpath = "//div[@id='formset-modal']/div/div/form/table/tbody/tr/td/div/label")
	@CacheLookup
	public List<WebElement> dueDatesCalanderList;

	@FindBy(name = "add_objects")
	@CacheLookup
	public WebElement manageVehiclePopupAddButton;

	@FindBy(name = "submit_formset")
	@CacheLookup
	public WebElement manageVehiclePopupSubmitButton;

	@FindBy(name = "cancel-button")
	@CacheLookup
	public WebElement manageVehiclePopupCancelButton;

	@FindBy(xpath = "//td[contains(@class,'vehicle-reg sorting')]")
	@CacheLookup
	public List<WebElement> activeVehicleList;

	@FindBy(xpath = "//img[@alt='Vehicle Check']")
	@CacheLookup
	public WebElement vehicleCheckTile;

	public String getManagementFleetTileColor() {

		return CommonActionUtil.getcolor(manageFleetTile);
	}

	public String getManageGroupsTileColor() {

		return CommonActionUtil.getcolor(manageGroupsTile);
	}

	public String getReportsTileColor() {

		return CommonActionUtil.getcolor(reportsTile);
	}

	public String getManageQuestionTileColor() {

		return CommonActionUtil.getcolor(manageQuestionTile);
	}

	public String getDefectManagementTileColor() {

		return CommonActionUtil.getcolor(defectManagementTile);
	}

	public String getDueDatesTileColor() {

		return CommonActionUtil.getcolor(duedatesTile);
	}

	public String getVechicleCheckDashboardTileColor() {

		return CommonActionUtil.getcolor(vehiclecheckDashboardTile);
	}

	public String getAlertTileColor() {

		return CommonActionUtil.getcolor(alertsTile);
	}

	public String getManageVehiclepopupAddButtonColor() {

		return CommonActionUtil.getcolor(manageVehiclePopupAddButton);
	}

	public String getManageVehiclepopupSubmitButtonColor() {

		return CommonActionUtil.getcolor(manageVehiclePopupSubmitButton);
	}

	public String getManageVehiclepopupCancelButtonColor() {

		return CommonActionUtil.getcolor(manageVehiclePopupCancelButton);
	}

	public void clickonSubmitButton() {
		manageVehiclePopupSubmitButton.click();
	}

	public void getaction() {

		vehicleCheckTile.click();
		manageFleetTile.click();
		vehiclesTile.click();

		List<String> lstMovedItem = new ArrayList<String>();
		for (int i = 0; i < activeCheckList.size(); i++) {
			lstMovedItem.add(activeCheckList.get(i).getText());
		}
	}
}
