package velocityTestScript;

import java.io.IOException;
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
import genericLibrary.BrowserUtilities;
import genericLibrary.LogUtilities;
import genericLibrary.ScreenshootUtilities;
import genericLibrary.TestLinkIntegration;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.VehicleCheckPage;
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
	
	
	
	  @BeforeTest
	  public void launch() throws IOException{
		
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
	    	//Login user
	    	lpobj.login_User();
	    	
	    	LogUtilities.info("User login Successfully");
	    	
	    	//Verify Vehicle Check tile is displayed on Velocity Home Page
	    	Assert.assertTrue(hpobj.VEHICLECHECK_MENU.isDisplayed());
	    	
	    	//Verify elements in the Vehicle Check drop down menu 
	    
            CommonActionUtil.moveTo(hpobj.VEHICLECHECK_MENU);
			
			String arr[] = {"", "Home", "Vehicle Check Dashboard", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
	    	
			for(int i=0;i<vcpobj.VEHICLECHECK_DROPDOWNLIST.size();i++)
	        {
	            System.out.println("Display Text : " + vcpobj.VEHICLECHECK_DROPDOWNLIST.get(i).getText());
	            Assert.assertEquals(arr[i],vcpobj.VEHICLECHECK_DROPDOWNLIST.get(i).getText());
			 
	        }
			 System.out.println("vehicle Dropdown List Verified");
		
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
	    	
	    	//Verify ManagementFleet with tile color
	    	vcpobj.MANAGEFLEET_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManagementFleetTileColor());
	    	
	    	//Verify ManagemeGroups tile color
	    	vcpobj.MANAGEGROUPS_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManageGroupsTileColor());
	    	
	    	//Verify REPORTS tile color
	    	vcpobj.REPORTS_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getReportsTileColor());
	    	
	    	//Verify MANAGEQUESTION tile color
	    	vcpobj.MANAGEQUESTION_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManageQuestionTileColor());
	    	
	    	//Verify DEFECTMANAGEMENT_TILE color
	    	vcpobj.DEFECTMANAGEMENT_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getDefectManagementTileColor());
	    	
	    	//Verify DUEDATES_TILE color
	    	vcpobj.DUEDATES_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedPurple, vcpobj.getDueDatesTileColor());
	    	
	    	//Verify VEHICLECHECKDASH_TILE color
	    	vcpobj.VEHICLECHECKDASH_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedPurple, vcpobj.getVechicleCheckDashboardTileColor());
	   	
	    	//Verify ALERTS_TILE color
	    	vcpobj.ALERTS_TILE.isDisplayed();
	    	Assert.assertEquals(ExpectedPink, vcpobj.getAlertTileColor());
	    	
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
	    	
	    	Assert.assertEquals("Manage Fleet", vcpobj.MANAGEFLEET_MENU.getText());
	    	
	        Assert.assertEquals("Vehicles", vcpobj.VEHICLES_TILE_TEXT.getText());
	    
	        Assert.assertEquals("Drivers", vcpobj.DRIVERS_TILE.getText());
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
		            Assert.assertEquals(vehicleHeaderListarr[i],vcpobj.MANAGEVEHICLES_HEADERLIST.get(i).getText());
				 
		        }
				 System.out.println("Manage Vehicle HeaderList Verified");
				
				  //Verify Active check
				 for (WebElement element : vcpobj.ACTIVECHECK_LIST) {
		    	      Assert.assertTrue(element.isDisplayed());
		    	    }
				 System.out.println("Active Vehicles present With green background");
				 
				 
		    	//Verify ShowRemoved vehicles ,Add and Edit button
				 vcpobj.ADDOBJECTS_BUTTON.isDisplayed();
				 vcpobj.EDITOBJECTS_BUTTON.isDisplayed();
				 vcpobj.SHOWREMOVED_VEHICLES_BUTTON.isDisplayed();
				 
		    	System.out.println("Add,Edit and Show removed button verified");	
		    	
		    	//Verify Inactive check
		    	 
		    	 vcpobj.SHOWREMOVED_VEHICLES_BUTTON.click();
		    	 for (WebElement element : vcpobj.INACTIVECHECK_LIST) {
		    	     Assert.assertTrue(element.isDisplayed());
		    	    }
		    	 System.out.println("Inactive Vehicles present With red background");
		    	
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
				
				for(int i=0; i<VehicleTypeDropDownList.size(); i++){
					 System.out.println("Display Text : " + VehicleTypeDropDownList.get(i).getText());
			            Assert.assertEquals(VehicleTypeDropdownarr[i],VehicleTypeDropDownList.get(i).getText());
				}
				System.out.println("Dropdown list verified");
			     
				vcpobj.VEHICLETYPE_DROPDOWN.click();
				vcpobj.VEHICLEREGISTRATION_TEXTBOX.isDisplayed();
				vcpobj.ATTACHTRAILER_CHECKBOX.isDisplayed();
				vcpobj.GROUP_DROPDOWN.isDisplayed();
				vcpobj.ACTIVE_CHECKBOX.isDisplayed();
				vcpobj.MANAGEVEHICLEPOPUP_REMOVEBUTTON.isDisplayed();
			    
				String DueDatesarr[] = {"Annual Test Date:", "Tax Due Date:", "Service Due Date:", "Insurance Due Date:"};
				
				for(int i=0; i<vcpobj.DUEDATES_CALENDER_LIST.size(); i++){
					 System.out.println("Display Text : " + vcpobj.DUEDATES_CALENDER_LIST.get(i).getText());
			            Assert.assertEquals(DueDatesarr[i],vcpobj.DUEDATES_CALENDER_LIST.get(i).getText());
				}
				
		     System.out.println("Due dates and calender dates are similar to Expected Elements");	
	        
		     vcpobj.MANAGEVEHICLEPOPUP_ADDBUTTON.isDisplayed();
				
		   //Verify Manage Vehcile Popup Add button color
		     vcpobj.MANAGEVEHICLEPOPUP_ADDBUTTON.isDisplayed();
		    Assert.assertEquals(ExpectedBlue, vcpobj.getManageVehiclepopupAddButtonColor());
		    
		  //Verify Manage Vehcile Popup Submit button color
		    vcpobj.MANAGEVEHICLEPOPUP_SUBMITBUTTON.isDisplayed();
		    Assert.assertEquals(ExpectedLightGreen, vcpobj.getManageVehiclepopupSubmitButtonColor());
		    
		  //Verify Manage Vehcile Popup Cancel button color
		    vcpobj.MANAGEVEHICLEPOPUP_CANCELBUTTON.isDisplayed();
		    Assert.assertEquals(ExpectedLightRed, vcpobj.getManageVehiclepopupCancelButtonColor());
		    	
		   
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
				
                Assert.assertEquals(without_data, "Form cannot have less than one element!");
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
				Assert.assertEquals(with_data, "Form cannot have less than one element!");
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
          ScreenshootUtilities.captureScreenShot();
         }
         
	    @AfterTest
	    public void crash() throws IOException
	    {
		  BrowserUtilities.closeBrowser();
	      }

}
