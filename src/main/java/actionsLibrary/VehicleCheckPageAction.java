package actionsLibrary;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import genericLibrary.BrowserUtilities;
import objectRepository.HomePage;
import objectRepository.VehicleCheckPage;

public class VehicleCheckPageAction {
	
	static HomePage  hpobj;
	
	
	public static void VerifyVehicleCheckDropdown(){
		try {
			 hpobj=new HomePage(BrowserUtilities.driver);
			
			PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
			GenericActionUtil.moveTo(hpobj.VEHICLECHECK_MENU);
			
			String arr[] = {"", "Home", "Vehicle Check Dashboard", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
	    	
			List<WebElement> element = BrowserUtilities.driver.findElements(By.xpath("//section[@class='top-bar-section']/ul/li/a[contains(.,'Vehicle Check')]//following-sibling::ul/li"));
			  for(int i=0;i<element.size();i++)
		        {
		            //System.out.println("Display Text : " + element.get(i).getText());
		            Assert.assertEquals(arr[i],element.get(i).getText());
		            
		        }
			 GenericActionUtil.release(hpobj.VEHICLECHECK_MENU); 
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}

}
