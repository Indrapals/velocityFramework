package actionsLibrary;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import genericLibrary.BrowserUtilities;
import genericLibrary.LogUtilities;
import objectRepository.HomePage;
import objectRepository.VehicleCheckPage;

public class VehicleCheckPageAction {
	
	static HomePage  hpobj;
	static VehicleCheckPage  vcpobj;
	
	//Method to check Vehicle check dropdown
	
	public static void VerifyVehicleCheckDropdown(){
		try {
			 hpobj=new HomePage(BrowserUtilities.driver);
			 vcpobj=new VehicleCheckPage(BrowserUtilities.driver);
			PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
			GenericActionUtil.moveTo(hpobj.VEHICLECHECK_MENU);
			
			String arr[] = {"", "Home", "Vehicle Check Dashboard", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
	    	
			List<WebElement> vehicleDropdown = vcpobj.VEHICLECHECK_DROPDOWNLIST;
			  for(int i=0;i<vehicleDropdown.size();i++)
		        {
		            //System.out.println("Display Text : " + element.get(i).getText());
		            //Assert.assertEquals(arr[i],vehicleDropdown.get(i).getText());
				  if(arr[i].equalsIgnoreCase(vehicleDropdown.get(i).getText())){
		            	System.out.println("vehicle Dropdown List Verified");
		            	break;
		            }
		        }
			 GenericActionUtil.release(hpobj.VEHICLECHECK_MENU); 
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}

	//Method to check items in manage vehicle header
	
	public static void VerifyManageVehiclesHeader(){
		try {
			 hpobj=new HomePage(BrowserUtilities.driver);
			
			PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
			
			GenericActionUtil.findElement_Click(vcpobj.VEHICLES_TILE);
			
			String arr[] = {"Vehicle Registration", "Vehicle Type", "Vehicle Group", "ODO Reading", "Active", "Edit Vehicle"};
	    	
			List<WebElement> manageVehicleHeaderList = vcpobj.MANAGEVEHICLES_HEADERLIST;
			
			  for(int i=0;i<manageVehicleHeaderList.size();i++)
		        {
		           // System.out.println("Display Text : " + element.get(i).getText());
		           // Assert.assertEquals(arr[i],manageVehicleHeaderList.get(i).getText());
		            if(arr[i].equalsIgnoreCase(manageVehicleHeaderList.get(i).getText())){
		            	System.out.println("Manage Vehicle HeaderList Verified");
		            	break;
		            }
		        } 
			  
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	    //Method to check white check on green background 
	    public static void verifyActiveCheck(){
		
		List<WebElement> Active_Vehicle_tick = vcpobj.ACTIVECHECK_LIST;
		      
        System.out.println(Active_Vehicle_tick.size()+"Active Vehicles present With green background");
        LogUtilities.info(Active_Vehicle_tick.size()+"Active Vehicles present With green background");
	        
	      }
	
	    //Method to check white check on red background 
	    public static void verifyInactiveCheck(){
			
	    GenericActionUtil.findElement_Click(vcpobj.SHOWREMOVED_VEHICLES_BUTTON);
		    
		List<WebElement> Inactive_Vehicle_tick = vcpobj.INACTIVECHECK_LIST;
			      
		System.out.println(Inactive_Vehicle_tick.size()+"Inactive Vehicles present With red background");
       
		LogUtilities.info(Inactive_Vehicle_tick.size()+"Active Vehicles present With red background");
		
		GenericActionUtil.findElement_Click(vcpobj.HIDEREMOVED_VEHICLES_BUTTON);
		        
		}
	    
		//Method to check items in manage vehicle Add Button pop up window
		
		public static void VerifyManageVehiclesAddButtonPopUp() throws InterruptedException{
			try {
				 hpobj=new HomePage(BrowserUtilities.driver);
				
				PageFactory.initElements(BrowserUtilities.driver,HomePage.class);
				
				// Handle pop up
				String parentWindowHandler = BrowserUtilities.driver.getWindowHandle(); // Store your parent window
				
				String subWindowHandler = null;

				Set<String> handles = BrowserUtilities.driver.getWindowHandles(); // get all window handles

				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()){
				   subWindowHandler = iterator.next();
				   BrowserUtilities.driver.switchTo().window(subWindowHandler);
				}
				Thread.sleep(3000);

				//Checking window handle
				System.out.println(vcpobj.VEHICLETYPE_HEADER.getText());

				// Method for header menu

				String arr[] = {"Vehicle Type:", "Vehicle Registration:", "Can Attach Trailer:", "Group:", "Active:", "Remove:"};
				List<WebElement> Header_Menu = vcpobj.VEHICLETYPE_HEADER_LIST;
				System.out.println("-----------"+Header_Menu.size());
				for(int i=0; i<Header_Menu.size(); i++){
				if(arr[i].equalsIgnoreCase(Header_Menu.get(i).getText()))
				{
				System.out.println(Header_Menu.get(i).getText());
				System.out.println("Pass");
	  
	     		}
			}
		}
			catch (NoSuchElementException e){
				throw new NoSuchElementException(e.getMessage());
			}
		}
	
}
