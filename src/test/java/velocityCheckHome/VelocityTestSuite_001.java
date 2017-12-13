package velocityCheckHome;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionsLibrary.GenericActionUtil;
import actionsLibrary.VehicleCheckPageAction;
import genericLibrary.BrowserUtilities;
import genericLibrary.Log;
import genericLibrary.TestLinkIntegration;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.VehicleCheckPage;
import testlink.api.java.client.TestLinkAPIResults;

public class VelocityTestSuite_001 {

	LoginPage lpobj;
	HomePage hpobj;
	VehicleCheckPage vcpobj;
	Logger log;
	private String sTestCaseName;
	
	@BeforeTest
	public void launch() throws IOException{
		
		DOMConfigurator.configure("log4j.xml");
		
		BrowserUtilities.getBrowser();
		Log.info("Browser launched with url Successfully");
	}
	
	@Test(alwaysRun = true)
	public void vehicleCheckMenuTest_001() throws Exception{
		lpobj=new LoginPage(BrowserUtilities.driver);
		hpobj=new HomePage(BrowserUtilities.driver);
		
	    try {
	    	PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
	    	//Login user
	    	lpobj.login_User();
	    	
	    	Log.info("User login Successfully");
	    	
	    	//Verify Vehicle Check tile is displayed on Velocity Home Page
	    	Assert.assertTrue(hpobj.VEHICLECHECK_MENU.isDisplayed());
	    	
	    	//Verify elements in the Vehicle Check drop down menu 
	    	VehicleCheckPageAction.VerifyVehicleCheckDropdown();
	    
	    	System.out.println("Found all items in Vehicle check title successfully: => Assertion for Step1 PASS ");
	    	Log.info("Test step 1 passed Successfully");
	    	
	    	 TestLinkIntegration.updateResult("VLC-1", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			 TestLinkIntegration.updateResult("VLC-1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	
	
	  @Test
	public void vehicleCheckTileTest_002() throws Exception{
		lpobj=new LoginPage(BrowserUtilities.driver);
		hpobj=new HomePage(BrowserUtilities.driver);
		vcpobj=new VehicleCheckPage(BrowserUtilities.driver);
		
	    try {
	    	
	    	
	    	GenericActionUtil.moveTo(hpobj.VEHICLECHECK_TILE);
	    	hpobj.VEHICLECHECK_TILE.click();
	    	String ExpectedBlue="rgba(79, 184, 232, 1)";
	    	
	    	//Verify ManagementFleet tile color
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManagementFleetTileColor());
	    	
	    	//Verify ManagemeGroups tile color
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManageGroupsTileColor());
	    	
	    	//Verify REPORTS tile color
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getReportsTileColor());
	    	
	    	//Verify MANAGEQUESTION tile color
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getManageQuestionTileColor());
	    	
	    	//Verify DEFECTMANAGEMENT_TILE color
	    	Assert.assertEquals(ExpectedBlue, vcpobj.getDefectManagementTileColor());
	    	
	    	String ExpectedPurple="rgba(170, 54, 203, 1)";
	    	//Verify DUEDATES_TILE color
	    	
	    	Assert.assertEquals(ExpectedPurple, vcpobj.getDueDatesTileColor());
	    	
	    	//Verify VEHICLECHECKDASH_TILE color
	    	Assert.assertEquals(ExpectedPurple, vcpobj.getVechicleCheckDashboardTileColor());
	   	
	    	String ExpectedRed="rgba(219, 30, 124, 1)";
	    	
	    	//Verify ALERTS_TILE color
	    	Assert.assertEquals(ExpectedRed, vcpobj.getAlertTileColor());
	    	
	    	System.out.println("All Eight Tiles Found and verified with required color: => Assertion for Step2 PASS");
	    	Log.info("All tiles verified with their colors:Test step2 passed");
	    	
	    	 TestLinkIntegration.updateResult("VLC-2", null, TestLinkAPIResults.TEST_PASSED);    	
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			 TestLinkIntegration.updateResult("VLC-2", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	
	   
	     @Test
		public void manageFleetTileTest_003() throws Exception{
			vcpobj=new VehicleCheckPage(BrowserUtilities.driver);
			
		    try {
		    
		    	vcpobj.MANAGEFLEET_TILE.click();
		    	Assert.assertEquals("Manage Fleet", vcpobj.MANAGEFLEET_MENU.getText());
		    	
		        Assert.assertEquals("Vehicles", vcpobj.VEHICLES_TILE.getText());
		    
		        Assert.assertEquals("Drivers", vcpobj.DRIVERS_TILE.getText());
		        System.out.println("Manage Fleet title ,Vehicles tile and Drivers tile Displayed: => Assertion for Step3 PASS");
		        Log.info("All elements verified :Test step3 passed");
		        
		        TestLinkIntegration.updateResult("VLC-3", null, TestLinkAPIResults.TEST_PASSED);    	
			   } catch (Exception e) {
				System.out.println("Test Failed");	
				 TestLinkIntegration.updateResult("VLC-3", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }	       
		    }
		/*
	         @Test
			public void vehicleCheckTileTest_004() throws Exception{
			
	    	 vcpobj=new VehicleCheckPage(BrowserUtilities.driver);
				
			    try {
			    	
			    	
			    	vcpobj.VEHICLES_TILE.click();
			    	Assert.assertEquals("Manage Vehicles", vcpobj.MANAGEVEHICLES_MENU.getText());
			    	
			    	
			    	System.out.println("Manage Fleet title ,Vehicles tile and Drivers tile Displayed: => Assertion for Step3 PASS");
			    
			        
			    	 //TestLinkIntegration.updateResult("GR-1", null, TestLinkAPIResults.TEST_PASSED);    	
				   } catch (Exception e) {
					System.out.println("Test Failed");	
					// TestLinkIntegration.updateResult("GR-1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
				  }	       
			    }
		*/	
	@AfterTest
	public void crash() throws IOException{
		BrowserUtilities.closeBrowser();
	}

}
