package velocityMapTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import actionsLibrary.CommonActionUtil;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericLibrary.BrowserUtilities;
import genericLibrary.LogUtilities;
import genericLibrary.ScreenshotUtilities;
import genericLibrary.TestLinkIntegration;
import pageObjects.HomePage;
import pageObjects.LivemapPage;
import pageObjects.LoginPage;
import pageObjects.VehicleCheckPage;
import testlink.api.java.client.TestLinkAPIResults;

public class VelocityLiveMapTest {
	
	HomePage hpobj;
	LoginPage lpobj;
	LivemapPage lmpobj;
	static int count=0;
	static int countblue=0;
	static String ExpectedBlue="rgba(79, 184, 232, 1)";
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
		BrowserUtilities.driver.findElement(By.xpath("//a[contains(text(),'I agree')]")).click();
	}
	
	  @BeforeMethod
	  public void laodPages(){
		
		  hpobj=PageFactory.initElements(BrowserUtilities.driver, HomePage.class);
		  lpobj= PageFactory.initElements(BrowserUtilities.driver, LoginPage.class);
		  lmpobj=PageFactory.initElements(BrowserUtilities.driver, LivemapPage.class); 
	  }
	
	  @Test(alwaysRun = true)
	  public void liveMapTest_020() throws Exception{
		
	    try {
	    	
	    	lpobj.login_User();
	    	
	    	LogUtilities.info("User login Successfully");
	    	
	    	Assert.assertTrue(hpobj.VEHICLECHECK_MENU.isDisplayed(),"Vehicle menu displayed");
	    
            CommonActionUtil.moveTo(hpobj.KINESISTELEMATICS_MENU);
            
            lmpobj.LIVEMAP_MODULE.click();
        
            lmpobj.MAP_CANVAS.isDisplayed();
            
            System.out.println("No of Independent vehicle present on screen :  " + lmpobj.INDEPENDENT_VEHICLE_LIST.size());
            
            System.out.println("No of Parked vehicle present on screen :  " + lmpobj.PARKEDVEHICLE_LIST.size()/4);
            
            System.out.println("No of Parked vehicle present on screen :  " + lmpobj.MOVINGVEHICLE_LIST.size()/4);
            
            System.out.println("No of vehicle clusters present on screen :  " + lmpobj.VEHICLECLUSTER_LIST.size());
            
            for(WebElement element:lmpobj.VEHICLECLUSTER_LIST){
            	System.out.println("Clusters contain no vehicles "+element.getText());
            }
            
            for(int i=0;i<lmpobj.INDEPENDENT_VEHICLE_LIST.size();i++){
            	if(lmpobj.INDEPENDENT_VEHICLE_LIST.get(i).getCssValue("background-color").equals("rgba(40, 142, 205, 1)")){
               		countblue++;
               		System.out.println("Numbers of Independent vehicles with blue color are : " + countblue);
               	}
               	else{
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
	  public void liveMapTest_021() throws Exception{
		
	    try {
	    	lmpobj.OPTIONS_BUTTON.click();
	    	Assert.assertTrue(lmpobj.VEHICLEDISPLAY_TEXTBOX.isDisplayed(), "Vehicle Display text box is displayed");
	    	Assert.assertTrue(lmpobj.VEHICLEREGISTRATION_TEXTBOX.isDisplayed(), "Vehicle Registration text box is displayed");
	    	Assert.assertTrue(lmpobj.DRIVERNAME_TEXTBOX.isDisplayed(), "Driver Name text box is displayed");
	    	Assert.assertTrue(lmpobj.VEHICLEDISPLAY_TEXTBOX.isDisplayed(), "Vehicle Display text box is displayed");
	    	Assert.assertTrue(lmpobj.MAPSTYLE_TEXTBOX.isDisplayed(), "May style text box is displayed");
	    	Assert.assertTrue(lmpobj.STANDARD_TEXTBOX.isDisplayed(), "Standard text box is displayed");
	    	Assert.assertTrue(lmpobj.SATELLITE_TEXTBOX.isDisplayed(), "Satellite text box is displayed");	    	
	    	Assert.assertTrue(lmpobj.TRAFFIC_TEXTBOX.isDisplayed(), "Traffic text box is displayed");
	    	Assert.assertTrue(lmpobj.POINTSOFINTEREST_TEXTBOX.isDisplayed(), "Point of interest text box is displayed");
	    	
	    	
			System.out.println("Verified test successfully: => Assertion for Step 21 PASS ");
			TestLinkIntegration.updateResult("VLC-21", null, TestLinkAPIResults.TEST_PASSED);
	  
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-21", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }

	  @Test(alwaysRun = true)
	  public void liveMapTest_022() throws Exception{
		
	    try {
	    	
	    	lmpobj.DRIVERNAME_CHECKBOX.click();
	    	for(WebElement element:lmpobj.INDEPENDENT_VEHICLE_LIST_WITH_DRIVERNAME){
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
	  public void liveMapTest_023() throws Exception{
		
	    try {
	    	
	    	lmpobj.SATELLITE_CHECKBOX.click();
	    	Screen screen = new Screen();
	    	Pattern SatelliteImage = new Pattern("D:\\Sikuli.sikuli\\1514292511154.png");
	    	if(screen.exists(SatelliteImage) != null){
	    		System.out.println("Satellite view verified");
	    		lmpobj.STANDARD_CHECKBOX.click();
	    	}
	    	
			System.out.println("Verified test successfully: => Assertion for Step 23 PASS ");
			TestLinkIntegration.updateResult("VLC-23", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-23", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	  
	  
	  @Test(alwaysRun = true)
	  public void liveMapTest_024() throws Exception{
		
	    try {
	    	
	    	lmpobj.TRAFFIC_CHECKBOX.click();
	    	Screen screen = new Screen();
	    	Pattern SatelliteImage = new Pattern("D:\\Sikuli.sikuli\\1514292696619.png");
	    	if(screen.exists(SatelliteImage) != null){
	    		System.out.println("Traffic view verified");
	    		lmpobj.TRAFFIC_CHECKBOX.click();
	    		lmpobj.RESTMAP_BUTTON.click();
	    	}
	    	
			System.out.println("Verified test successfully: => Assertion for Step 24 PASS ");
			TestLinkIntegration.updateResult("VLC-24", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-24", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	  
	  @Test(alwaysRun = true)
	  public void liveMapTest_025() throws Exception{
	    try {
	    	
	    	lmpobj.POINTSOFINTEREST_CHECKBOX.click();
	    	Screen screen = new Screen();
	    	Pattern SatelliteImage = new Pattern("D:\\Sikuli.sikuli\\1514351111559.png");
	    	if(screen.exists(SatelliteImage) != null){
	    	System.out.println("POI view verified");
	    	
	    	lmpobj.POINTSOFINTEREST_CHECKBOX.click();
	    	lmpobj.RESTMAP_BUTTON.click();
	    	lmpobj.OPTIONS_CLOSE_BUTTON.click();
	    	}
	    	
			System.out.println("Verified test successfully: => Assertion for Step 25 PASS ");
			TestLinkIntegration.updateResult("VLC-25", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-25", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	 
	  @Test(alwaysRun = true)
	  public void liveMapTest_026() throws Exception{
	    try {
	    	
	    	lmpobj.SUMMARY_BUTTON.click();
	    	Assert.assertTrue(lmpobj.VEHICLE_SERVICE_TABLE.isDisplayed(), "Vehicle Service DropDown list displayed");
	    	lmpobj.SERVICESUMMARY_CLOSE_BUTTON.click();
	    	
			System.out.println("Verified test successfully: => Assertion for Step 26 PASS ");
			TestLinkIntegration.updateResult("VLC-26", null, TestLinkAPIResults.TEST_PASSED);
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-26", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		  }	       
	    }
	  
	  @Test(alwaysRun = true)
	  public void liveMapTest_027() throws Exception{
	    try {
	    	
	    	lmpobj.SUMMARY_BUTTON.click();
	   
   		
	    	lmpobj.SUMMARY_GROUP_BUTTON.click();
	    	
	    	
	    	for(WebElement element:lmpobj.VEHICLE_GROUP_NAME_LIST){
		    Assert.assertTrue(element.isDisplayed(), "Groups list's names are displayed");
			    }
	    	
	    	for(WebElement element:lmpobj.VEHICLE_GROUP_CHECKBOX_LIST){
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
	    public void liveMapTest_028() throws Exception{
	    try {
	    	
	    	lmpobj.VEHICLE_GROUP_CHECKBOX_LIST.get(1).click();
	        lmpobj.VEHICLE_GROUP_GO_BUTTON.click();
	        
	        List<String> lstSelectedItem=new ArrayList<String>();
	        for(int i=0;i<lmpobj.SELECTED_DRIVER_GROUP_LIST.size();i++){
	            lstSelectedItem.add(lmpobj.SELECTED_DRIVER_GROUP_LIST.get(i).getText());
	        }
	        
	        List<String> lstMovedItem=new ArrayList<String>();
	        for(int i=0;i<lmpobj.INDEPENDENT_VEHICLE_LIST.size();i++){
	           lstMovedItem.add(lmpobj.INDEPENDENT_VEHICLE_LIST.get(i).getText());
	        }
	        
	        Collections.sort(lstSelectedItem);
	        Collections.sort(lstMovedItem);

	        //verify the lists are equal
	        Assert.assertEquals(lstSelectedItem, lstMovedItem);
	        
	    	System.out.println("Verified test successfully: => Assertion for Step 28 PASS ");
			TestLinkIntegration.updateResult("VLC-28", null, TestLinkAPIResults.TEST_PASSED);
	  
		   } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-28", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
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
