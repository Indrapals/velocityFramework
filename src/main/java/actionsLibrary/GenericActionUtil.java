package actionsLibrary;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibrary.*;



public class GenericActionUtil {

	/**
	 * @author Indrapal Singh
	 *Commonly used Webdriver actions perform on webelement  
	 */
	
	public final static int timeOut = 70;
	public final static int i=0;
	public final static int n=0;
	
	/**
	 * @author Indrapal Singh
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	public static WebElement findElement(WebElement element){
		try {
			
			return element;
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
		
	}
	
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	public static WebElement findElement_Click(WebElement element){
		try {
			
			element.click();
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
		return null;
	}
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	public static WebElement findElement_getText(WebElement element){
		try {
			
			System.out.println(element.getText());
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
		return null;
	}
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @Sendkeys to element if found else throws NoSuchElementException
	 */
	public static WebElement sendkeys(WebElement element,String value){
		try {
			
			element.sendKeys(value);
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
		return null;
	}
	
	/*
	 * method for implicit wait
	 */
	public static Object implicit_wait(int i,TimeUnit arg1){
		try {
			BrowserUtilities.driver.manage().timeouts().implicitlyWait(i, arg1);
				}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * method for Explicit wait
	 */
	public static void explicit_wait(By by){
		try {
			(new WebDriverWait(BrowserUtilities.driver, 30)).until(ExpectedConditions.elementToBeClickable(by));
			BrowserUtilities.driver.findElement(by).click();
			//BrowserUtilities.driver.manage().timeouts().implicitlyWait(i, arg1);
				}
		catch (StaleElementReferenceException  ser) {
			// TODO Auto-generated catch block
			BrowserUtilities.driver.findElement(by).click();
		}
		}
        
	
	/*
	 * method to navigate back
	 */
	public static Object back(){
		try {
			BrowserUtilities.driver.navigate().back();
				}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 *  method to find all the elements of specific locator
	 * @param locator element to be found
	 * @return return the list of elements if found else throws NoSuchElementException
	 */
	
	public static List<WebElement> findElements(By locator){
		try {
			List<WebElement> element = BrowserUtilities.driver.findElements(locator);
			return element;
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	/**
	 *  method to find all the elements of specific locator
	 * @param locator element to be found
	 * @return return the list of elements if found else throws NoSuchElementException
	 */
	
	public static void VerifyVehicleCheck(By locator){
		try {
			String[] expected = {"", "Home", "Vehicle Check Dashboard ", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
			List<WebElement> element = BrowserUtilities.driver.findElements(locator);

			// make sure you found the right number of elements
			if (expected.length != element.size()) {
			    System.out.println("fail, wrong number of elements found");
			}
			// make sure that the value of every <option> element equals the expected value
			for (int i = 0; i < expected.length; i++) {
			    String optionValue = element.get(i).getAttribute("value");
			    if (optionValue.equals(expected[i])) {
			        System.out.println("passed on: " + optionValue);
			    } else {
			        System.out.println("failed on: " + optionValue);
			    }
			
			}
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	/**
	 *  method to get message test of alert
	 * @return message text which is displayed
	 */
	public static String getAlertText() 
	{ 
		try {
			Alert alert = BrowserUtilities.driver.switchTo().alert(); 
			String alertText = alert.getText(); 
			return alertText; 
		} catch (NoAlertPresentException e){
			throw new NoAlertPresentException();
		}
	}   

	/**
	 *  method to verify if alert is present
	 * @return returns true if alert is present else false
	 */
	public static boolean isAlertPresent() 
	{ 
		try 
		{ 
			WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, timeOut);
			wait.until(ExpectedConditions.alertIsPresent());
			BrowserUtilities.driver.switchTo().alert();
			return true; 
		}   
		catch (NoAlertPresentException e) 
		{   
			throw new NoAlertPresentException(); 
		}   
	}
	
	/**
	 *  method to verify if element is clickable
	 * @return returns true if element is clickable else false
	 */
	public static void isClickable(WebElement element) 
	{ 
			if(element.isEnabled())
				
			System.out.println("Element is clickable");
			
			else
			
			System.out.println("Element is not clickable");
		
		   
	}
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isSelected(WebElement element) 
	{ 
		
			if(element.isSelected())
				
			System.out.println("Element is selected");
			
			else
			
			System.out.println("Element is not selected");
		 
	}
	
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isNotSelected(WebElement element) 
	{ 
		
			if(!element.isSelected())
				
			System.out.println("Element is not selected");
			
			else
			
			System.out.println("Element is  selected");
		 
	}
	

	/**
	 *  method to verify if element is Displayed
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isDisplayed(WebElement element) 
	{ 

		if(element.isDisplayed())
			
			{System.out.println(element+"is displayed");
		
		return true;}
		
		else {
			
			System.out.println(element+"is not displayed");
			return false;
		}
		}
 
	
	/**
	 *  method to Accept Alert if alert is present
	 */
	
	public static void acceptAlert(){
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().accept();
	}
	/**
	 *  method to Dismiss Alert if alert is present
	 */
	
	public static void dismissAlert(){
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().dismiss();
	}
	

	/**
	 *  method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown_300(){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}

	/**
	 *  method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown_600(){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,600)", "");
	}
	 
	/**
	 *  method to scrollpage up using JavaScript Executor
	 */

	public static void scrollPageUp_300(){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,-300)", "");
	}

	 
	/**
	 *  method to scroll page down to element using JavaScript Executor
	 */

	public static void scrollDownToElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		 js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	 

	/**
	 *  method to scroll page up to element using JavaScript Executor
	 */

	public static void scrollUpToElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	 
	
		/**
		 *  method to click and hold element 
		 */

		public static void clickAndHold(WebElement element){
			Actions action=new Actions(BrowserUtilities.driver);
			action.moveToElement(element).build().perform();
			
			
		}

		/**
		 *  method to release hold element 
		 */

		public static void release(WebElement element){
			Actions action=new Actions(BrowserUtilities.driver);
			action.release(element).build().perform();
			
		}
		
		/**
		 *  method to move to element 
		 */

		public static void moveTo(WebElement element){
			Actions action=new Actions(BrowserUtilities.driver);
			action.moveToElement(element).build().perform();
			
		}
		/**
		 *  method to drag and drop element 
		 */

		public static void dragAndDrop(WebElement element1,WebElement element2){
			Actions action=new Actions(BrowserUtilities.driver);
	        action.dragAndDrop(element1, element2);
		}
		
		/**
		 *  method to handle windows 
		 */

		public static void winHandle(){
			
			Set<String> Winlist=BrowserUtilities.driver.getWindowHandles();
			System.out.println(Winlist.size());
			for (String win : Winlist) {
	 	    	   
	        	BrowserUtilities.driver.switchTo().window(win);
               
	        	}
		}
			/**
			 *  method to get rgba color style of element 
			 */

			public static String getcolor(WebElement element){
				
				String BColor=element.getCssValue("background-color");
		    	//String BColor=BrowserUtilities.driver.findElement(By.id("vehicle-check-manage-fleet")).getCssValue("background-color");
		    	
				return BColor;	
		}
}
