package velocityWebTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionsLibrary.CommonActionUtil;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericLibrary.BrowserUtilities;
import genericLibrary.LogUtilities;
import genericLibrary.ScreenshotUtilities;
import genericLibrary.TestLinkIntegration;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.VehicleCheckPage;
import testlink.api.java.client.TestLinkAPIResults;

public class VelocityTest_001 {

	
	LoginPage lpobj;
	HomePage hpobj;
	VehicleCheckPage vcpobj;
	Logger log;
	//private String sTestCaseName;
	static String ExpectedPink="rgba(219, 30, 124, 1)";
	static String ExpectedPurple="rgba(170, 54, 203, 1)";
	static String ExpectedBlue="rgba(79, 184, 232, 1)";
	static String ExpectedLightGreen="rgba(152, 202, 105, 1)";
	static String ExpectedLightRed="rgba(242, 102, 79, 1)";
	 ATUTestRecorder recorder;
	  DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	  Date date = new Date();
	
	  @BeforeTest
	  public void launch() throws IOException, ATUTestRecorderException{
		//Provide path to store videos and file name format.
		  recorder = new ATUTestRecorder("C:\\Users\\Ranosys\\workspace\\velocity\\ScriptVideos\\","TestVideo-"+dateFormat.format(date),false);
		  //To start video recording.
		  recorder.start(); 
		  
		DOMConfigurator.configure("log4j.xml");
		
		BrowserUtilities.getBrowser();
		
		LogUtilities.info("Browser launched with url Successfully");
	}
	
	  @BeforeMethod
	  public void laodPages(){
		  lpobj= PageFactory.initElements(BrowserUtilities.driver, LoginPage.class);
		  hpobj=PageFactory.initElements(BrowserUtilities.driver, HomePage.class);
		  vcpobj=PageFactory.initElements(BrowserUtilities.driver, VehicleCheckPage.class);  
	  }
	
	  @Test(alwaysRun = true)
	  public void vehicleCheckMenuTest_001() throws Exception{
		
	    try {
	    	
	    	lpobj.login_User();
	    	
	    	LogUtilities.info("User login Successfully");
	    	
	    	Assert.assertTrue(hpobj.VEHICLECHECK_MENU.isDisplayed(),"Vehicle menu displayed");
	    
            CommonActionUtil.moveTo(hpobj.VEHICLECHECK_MENU);
			
			String arr[] = {"", "Home", "Vehicle Check Dashboard", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
	    	
			for(int i=0;i<vcpobj.VEHICLECHECK_DROPDOWNLIST.size();i++)
	        {
	            System.out.println("Display Text : " + vcpobj.VEHICLECHECK_DROPDOWNLIST.get(i).getText());
	            Assert.assertEquals(arr[i],vcpobj.VEHICLECHECK_DROPDOWNLIST.get(i).getText(),"Verify vehicle Dropdown List");
	            
	        }
			
	    	System.out.println("Found all items in Vehicle check title successfully: => Assertion for Step1 PASS ");
	    	LogUtilities.info("Test step 1 passed Successfully");
	    	
	    	 TestLinkIntegration.updateResult("VLC-1", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			 TestLinkIntegration.updateResult("VLC-1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }


	    @Test(alwaysRun = true)
	    public void vehicleCheckTileTest_002() throws Exception{
		
	     try {
	    	 
	    	CommonActionUtil.moveTo(hpobj.VEHICLECHECK_TILE);
	    	hpobj.VEHICLECHECK_TILE.click();
	    	
	    	vcpobj.MANAGEFLEET_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getManagementFleetTileColor(),ExpectedBlue,"Manage fleet tile verify");
	    	
	    	vcpobj.MANAGEGROUPS_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getManageGroupsTileColor(),ExpectedBlue,"Manage groups tile verify");
	    	
	    	vcpobj.REPORTS_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getReportsTileColor(),ExpectedBlue,"Reports tile verify");
	    	
	    	vcpobj.MANAGEQUESTION_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getManageQuestionTileColor(),ExpectedBlue,"Manage question tile verify");
	    	
	    	vcpobj.DEFECTMANAGEMENT_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getDefectManagementTileColor(),ExpectedBlue,"Defect management tile verify");
	    	
	    	vcpobj.DUEDATES_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getDueDatesTileColor(),ExpectedPurple,"Due Dates fleet tile verify");
	    	
	    	vcpobj.VEHICLECHECKDASH_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getVechicleCheckDashboardTileColor(),ExpectedPurple,"Vehicle check dash tile verify");
	   
	    	vcpobj.ALERTS_TILE.isDisplayed();
	    	Assert.assertEquals(vcpobj.getAlertTileColor(),ExpectedPink,"Alerts fleet tile verify");
	    	
	    	System.out.println("All Eight Tiles Found and verified with required color: => Assertion for Step2 PASS");
	    	
