package velocityAndroidAppTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionslibrary.AndroidAction;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericlibrary.AppiumServer;
import genericlibrary.ApplicationSetup;
import genericlibrary.BrowserUtilities;
import genericlibrary.ConfigProperties;
import genericlibrary.ScreenshotUtilities;
import genericlibrary.TestLinkIntegration;
import io.appium.java_client.MobileElement;
import pageobjects.AndroidAppPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.VehicleCheckPage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class velocityAppTest {

	AndroidAppPage appobj;
	LoginPage lpobj;
	HomePage hpobj;
	VehicleCheckPage vcpobj;
	Set<String> allElementsText = new HashSet<String>();
	Set<String> allWebElementsText = new HashSet<String>();
	ATUTestRecorder recorder;
	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	Dimension size;

	@BeforeTest
	public void launch() throws IOException, ATUTestRecorderException {
		// Provide path to store videos and file name format.
		recorder = new ATUTestRecorder(ConfigProperties.getObject("ScriptVideos"),
				"TestVideo-" + dateFormat.format(date), false);
		// To start video recording.
		recorder.start();
		AppiumServer.launchEmulator("Test2");
		AppiumServer.startServer();
		ApplicationSetup.setCapability();
	}

	@BeforeMethod
	public void setUp() throws ExecuteException, IOException {

		appobj = PageFactory.initElements(ApplicationSetup.driver, AndroidAppPage.class);
		lpobj = PageFactory.initElements(BrowserUtilities.driver, LoginPage.class);
		hpobj = PageFactory.initElements(BrowserUtilities.driver, HomePage.class);
		vcpobj = PageFactory.initElements(BrowserUtilities.driver, VehicleCheckPage.class);

	}

	@Test(enabled = true)
	public void vehicleAppTest_011() throws TestLinkAPIException, IOException {
		try {
			appobj.loginInactiveUserWithoutCode();
			String ExpectedMessage = "Please enter the secret code associated with your account";
			Assert.assertEquals(ExpectedMessage, appobj.messagePopup.getText());
			TestLinkIntegration.updateResult("VLC-11", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-11", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_012() throws TestLinkAPIException, IOException {
		try {
			appobj.loginInactiveUserWithCode();
			String ExpectedMessage = "Driver not found.";
			Assert.assertEquals(ExpectedMessage, appobj.messagePopup.getText());

			TestLinkIntegration.updateResult("VLC-12", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-12", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_013() throws TestLinkAPIException, IOException {
		try {
			appobj.loginActiveUserWithIncorrectCode();
			String ExpectedMessage = "Driver not found.";
			Assert.assertEquals(ExpectedMessage, appobj.messagePopup.getText());
			TestLinkIntegration.updateResult("VLC-13", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-13", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_014() throws TestLinkAPIException, IOException {
		try {

			appobj.loginActiveUserWithCorrectCode();
			Assert.assertTrue(appobj.navbackButton.isDisplayed(), "Exit Icon is displayed");
			Assert.assertTrue(appobj.bellIcon.isDisplayed(), "Bell Icon is displayed");
			Assert.assertTrue(appobj.titleVehicleCheck.isDisplayed(), "Vehicle check title is displayed");
			Assert.assertTrue(appobj.companyName.isDisplayed(), "Account you logged in is displayed");
			Assert.assertTrue(appobj.vehicleSelectDropDown.isDisplayed(), "Vehicle dropdown list is displayed");
			Assert.assertTrue(appobj.refreshIcon.isDisplayed(), "Refresh icon is displayed");
			Assert.assertTrue(appobj.rememberChoiceCheckboxChecked.isDisplayed(), "Remember checkbox is displayed");
			Assert.assertTrue(appobj.useWifiCheckboxUnchecked.isDisplayed(), "Wifi checkbox is displayed");
			Assert.assertTrue(appobj.vehicleCheckSubmitButton.isDisplayed(), "Submit button is displayed");
			Assert.assertTrue(appobj.previousVehicleCheckButton.isDisplayed(), "Previous check button is displayed");

			TestLinkIntegration.updateResult("VLC-14", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-14", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_015() throws TestLinkAPIException, IOException {
		try {
			appobj.vehicleSelectDropDown.click();
			List<MobileElement> list1 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list1) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}
			size = ApplicationSetup.driver.manage().window().getSize();
			System.out.println(size);
			int height = size.getHeight();
			int weight = size.getWidth();
			int x = weight / 2;
			int starty = (int) (height * 0.60);
			int endy = (int) (height * 0.38);
			ApplicationSetup.driver.swipe(x, starty, x, endy, 500);

			List<MobileElement> list2 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list2) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}

			ApplicationSetup.driver.swipe(x, starty, x, endy, 500);

			List<MobileElement> list3 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list3) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}

			ApplicationSetup.driver.swipe(x, starty, x, endy, 500);

			List<MobileElement> list4 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list4) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}

			ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
			List<MobileElement> list5 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list5) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}

			ApplicationSetup.driver.swipe(x, starty, x, endy, 500);

			List<MobileElement> list6 = ApplicationSetup.driver.findElements(By.id("item_name"));

			for (WebElement element : list6) {
				String text = element.getText();
				System.out.println(text);
				allElementsText.add(text);

			}

			for (String s : allElementsText) {
				System.out.println("All elements:" + s);
			}
			List<String> allElementsTextApp = new ArrayList<String>(allElementsText);

			int ElementsCount = allElementsText.size();
			if (ElementsCount == 13) {
				System.out.println("List of elements are equal ");
			}

			BrowserUtilities.getBrowser();
			BrowserUtilities.driver.findElement(By.xpath("//a[contains(text(),'I agree')]")).click();
			BrowserUtilities.driver.findElement(By.xpath("//input[@value='Login']")).click();
			BrowserUtilities.driver.findElement(By.id("id_username")).sendKeys("anand.ramdeo@ranosys.com");
			BrowserUtilities.driver.findElement(By.id("id_password")).sendKeys("Wednesday1350");
			BrowserUtilities.driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(300);
			BrowserUtilities.driver.findElement(By.xpath("//img[@alt='Vehicle Check']")).click();
			Thread.sleep(200);
			BrowserUtilities.driver.findElement(By.id("vehicle-check-manage-fleet")).click();
			BrowserUtilities.driver.findElement(By.xpath("//a[@href='/vehicle-check/manage-vehicles/']")).click();

			List<WebElement> lst = BrowserUtilities.driver
					.findElements(By.xpath("//td[contains(@class,'vehicle-reg sorting')]"));
			System.out.println(lst.size());

			Thread.sleep(100);
			JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
			js.executeScript("window.scrollBy(0,400)", "");
			for (WebElement element : lst) {

				System.out.println(element.getText());
				String text = element.getText();

				allWebElementsText.add(text);

			}
			List<String> allElementsTextWeb = new ArrayList<String>(allWebElementsText);
			Collections.sort(allElementsTextApp);
			Collections.sort(allElementsTextWeb);
			BrowserUtilities.closeBrowser();

			Assert.assertEquals(allElementsTextApp, allElementsTextWeb, "Verified both the list of active vehicles");

			TestLinkIntegration.updateResult("VLC-15", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-15", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_016() throws TestLinkAPIException, IOException {
		try {

			appobj.navbackButton.click();
			appobj.loginButton.click();
			appobj.vehicleCheckSubmitButton.click();
			String ExpectedMessage = "Vehicle not found.";
			Assert.assertEquals(ExpectedMessage, appobj.messagePopup.getText());
			TestLinkIntegration.updateResult("VLC-16", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-16", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_017() throws TestLinkAPIException, IOException {
		try {

			appobj.okButton.click();
			AndroidAction.implicitwait(200, TimeUnit.SECONDS);
			Thread.sleep(1000);
			appobj.vehicleSelectDropDown.click();
			size = ApplicationSetup.driver.manage().window().getSize();
			System.out.println(size);
			int height = size.getHeight();
			int weight = size.getWidth();
			int x = weight / 2;
			int starty = (int) (height * 0.60);
			int endy = (int) (height * 0.38);
			for (int i = 0; i <= 2; i++) {
				ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
			}

			appobj.selectHirevan1.click();
			appobj.selectVehicleOkButton.click();
			appobj.vehicleCheckSubmitButton.click();

			Assert.assertTrue(appobj.pleaseSelectTitle.isDisplayed(), "Please select Icon is displayed");
			Assert.assertTrue(appobj.homeIcon.isDisplayed(), "Home Icon is displayed");
			Assert.assertTrue(appobj.vehicleCheckIcon.isDisplayed(), "Vehicle check Icon is displayed");
			Assert.assertTrue(appobj.reportIncidentIcon.isDisplayed(), "Report an incident Icon is displayed");
			TestLinkIntegration.updateResult("VLC-17", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-17", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_018() throws TestLinkAPIException, IOException {
		try {

			appobj.homeIcon.click();
			Assert.assertTrue(appobj.titleVehicleCheck.isDisplayed(), "Vehicle check home screen is displayed");
			TestLinkIntegration.updateResult("VLC-18", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-18", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test(enabled = true)
	public void vehicleAppTest_019() throws TestLinkAPIException, IOException {
		try {

			appobj.vehicleSelectDropDown.click();
			size = ApplicationSetup.driver.manage().window().getSize();
			System.out.println(size);
			int height = size.getHeight();
			int weight = size.getWidth();
			int x = weight / 2;
			int starty = (int) (height * 0.60);
			int endy = (int) (height * 0.38);
			for (int i = 0; i <= 2; i++) {
				ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
			}

			appobj.selectHirevan1.click();
			appobj.selectVehicleOkButton.click();
			appobj.vehicleCheckSubmitButton.click();
			appobj.vehicleCheckIcon.click();
			appobj.interiorQuestionIcon.click();
			Assert.assertTrue(appobj.interiorQuestionText.isDisplayed(), "Interior question text is displayed");
			TestLinkIntegration.updateResult("VLC-19", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-19", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@AfterMethod
	public void captureTest() {
		ScreenshotUtilities.captureAndroidScreenShot();
	}

	@AfterTest
	public void endTest() throws ATUTestRecorderException {
		ApplicationSetup.driver.quit();
		recorder.stop();

	}

}
