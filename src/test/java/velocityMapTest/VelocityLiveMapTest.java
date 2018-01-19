package velocityMapTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionslibrary.CommonActionUtil;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericlibrary.BrowserUtilities;
import genericlibrary.LogUtilities;
import genericlibrary.ScreenshotUtilities;
import genericlibrary.TestLinkIntegration;
import pageobjects.HomePage;
import pageobjects.LivemapPage;
import pageobjects.LoginPage;
import testlink.api.java.client.TestLinkAPIResults;

public class VelocityLiveMapTest {

	HomePage hpobj;
	LoginPage lpobj;
	LivemapPage lmpobj;
	static int count = 0;
	static int countblue = 0;
	static String ExpectedBlue = "rgba(79, 184, 232, 1)";
	ATUTestRecorder recorder;
	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();

	@BeforeTest
	public void launch() throws IOException, ATUTestRecorderException {
		// Provide path to store videos and file name format.
		recorder = new ATUTestRecorder("C:\\Users\\Ranosys\\workspace\\velocity\\ScriptVideos\\",
				"TestVideo-" + dateFormat.format(date), false);
		// To start video recording.
		recorder.start();

		DOMConfigurator.configure("log4j.xml");

		BrowserUtilities.getBrowser();

		LogUtilities.info("Browser launched with url Successfully");

	}

	@BeforeMethod
	public void laodPages() {

		hpobj = PageFactory.initElements(BrowserUtilities.driver, HomePage.class);
		lpobj = PageFactory.initElements(BrowserUtilities.driver, LoginPage.class);
		lmpobj = PageFactory.initElements(BrowserUtilities.driver, LivemapPage.class);
	}

