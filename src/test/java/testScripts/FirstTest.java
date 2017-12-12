package testScripts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import actionsLibrary.GenericActionUtil;
import genericLibrary.BrowserUtilities;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class FirstTest {

	LoginPage lpobj;
	HomePage  hpobj;
	
	@BeforeTest
	public void launch() throws IOException{
		BrowserUtilities.getBrowser();
	}
	
	
	@Test
	public void firstTest() throws Exception{
		
		lpobj=new LoginPage(BrowserUtilities.driver);
		hpobj=new HomePage(BrowserUtilities.driver);
		PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
	    try {
	    	
	    	lpobj.login_User();
	    	Assert.assertTrue(hpobj.VEHICLECHECK_TITLE.isDisplayed());
	    	
	    	
		 
		} catch (Exception e) {
			System.out.println("Test Failed");
			
		}
	
        
	}
	
	@AfterTest
	public void crash() throws IOException{
		BrowserUtilities.closeBrowser();
	}
}