	    	LogUtilities.info("All tiles verified with their colors:Test step2 passed");
	    	
	    	 TestLinkIntegration.updateResult("VLC-2", null, TestLinkAPIResults.TEST_PASSED);    	
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			 TestLinkIntegration.updateResult("VLC-2", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	    
	    
	    @Test(alwaysRun = true)
	    public void vehicleCheckTileTest_003() throws Exception{
		   try {
	    	
	    	vcpobj.MANAGEFLEET_TILE.click();
	    	
	    	Assert.assertEquals("Manage Fleet", vcpobj.MANAGEFLEET_MENU.getText(),"Manage fleet menu verify");
	    	
	        Assert.assertEquals("Vehicles", vcpobj.VEHICLES_TILE_TEXT.getText(),"Vehicles tile verify");
	    
	        Assert.assertEquals("Drivers", vcpobj.DRIVERS_TILE.getText(),"Drivers tile verify");
	        
	        System.out.println("Manage Fleet title ,Vehicles tile and Drivers tile Displayed: => Assertion for Step3 PASS");
	        LogUtilities.info("All elements verified :Test step3 passed");
	        
	        TestLinkIntegration.updateResult("VLC-3", null, TestLinkAPIResults.TEST_PASSED);    	
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			 TestLinkIntegration.updateResult("VLC-3", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	
	    
         @Test(alwaysRun = true)
	     public void vehiclesTileTest_004() throws Exception{
			
		    try {
		 
		    	//Verify vehicles manage Column headers 
 		    	 vcpobj.VEHICLES_TILE.click();
				
				String vehicleHeaderListarr[] = {"Vehicle Registration", "Vehicle Type", "Vehicle Group", "ODO Reading", "Active", "Edit Vehicle"};
		    	
				for(int i=0;i<vcpobj.MANAGEVEHICLES_HEADERLIST.size();i++)
		        {
		          System.out.println("Display Text : " + vcpobj.MANAGEVEHICLES_HEADERLIST.get(i).getText());
		          Assert.assertEquals(vehicleHeaderListarr[i],vcpobj.MANAGEVEHICLES_HEADERLIST.get(i).getText(),"Vehicle headerlist verify");
				 
		        }
				 System.out.println("Manage Vehicle HeaderList Verified");
				
				 for (WebElement element : vcpobj.ACTIVECHECK_LIST) {
		    	      Assert.assertTrue(element.isDisplayed(),"Active check list verify");
		    	    }
				
				 vcpobj.ADDOBJECTS_BUTTON.isDisplayed();
				 vcpobj.EDITOBJECTS_BUTTON.isDisplayed();
				 vcpobj.SHOWREMOVED_VEHICLES_BUTTON.isDisplayed();
				 
		    	System.out.println("Add,Edit and Show removed button verified");	
		    	
		    	 vcpobj.SHOWREMOVED_VEHICLES_BUTTON.click();
		    	 for (WebElement element : vcpobj.INACTIVECHECK_LIST) {
		    	     Assert.assertTrue(element.isDisplayed(),"Inactive check list verify");
		    	    }
		    		
		     System.out.println("All elements verified => Assertion for Step4 PASS");
		     LogUtilities.info("All elements verified :Test step4 passed");
		       
		       TestLinkIntegration.updateResult("VLC-4", null, TestLinkAPIResults.TEST_PASSED);    	
			   } catch (Exception e) {
				System.out.println("Test Failed");
			   TestLinkIntegration.updateResult("VLC-4", null, TestLinkAPIResults.TEST_FAILED);
			  }	       
		    }
	
         
         @Test(alwaysRun = true)
	     public void vehiclesaddButtonPopupTest_005() throws Exception{
		    try {
		 	     
		    	//To verify add button popup window
		    		
		    	vcpobj.ADDOBJECTS_BUTTON.click();
		    	BrowserUtilities.getWindowHandles();
		    	
		    	String VehicleTypeDropdownarr[] = {"---------", "VAN", "HGV", "LGV", "BUS", "PSV", "CAR", "Small Passenger"};
		    	
		    	vcpobj.VEHICLETYPE_DROPDOWN.isDisplayed();
		    	
				vcpobj.VEHICLETYPE_DROPDOWN.click();
				
				Select VehicleTypeDropDown = new Select(vcpobj.VEHICLETYPE_DROPDOWN);
				
				List<WebElement> VehicleTypeDropDownList = VehicleTypeDropDown.getOptions();
				
				for(int i=0; i<VehicleTypeDropDownList.size(); i++)
				{
			    System.out.println("Display Text : " + VehicleTypeDropDownList.get(i).getText());
	            Assert.assertEquals(VehicleTypeDropdownarr[i],VehicleTypeDropDownList.get(i).getText(),"Verify Vehicle type drop down");
				}
				 
				vcpobj.VEHICLETYPE_DROPDOWN.click();
				vcpobj.VEHICLEREGISTRATION_TEXTBOX.isDisplayed();
				vcpobj.ATTACHTRAILER_CHECKBOX.isDisplayed();
				vcpobj.GROUP_DROPDOWN.isDisplayed();
				vcpobj.ACTIVE_CHECKBOX.isDisplayed();
				vcpobj.MANAGEVEHICLEPOPUP_REMOVEBUTTON.isDisplayed();
			    
				String DueDatesarr[] = {"Annual Test Date:", "Tax Due Date:", "Service Due Date:", "Insurance Due Date:"};
				
				for(int i=0; i<vcpobj.DUEDATES_CALENDER_LIST.size(); i++){
			    System.out.println("Display Text : " + vcpobj.DUEDATES_CALENDER_LIST.get(i).getText());
	            Assert.assertEquals(DueDatesarr[i],vcpobj.DUEDATES_CALENDER_LIST.get(i).getText(),"Duedates calander list verify ");
				}
				
		     System.out.println("Due dates and calender dates are similar to Expected Elements");	
	        
		     vcpobj.MANAGEVEHICLEPOPUP_ADDBUTTON.isDisplayed();
			
		     vcpobj.MANAGEVEHICLEPOPUP_ADDBUTTON.isDisplayed();
		    Assert.assertEquals(vcpobj.getManageVehiclepopupAddButtonColor(),ExpectedBlue,"Manage Vehicle popup add button verify");
		    
		    vcpobj.MANAGEVEHICLEPOPUP_SUBMITBUTTON.isDisplayed();
		    Assert.assertEquals(vcpobj.getManageVehiclepopupSubmitButtonColor(),ExpectedLightGreen,"Manage Vehicle popup submit button verify");
		    
		    vcpobj.MANAGEVEHICLEPOPUP_CANCELBUTTON.isDisplayed();
		    Assert.assertEquals(vcpobj.getManageVehiclepopupCancelButtonColor(),ExpectedLightRed,"Manage Vehicle popup cancel button verify");
		    	
		   
				System.out.println("All elements verified => Assertion for Step5 PASS");
				LogUtilities.info("All elements verified :Test step5 passed");
				
			TestLinkIntegration.updateResult("VLC-5", null, TestLinkAPIResults.TEST_PASSED);    	
			
		    } catch (Exception e) {
				System.out.println("Test Failed");
			 TestLinkIntegration.updateResult("VLC-5", null, TestLinkAPIResults.TEST_FAILED);
			  }	       
		    }
		
         //6th test not done
         
         @Test(alwaysRun = true)
	     public void vehiclesaddButtonPopupTest_007() throws Exception{
		    try {
	
		    	vcpobj.MANAGEVEHICLEPOPUP_REMOVEBUTTON.click();
		    	BrowserUtilities.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	
				String without_data =CommonActionUtil.getAlertText();
				
                Assert.assertEquals(without_data, "Form cannot have less than one element!","Alert without data verify");
				CommonActionUtil.acceptAlert();
					
				System.out.println("All elements verified => Assertion for Step7 PASS");
				LogUtilities.info("All elements verified :Test step7 passed");
				TestLinkIntegration.updateResult("VLC-9", null, TestLinkAPIResults.TEST_PASSED);    	
			   } catch (Exception e) {
				System.out.println("Test Failed");
				TestLinkIntegration.updateResult("VLC-9", null, TestLinkAPIResults.TEST_PASSED);
			  }	       
		    }
         

         @Test(alwaysRun = true)
	     public void vehiclesaddButtonPopupTest_008() throws Exception{
		    try {
	
		    	vcpobj.VEHICLEREGISTRATION_TEXTBOX.sendKeys("Register");
		    	
		    	vcpobj.MANAGEVEHICLEPOPUP_REMOVEBUTTON.click();
		    	CommonActionUtil.implicitWait();
		    
				String with_data =CommonActionUtil.getAlertText();
				Assert.assertEquals(with_data, "Form cannot have less than one element!","Alert with data verify");
				CommonActionUtil.acceptAlert();
					
				System.out.println("All elements verified => Assertion for Step8 PASS");
				LogUtilities.info("All elements verified :Test step8 passed");
				TestLinkIntegration.updateResult("VLC-10", null, TestLinkAPIResults.TEST_PASSED);    	
			   } catch (Exception e) {
				System.out.println("Test Failed");
			    TestLinkIntegration.updateResult("VLC-10", null, TestLinkAPIResults.TEST_PASSED);
			  }	       
		    }
         
         
         
         @AfterMethod
         public void captureTest(){
         ScreenshotUtilities.captureScreenShot();
         }
         
	    @AfterTest
	    public void crash() throws IOException, ATUTestRecorderException
	    {
		  BrowserUtilities.closeBrowser();
		  recorder.stop();
	      }

}