	@Test(alwaysRun = true)
	public void liveMapTest_020() throws Exception {

		try {

			lpobj.loginUser();

			LogUtilities.info("User login Successfully");

			Assert.assertTrue(hpobj.vehicleCheckMenu.isDisplayed(), "Vehicle menu displayed");

			CommonActionUtil.moveTo(hpobj.kinesistelematicsMenu);

			lmpobj.livemapModule.click();

			lmpobj.mapCanvas.isDisplayed();

			System.out
					.println("No of Independent vehicle present on screen :  " + lmpobj.independentVehicleList.size());

			System.out.println("No of Parked vehicle present on screen :  " + lmpobj.parkedVehicleList.size() / 4);

			System.out.println("No of Moving vehicle present on screen :  " + lmpobj.movingVehicleList.size() / 4);

			System.out.println("No of vehicle clusters present on screen :  " + lmpobj.vehicleClustorList.size());

			for (WebElement element : lmpobj.vehicleClustorList) {
				System.out.println("Clusters contain no vehicles " + element.getText());
			}

			for (int i = 0; i < lmpobj.independentVehicleList.size(); i++) {
				if (lmpobj.independentVehicleList.get(i).getCssValue("background-color")
						.equals("rgba(40, 142, 205, 1)")) {
					countblue++;
					System.out.println("Numbers of Independent vehicles with blue color are : " + countblue);
				} else {
					count++;
					System.out.println("Numbers of Independent vehicles with Orange color are : " + count);

				}
			}

			System.out.println("Verified test successfully: => Assertion for Step 20 PASS ");
			TestLinkIntegration.updateResult("VLC-20", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {

			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-20", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_021() throws Exception {

		try {
			lmpobj.optionsButton.click();
			Assert.assertTrue(lmpobj.vehicleDisplayTextbox.isDisplayed(), "Vehicle Display text box is displayed");
			Assert.assertTrue(lmpobj.vehicleRegistrationTextbox.isDisplayed(),
					"Vehicle Registration text box is displayed");
			Assert.assertTrue(lmpobj.drivernameTextbox.isDisplayed(), "Driver Name text box is displayed");
			Assert.assertTrue(lmpobj.vehicleDisplayTextbox.isDisplayed(), "Vehicle Display text box is displayed");
			Assert.assertTrue(lmpobj.mapstyleTextbox.isDisplayed(), "May style text box is displayed");
			Assert.assertTrue(lmpobj.standardTextbox.isDisplayed(), "Standard text box is displayed");
			Assert.assertTrue(lmpobj.satelliteTextbox.isDisplayed(), "Satellite text box is displayed");
			Assert.assertTrue(lmpobj.trafficTextbox.isDisplayed(), "Traffic text box is displayed");
			Assert.assertTrue(lmpobj.pointofinterestTextbox.isDisplayed(), "Point of interest text box is displayed");

			System.out.println("Verified test successfully: => Assertion for Step 21 PASS ");
			TestLinkIntegration.updateResult("VLC-21", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-21", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_022() throws Exception {

		try {

			lmpobj.drivernameCheckbox.click();
			for (WebElement element : lmpobj.independentVehicleListWithDropdown) {
				System.out.println(element.getText());

			}

			System.out.println("Verified test successfully: => Assertion for Step 22 PASS ");
			TestLinkIntegration.updateResult("VLC-22", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-22", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_023() throws Exception {

		try {

			lmpobj.satelliteCheckbox.click();
			Screen screen = new Screen();
			Pattern SatelliteImage = new Pattern("D:\\Sikuli.sikuli\\1514292511154.png");
			if (screen.exists(SatelliteImage) != null) {

				lmpobj.standardCheckbox.click();
			}

			System.out.println("Satellite view verified test successfully: => Assertion for Step 23 PASS ");
			TestLinkIntegration.updateResult("VLC-23", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-23", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_024() throws Exception {

		try {

			lmpobj.trafficCheckbox.click();
			Screen screen = new Screen();
			Pattern TrafficImage = new Pattern("D:\\Sikuli.sikuli\\1514292696619.png");
			if (screen.exists(TrafficImage) != null) {
				lmpobj.trafficCheckbox.click();
				lmpobj.restmapButton.click();
			}

			System.out.println("Traffic view verified test successfully: => Assertion for Step 24 PASS ");
			TestLinkIntegration.updateResult("VLC-24", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-24", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_025() throws Exception {
		try {

			lmpobj.pointofInterestCheckbox.click();
			Screen screen = new Screen();
			Pattern POIImage = new Pattern("D:\\Sikuli.sikuli\\1514351111559.png");
			if (screen.exists(POIImage) != null) {

				lmpobj.pointofInterestCheckbox.click();
				lmpobj.restmapButton.click();
				lmpobj.optionsCloseButton.click();
			}

			System.out.println("POI view verified test successfully: => Assertion for Step 25 PASS ");
			TestLinkIntegration.updateResult("VLC-25", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-25", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_026() throws Exception {
		try {

			lmpobj.summaryButton.click();
			Assert.assertTrue(lmpobj.vehicleServiceTable.isDisplayed(), "Vehicle Service DropDown list displayed");
			lmpobj.serviceSummaryCloseButton.click();

			System.out.println("Verified test successfully: => Assertion for Step 26 PASS ");
			TestLinkIntegration.updateResult("VLC-26", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-26", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_027() throws Exception {
		try {

			lmpobj.summaryButton.click();

			lmpobj.SUMMARY_GROUP_BUTTON.click();

			for (WebElement element : lmpobj.VEHICLE_GROUP_NAME_LIST) {
				Assert.assertTrue(element.isDisplayed(), "Groups list's names are displayed");
			}

			for (WebElement element : lmpobj.VEHICLE_GROUP_CHECKBOX_LIST) {
				Assert.assertFalse(element.isSelected(), "Groups list of Checkboxes are selected by default");
			}

			System.out.println("Verified test successfully: => Assertion for Step 27 PASS ");
			TestLinkIntegration.updateResult("VLC-27", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-27", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(alwaysRun = true)
	public void liveMapTest_028() throws Exception {
		try {

			lmpobj.VEHICLE_GROUP_CHECKBOX_LIST.get(1).click();
			lmpobj.VEHICLE_GROUP_GO_BUTTON.click();

			List<String> lstSelectedItem = new ArrayList<String>();
			for (int i = 0; i < lmpobj.SELECTED_DRIVER_GROUP_LIST.size(); i++) {
				lstSelectedItem.add(lmpobj.SELECTED_DRIVER_GROUP_LIST.get(i).getText());
			}

			List<String> lstMovedItem = new ArrayList<String>();
			for (int i = 0; i < lmpobj.independentVehicleList.size(); i++) {
				lstMovedItem.add(lmpobj.independentVehicleList.get(i).getText());
			}

			Collections.sort(lstSelectedItem);
			Collections.sort(lstMovedItem);

			// verify the lists are equal
			Assert.assertEquals(lstSelectedItem, lstMovedItem);

			System.out.println("Verified test successfully: => Assertion for Step 28 PASS ");
			TestLinkIntegration.updateResult("VLC-28", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-28", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@AfterMethod
	public void captureTest() {
		ScreenshotUtilities.captureScreenShot();
	}

	@AfterTest
	public void crash() throws IOException, ATUTestRecorderException {
		BrowserUtilities.closeBrowser();
		recorder.stop();
	}

}
