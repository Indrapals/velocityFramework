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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionsLibrary.AndroidAction;
import actionsLibrary.CommonActionUtil;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import genericLibrary.AppiumServer;
import genericLibrary.ApplicationSetup;
import genericLibrary.BrowserUtilities;
import genericLibrary.ScreenshotUtilities;
import genericLibrary.TestLinkIntegration;
import io.appium.java_client.MobileElement;
import pageObjects.AndroidAppPage;
import pageObjects.HomePage;
import pageObjects.LivemapPage;
import pageObjects.LoginPage;
import pageObjects.VehicleCheckPage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class velocityAppTest  extends BrowserUtilities{

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
		//Provide path to store videos and file name format.
		  recorder = new ATUTestRecorder("C:\\Users\\Ranosys\\workspace\\velocity\\ScriptVideos\\","TestVideo-"+dateFormat.format(date),false);
		  //To start video recording.
		  recorder.start(); 
		 AppiumServer.startServer();		    
	     ApplicationSetup.setCapability();
	}
	
	
	@BeforeMethod
	 public void setUp() throws ExecuteException, IOException {
	  
	 
     appobj=PageFactory.initElements(ApplicationSetup.driver, AndroidAppPage.class);
     lpobj= PageFactory.initElements(driver, LoginPage.class);
	  hpobj=PageFactory.initElements(driver, HomePage.class);
	  vcpobj=PageFactory.initElements(driver, VehicleCheckPage.class); 
     
          }
	
	 
	
		@Test(enabled = true)
	    public void vehicleAppTest_011() throws TestLinkAPIException 
	    {
	      try {
			appobj.login_InactiveUser_Without_Code();
			String ExpectedMessage="Please enter the secret code associated with your account";
	          Assert.assertEquals(ExpectedMessage,appobj.MESSAGE_POPUP.getText());
	          TestLinkIntegration.updateResult("VLC-11", null, TestLinkAPIResults.TEST_PASSED);  
			  } catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-11", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
      }
	    
		   
	   @Test(enabled = true)
	    public void vehicleAppTest_012() throws TestLinkAPIException 
	    {
    	   try {
			 appobj.login_InactiveUser_With_Code();
			 String ExpectedMessage="Driver not found.";
	          Assert.assertEquals(ExpectedMessage,appobj.MESSAGE_POPUP.getText());
	          
	          TestLinkIntegration.updateResult("VLC-12", null, TestLinkAPIResults.TEST_PASSED); 
	          
	          }
    	   catch (Exception e) {
			System.out.println("Test Failed");
			TestLinkIntegration.updateResult("VLC-12", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
    	   }		 	  
        }
	
      
	   @Test(enabled = true)
	    public void vehicleAppTest_013() throws TestLinkAPIException 
	    {
   	   try {
			 appobj.login_ActiveUser_With_IncorrectCode();
			 String ExpectedMessage="Driver not found.";
	          Assert.assertEquals(ExpectedMessage,appobj.MESSAGE_POPUP.getText());
	          TestLinkIntegration.updateResult("VLC-13", null, TestLinkAPIResults.TEST_PASSED); 
	          }
   	   catch (Exception e) {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-13", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
   	   }		 	  
       }
        
         
        @Test(enabled = true)
	    public void vehicleAppTest_014() throws TestLinkAPIException 
	    {
  	      try { 
  	   
  
  		      appobj.login_ActiveUser_With_CorrectCode();
  		      Assert.assertTrue(appobj.NAVBACK_BUTTON.isDisplayed(), "Exit Icon is displayed");
  		      Assert.assertTrue(appobj.BELL_ICON.isDisplayed(), "Bell Icon is displayed");
  		      Assert.assertTrue(appobj.TITLE_VEHICLE_CHECK.isDisplayed(), "Vehicle check title is displayed");
  		      Assert.assertTrue(appobj.COMPANY_NAME.isDisplayed(), "Account you logged in is displayed");
  		      Assert.assertTrue(appobj.VEHICLE_SELECT_DROPDOWN.isDisplayed(), "Vehicle dropdown list is displayed");
  		      Assert.assertTrue(appobj.REFRESH_ICON.isDisplayed(), "Refresh icon is displayed");
  		      Assert.assertTrue(appobj.REMEMBERCHOICE_CHECKBOX_CHECKED.isDisplayed(), "Remember checkbox is displayed");
  		      Assert.assertTrue(appobj.USEWIFI_CHECKBOX_UNCHECKED.isDisplayed(), "Wifi checkbox is displayed");
  		      Assert.assertTrue(appobj.VEHICLECHECK_SUBMITBUTTON.isDisplayed(), "Submit button is displayed");
  		      Assert.assertTrue(appobj.PREVIOUS_VEHICLECHECK_BUTTON.isDisplayed(), "Previous check button is displayed");
  		      
  		    TestLinkIntegration.updateResult("VLC-14", null, TestLinkAPIResults.TEST_PASSED); 
		       }
  	      catch (Exception e)
  	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-14", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
        }
     
      
	   @Test(enabled = true)
	    public void vehicleAppTest_015() throws TestLinkAPIException 
	    {
 	      try { 
 	   	   	  appobj.VEHICLE_SELECT_DROPDOWN.click();
 	   	     List<MobileElement> list1=  ApplicationSetup.driver.findElements(By.id("item_name"));
 		 
		   for(WebElement element: list1){
 			   String text=element.getText();
 			   System.out.println(text);
 			  allElementsText.add(text);
 			 
 		   }
		   size = ApplicationSetup.driver.manage().window().getSize();
		   System.out.println(size);
		    int height=size.getHeight();
		    int weight=size.getWidth();
		    int x=weight/2;
		    int starty = (int)(height * 0.60);
		    int endy = (int)(height * 0.38);
		    ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
	  
 		 
 		 List<MobileElement> list2=  ApplicationSetup.driver.findElements(By.id("item_name"));
 		 
		   for(WebElement element: list2){
			   String text=element.getText();
			   System.out.println(text);
			  allElementsText.add(text);
			 
		   }
		  
		   ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
		
		   List<MobileElement> list3=  ApplicationSetup.driver.findElements(By.id("item_name"));
	 		 
		   for(WebElement element: list3){
			   String text=element.getText();
			   System.out.println(text);
			  allElementsText.add(text);
			 
		   }
		   
		   ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
		   
		    List<MobileElement> list4=  ApplicationSetup.driver.findElements(By.id("item_name"));
	 		 
		   for(WebElement element: list4){
			   String text=element.getText();
			   System.out.println(text);
			  allElementsText.add(text);
			 
		   }
		   
		   ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
		    List<MobileElement> list5=  ApplicationSetup.driver.findElements(By.id("item_name"));
	 		 
			   for(WebElement element: list5){
				   String text=element.getText();
				   System.out.println(text);
				  allElementsText.add(text);
				 
			   }
			 
			   ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
				  
		 		 
		 		 List<MobileElement> list6=  ApplicationSetup.driver.findElements(By.id("item_name"));
		 		 
				   for(WebElement element: list6){
					   String text=element.getText();
					   System.out.println(text);
					  allElementsText.add(text);
					 
				   }
			   
     	   for(String s : allElementsText)
			{
				System.out.println("All elements:"+s);
			}
     	  List<String> allElementsTextApp = new ArrayList<String>(allElementsText);
   	    
 	     int ElementsCount = allElementsText.size();
			if(ElementsCount == 13)
			{
				System.out.println("List of elements are equal ");
			}
			
 	   	   	BrowserUtilities.getBrowser();
 	   	    driver.findElement(By.xpath("//a[contains(text(),'I agree')]")).click();
 	   		driver.findElement(By.xpath("//input[@value='Login']")).click();
 	   	    	driver.findElement(By.id("id_username")).sendKeys("anand.ramdeo@ranosys.com");
 				driver.findElement(By.id("id_password")).sendKeys("Wednesday1350");
 				driver.findElement(By.xpath("//input[@value='Login']")).click();
 				Thread.sleep(300);
 				driver.findElement(By.xpath("//img[@alt='Vehicle Check']")).click();
 				Thread.sleep(200);
 				driver.findElement(By.id("vehicle-check-manage-fleet")).click();
 				driver.findElement(By.xpath("//a[@href='/vehicle-check/manage-vehicles/']")).click();
 				
 				List<WebElement> lst=driver.findElements(By.xpath("//td[contains(@class,'vehicle-reg sorting')]"));
 				System.out.println(lst.size());
 			
 				Thread.sleep(100);
 				JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
 				js.executeScript("window.scrollBy(0,400)", "");
 		        for(WebElement element:lst){
 		        	
 		           System.out.println(element.getText());
 		          String text=element.getText();
				
				   allWebElementsText.add(text);
				   
 		        }
 		       List<String> allElementsTextWeb = new ArrayList<String>(allWebElementsText);
 		      Collections.sort(allElementsTextApp);
 		     Collections.sort(allElementsTextWeb);
			BrowserUtilities.closeBrowser();
		
	    Assert.assertEquals(allElementsTextApp, allElementsTextWeb,"Verified both the list of active vehicles");
	   
	    TestLinkIntegration.updateResult("VLC-15", null, TestLinkAPIResults.TEST_PASSED); 
 	     }catch (Exception e)
 	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-15", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
       }
	   
	 @Test(enabled = true)
	    public void vehicleAppTest_016() throws TestLinkAPIException 
	    {
	      try { 
	    	 
	    	 appobj.NAVBACK_BUTTON.click();
	    	 appobj.LOGIN_BUTTON.click();
	    	 appobj.VEHICLECHECK_SUBMITBUTTON.click();
	    	 String ExpectedMessage="Vehicle not found.";
	          Assert.assertEquals(ExpectedMessage,appobj.MESSAGE_POPUP.getText());
	    	      TestLinkIntegration.updateResult("VLC-16", null, TestLinkAPIResults.TEST_PASSED); 
		       }
	      catch (Exception e)
	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-16", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
     }
       
	   @Test(enabled = true)
	    public void vehicleAppTest_017() throws TestLinkAPIException 
	    {
 	      try { 
 	    	
 	    	 appobj.OK_BUTTON.click();
 	    	AndroidAction.implicit_wait(200, TimeUnit.SECONDS);
 	    	  Thread.sleep(1000);
 	    	 appobj.VEHICLE_SELECT_DROPDOWN.click();
 	    	  size = ApplicationSetup.driver.manage().window().getSize();
 			   System.out.println(size);
 			    int height=size.getHeight();
 			    int weight=size.getWidth();
 			    int x=weight/2;
 			    int starty = (int)(height * 0.60);
 			    int endy = (int)(height * 0.37);
 			    for(int i=0;i<=2;i++){
 			    ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
 			    }
 	    	
 	   	     appobj.SELECT_HIREVAN1.click();
 	   	     appobj.SELECTVEHICLE_OK_BUTTON.click();
 	    	 appobj.VEHICLECHECK_SUBMITBUTTON.click();
 	    	 
 	    	 Assert.assertTrue(appobj.PLSESE_SELECT_TITLE.isDisplayed(), "Please select Icon is displayed");
 		      Assert.assertTrue(appobj.HOME_ICON.isDisplayed(), "Home Icon is displayed");
 		      Assert.assertTrue(appobj.VEHICLE_CHECK_ICON.isDisplayed(), "Vehicle check Icon is displayed");
 		      Assert.assertTrue(appobj.REPORT_INCIDENT_ICON.isDisplayed(), "Report an incident Icon is displayed");
 		     TestLinkIntegration.updateResult("VLC-17", null, TestLinkAPIResults.TEST_PASSED); 
 		     
		       }
 	      catch (Exception e)
 	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-17", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
       }
       
	  
	   
	   @Test(enabled = true)
	    public void vehicleAppTest_018() throws TestLinkAPIException 
	    {
	      try { 
	    	 
	    	 appobj.HOME_ICON.click();
	    	 Assert.assertTrue(appobj.TITLE_VEHICLE_CHECK.isDisplayed(), "Vehicle check home screen is displayed");
	    	   TestLinkIntegration.updateResult("VLC-18", null, TestLinkAPIResults.TEST_PASSED); 
		       }
	      catch (Exception e)
	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-18", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
     }
	   @Test(enabled = true)
	    public void vehicleAppTest_019() throws TestLinkAPIException 
	    {
	      try { 
	    	 
	    	  appobj.VEHICLE_SELECT_DROPDOWN.click();
	    	  size = ApplicationSetup.driver.manage().window().getSize();
			   System.out.println(size);
			    int height=size.getHeight();
			    int weight=size.getWidth();
			    int x=weight/2;
			    int starty = (int)(height * 0.60);
			    int endy = (int)(height * 0.37);
			    for(int i=0;i<=2;i++){
			    ApplicationSetup.driver.swipe(x, starty, x, endy, 500);
			    }
	 	 
	 	   	     appobj.SELECT_HIREVAN1.click();
	 	   	     appobj.SELECTVEHICLE_OK_BUTTON.click();
	 	    	 appobj.VEHICLECHECK_SUBMITBUTTON.click();
	 	         appobj.VEHICLE_CHECK_ICON.click();
	 	         appobj.INTERIOR_QUESTIONS_ICON.click();
	 	        Assert.assertTrue(appobj.INTERIOR_QUESTION_TEXT.isDisplayed(), "Interior question text is displayed");
	 	       TestLinkIntegration.updateResult("VLC-19", null, TestLinkAPIResults.TEST_PASSED); 
		       }
	      catch (Exception e)
	         {
			System.out.println("Test Failed");	
			TestLinkIntegration.updateResult("VLC-19", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			  }		 	  
     }
	   
	   
	  
	    @AfterMethod
        public void captureTest(){
        ScreenshotUtilities.captureAndroidScreenShot();
	      }
	      
	   
       @AfterTest
       public void endTest() throws ATUTestRecorderException
        {
	    ApplicationSetup.driver.quit();
	    recorder.stop();
	   
 	    }
       
}
