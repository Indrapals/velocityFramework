package geberitWebTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericlibrary.BrowserUtilities;
import genericlibrary.LogUtilities;
import genericlibrary.ScreenshotUtilities;
import pageobjects.LoginPage;

public class GeberitTest_001 {

	LoginPage lpobj;
	Logger log;
	ATUTestRecorder recorder;
	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();

	@BeforeTest
	public void launch() throws IOException, ATUTestRecorderException {
		// Provide path to store videos and file name format.
		recorder = new ATUTestRecorder("./ScriptVideos/", "TestVideo-" + dateFormat.format(date), false);
		// To start video recording.
		recorder.start();

		DOMConfigurator.configure("log4j.xml");

		BrowserUtilities.getBrowser();

		LogUtilities.info("Browser launched with url Successfully");
	}

	@BeforeMethod
	public void laodPages() {
		lpobj = PageFactory.initElements(BrowserUtilities.driver, LoginPage.class);
	}

	@Test(alwaysRun = true)
	public void loginuserTest_001() throws Exception {

		try {

			lpobj.loginUser();

			LogUtilities.info("User login Successfully");
			Assert.assertEquals("dfsdf", "fadfd");
			LogUtilities.info("Test step 1 passed Successfully");

			// TestLinkIntegration.updateResult("VLC-1", null,
			// TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			System.out.println("Test Failed");
			// TestLinkIntegration.updateResult("VLC-1", e.getMessage(),
			// TestLinkAPIResults.TEST_FAILED);
		}
	}

	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtilities.captureScreenShot();
		}
	}

	@AfterTest
	public void crash() throws IOException, ATUTestRecorderException {
		BrowserUtilities.closeBrowser();
		recorder.stop();
	}
}
