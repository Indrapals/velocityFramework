package actionslibrary;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericlibrary.*;



public class CommonActionUtil {

	private CommonActionUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	
	/**
	 * @author Indrapal Singh
	 *Commonly used Webdriver actions perform on webelement  
	 */
	
	public static final int TIMEOUT = 70;
	public static final int I =0;
	public static final int N=0;
	
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	
	public static WebElement findElement(By locator){
		try {
			
			return ApplicationSetup.driver.findElement(locator);
		}
		catch (NoSuchElementException e){

			LogUtilities.error("Element not found");
			throw new NoSuchElementException(e.getMessage());
		
		}		
	}
	
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	public static WebElement findElementandclick(By locator){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
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
	public static String findElementandgettext(By locator){
		try {
			
		 return	ApplicationSetup.driver.findElement(locator).getText();
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @Sendkeys to element if found else throws NoSuchElementException
	 */
	public static WebElement sendkeys(By locator,String value){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
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
	public static Object implicitwait(int i,TimeUnit arg1){
		try {
			ApplicationSetup.driver.manage().timeouts().implicitlyWait(i, arg1);
				}
		catch (Exception e){
			throw new NoSuchElementException(e.getMessage());
		}
		return null;
	}
	
	/*
	 * method for Explicit wait
	 */
	public static void explicitwait(By by){
		try {
			(new WebDriverWait(ApplicationSetup.driver, 30)).until(ExpectedConditions.elementToBeClickable(by));
			ApplicationSetup.driver.findElement(by).click();
				}
		catch (StaleElementReferenceException  ser) {
			throw new NoSuchElementException(ser.getMessage());
		}
		}
        
	
	/*
	 * method to navigate back
	 */
	public static Object back(){
		try {
			ApplicationSetup.driver.navigate().back();
				}
		catch (Exception e){
			throw new NoSuchElementException(e.getMessage());
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
			 
			return BrowserUtilities.driver.findElements(locator);
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
	
	public static void verifyVehicleCheck(By locator){
		try {
			String[] expected = {"", "Home", "Vehicle Check Dashboard ", "Due Dates Dashboard", "Defect Management", "How It Works", "Manage Fleet", "Manage Groups", "Manage Questions", "Reports", "Alerts"};
			List<WebElement> element = BrowserUtilities.driver.findElements(locator);

			// make sure you found the right number of elements
			if (expected.length != element.size()) {
				LogUtilities.error("fail, wrong number of elements found");
			    
			}
			// make sure that the value of every <option> element equals the expected value
			for (int i = 0; i < expected.length; i++) {
			    String optionValue = element.get(i).getAttribute("value");
			    if (optionValue.equals(expected[i])) {
			    	LogUtilities.error("passed on: " + optionValue);
			    } else {
			    	LogUtilities.error("failed on: " + optionValue);
			        
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
	 * @throws InterruptedException 
	 */
	public static String getAlertText() throws InterruptedException 
	{ 
		try {
			Alert alert = BrowserUtilities.driver.switchTo().alert(); 
			Thread.sleep(1000);
			return alert.getText(); 
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
			WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
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
				
				LogUtilities.error("Element is clickable");
			else
			
				LogUtilities.error("Element is not clickable");
		
		   
	}
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isSelected(WebElement element) 
	{ 
		
			if(element.isSelected())
				
				LogUtilities.error("Element is selected");
			
			else
			
				LogUtilities.error("Element is not selected");
		 
	}
	
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isNotSelected(WebElement element) 
	{ 
		
			if(!element.isSelected())
				
				LogUtilities.error("Element is not selected");
			
			else
			
				LogUtilities.error("Element is selected");
		 
	}
	

	/**
	 *  method to verify if element is Displayed
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isDisplayed(WebElement element) 
	{ 

		if(element.isDisplayed())
			
			{
			LogUtilities.error(element+"is displayed");
		
		return true;}
		
		else {
			
			LogUtilities.error(element+"is not displayed");
			return false;
		}
		}
 
	/**
	 *  method to verify if elements list is Displayed
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isListDisplayed(List<WebElement> element) 
	{ 

		if(((WebElement) element).isDisplayed())
			
			{
			LogUtilities.error(element+"is displayed");
		
		return true;}
		
		else {
			
			LogUtilities.error(element+"is not displayed");
			return false;
		}
		}
 
	/**
	 *  method to Accept Alert if alert is present
	 */
	
	public static void acceptAlert(){
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().accept();
	}
	/**
	 *  method to Dismiss Alert if alert is present
	 */
	
	public static void dismissAlert(){
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().dismiss();
	}
	

	/**
	 *  method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown300(){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}

	/**
	 *  method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown600(){
		JavascriptExecutor js = (JavascriptExecutor)BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,600)", "");
	}
	 
	/**
	 *  method to scrollpage up using JavaScript Executor
	 */

	public static void scrollPageUp300(){
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
			
			Set<String> winlist=BrowserUtilities.driver.getWindowHandles();
		
			for (String win : winlist) {
	 	    	   
	        	BrowserUtilities.driver.switchTo().window(win);
               
	        	}
		}
			/**
			 *  method to get rgba color style of element 
			 */

			public static String getcolor(WebElement element){
				
			
				return element.getCssValue("background-color");	
		}
			
			public static void implicitWait1()
			{
				BrowserUtilities.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			}
			

			public static void expWaitElementClick(WebDriver driver,By by){
				
			        try {
						(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
						driver.findElement(by).click();
					} catch (StaleElementReferenceException  ser) {

						driver.findElement(by).click();
					}
			        catch (TimeoutException  toe) {
			        	LogUtilities.error("Timeout of session");
					}
			}
			
			public static void expWaitElementLocated(WebDriver driver,WebElement element){
				
					(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By) element));			
		       
		}

			
			public static void locateThenClick(WebDriver driver,By by){
				
		        try {
					(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
					driver.findElement(by).click();
				} catch (StaleElementReferenceException  ser) {
					driver.findElement(by).click();
				}
		        catch (TimeoutException   toe) {
		        	LogUtilities.error("Timeout of session");
				}
		
		}
			
}
