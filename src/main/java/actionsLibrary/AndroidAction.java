package actionsLibrary;

import java.util.HashMap;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibrary.ApplicationSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;

public class AndroidAction {
	
	// common timeout for all tests can be set here
	public final static int timeOut = 70;
	
	
	/**
	 * method to find an element
	 * @param locator element to be found
	 * @click on element if found else throws NoSuchElementException
	 */
	public static WebElement findElement(By locator){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
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
	public static WebElement findElement_Click(By locator){
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
	public static WebElement findElement_getText(By locator){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
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
	public static Object implicit_wait(int i,TimeUnit arg1){
		try {
			ApplicationSetup.driver.manage().timeouts().implicitlyWait(i, arg1);
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
			(new WebDriverWait(ApplicationSetup.driver, 30)).until(ExpectedConditions.elementToBeClickable(by));
			ApplicationSetup.driver.findElement(by).click();
			//ApplicationSetup.driver.manage().timeouts().implicitlyWait(i, arg1);
				}
		catch (StaleElementReferenceException  ser) {
			// TODO Auto-generated catch block
			ApplicationSetup.driver.findElement(by).click();
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
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  method to tap on the screen on provided coordinates
	 * @param xPosition x coordinate to be tapped
	 * @param yPosition y coordinate to be tapped
	 */
	public static void tap(double xPosition, double yPosition){
		JavascriptExecutor js = (JavascriptExecutor)ApplicationSetup.driver;
		HashMap<String, Double>  tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);	
	}

	
	/**
	 *  method to find all the elements of specific locator
	 * @param locator element to be found
	 * @return return the list of elements if found else throws NoSuchElementException
	 */
	
	public static List<MobileElement> findElements(By locator){
		try {
			List<MobileElement> element = ApplicationSetup.driver.findElements(locator);
			return element;
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
			Alert alert = ApplicationSetup.driver.switchTo().alert(); 
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
			WebDriverWait wait = new WebDriverWait(ApplicationSetup.driver, timeOut);
			wait.until(ExpectedConditions.alertIsPresent());
			ApplicationSetup.driver.switchTo().alert();
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
	public static void isClickable(By locator) 
	{ 
			if(ApplicationSetup.driver.findElement(locator).isEnabled())
				
			System.out.println("Element is clickable");
			
			else
			
			System.out.println("Element is not clickable");
		
		   
	}
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isSelected(By locator) 
	{ 
		
			if(ApplicationSetup.driver.findElement(locator).isSelected())
				
			System.out.println("Element is selected");
			
			else
			
			System.out.println("Element is not selected");
		 
	}
	
	
	/**
	 *  method to verify if element is selected
	 * @return returns true if element is selected else false
	 */
	public static void isNotSelected(By locator) 
	{ 
		
			if(!ApplicationSetup.driver.findElement(locator).isSelected())
				
			System.out.println("Element is not selected");
			
			else
			
			System.out.println("Element is  selected");
		 
	}
	
	/**
	 *  method to verify if element is Displayed
	 * @return returns true if element is Displayed else false
	 */
	public static void isDisplayed(By locator) 
	{ 
		
		WebElement element=ApplicationSetup.driver.findElement(locator);

		if(element.isDisplayed())
			
			System.out.println(element+"is displayed");
		
		else
		
			System.out.println(element+"is not displayed");
		}
 
	/**
	 *  method to verify if element is Displayed
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isDisplayed1(By locator,String message) 
	{ 
		
		WebElement element=ApplicationSetup.driver.findElement(locator);

		if(element.isDisplayed())
			
			System.out.println(element+"is displayed");
		
		else
		
			System.out.println(element+"is not displayed");
		return false;
		}
 
	
	/**
	 *  method to Accept Alert if alert is present
	 */
	
	public static void acceptAlert(){
		WebDriverWait wait = new WebDriverWait(ApplicationSetup.driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		ApplicationSetup.driver.switchTo().alert().accept();
	}
	/**
	 *  method to Dismiss Alert if alert is present
	 */
	
	public static void dismissAlert(){
		WebDriverWait wait = new WebDriverWait(ApplicationSetup.driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		ApplicationSetup.driver.switchTo().alert().dismiss();
	}
	

	/**
	 * method to get all the context handles at particular screen
	 */
	public static void getContext(){
		(ApplicationSetup.driver).getContextHandles();
	}
	
	/**
	 * method to set the context to required view.
	 * @param context view to be set 
	 */
	public static void setContext(String context){

		Set<String> contextNames = (ApplicationSetup.driver).getContextHandles();

		if (contextNames.contains(context)){
			(ApplicationSetup.driver).context(context);
		}
	}
	
	/**
	 * method to long press on specific element by passing locator
	 * @param locator element to be long pressed
	 */
	public static void longPress(By locator){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
			TouchAction touch = new TouchAction((MobileDriver)ApplicationSetup.driver);
			touch.longPress(element).release().perform();
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}

	}

	/**
	 * method to long press on specific x,y coordinates
	 * @param x x offset
	 * @param y y offset
	 */
	public static void longPress(int x, int y){
		TouchAction touch = new TouchAction((MobileDriver) ApplicationSetup.driver);
		touch.longPress(x, y).release().perform();

	}


	/**
	 * method to long press on element with absolute coordinates.
	 * @param locator element to be long pressed
	 * @param x x offset
	 * @param y y offset
	 */
	public static void longPress(By locator, int x, int y){
		try {
			WebElement element = ApplicationSetup.driver.findElement(locator);
			TouchAction touch = new TouchAction((MobileDriver) ApplicationSetup.driver);
			touch.longPress(element,x, y).release().perform();
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException(e.getMessage());
		}

	}
	/**
	 *  method to swipe on the screen on provided coordinates
	 * @param startX - start X coordinate to be tapped
	 * @param endX - end X coordinate to be tapped
	 * @param startY - start y coordinate to be tapped
	 *  @param endY - end Y coordinate to be tapped
	 *   @param duration duration to be tapped
	 */

	public static void swipe(double startX, double startY, double endX, double endY, double duration)
	{ 
		JavascriptExecutor js = (JavascriptExecutor) ApplicationSetup.driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		// swipeObject.put("touchCount", 1.0);
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", duration);
		js.executeScript("mobile: swipe", swipeObject);
	}


	/**
	 *  method to Swipe Left on Element By Locator
	 * @param locator - By locator
	 *  @param duration - Time to swipe
	 */

   	public static void swipeLeft(By locator , int duration){
		MobileElement element = (MobileElement) ApplicationSetup.driver.findElement(locator);
		element.swipe(SwipeElementDirection.LEFT, duration);

	}

	/**
	 *  method to Swipe Right on Element By Locator
	 * @param locator - By locator
	 *  @param duration - Time to swipe
	 */

	public static void swipeRight(By locator , int duration){
		MobileElement element = (MobileElement) ApplicationSetup.driver.findElement(locator);
		element.swipe(SwipeElementDirection.RIGHT, duration);

	}

	/**
	 *  method to Swipe UP on Element By Locator
	 *  @param locator - By locator
	 *  @param duration - Time to swipe
	 */

	public static void swipeUP(By locator , int duration){
		MobileElement element = (MobileElement) ApplicationSetup.driver.findElement(locator);
		element.swipe(SwipeElementDirection.UP, duration);
	}
	

	/**
	 *  method to Swipe Down on Element By Locator
	 *  @param locator - By locator
	 *  @param duration - Time to swipe
	 */
	
	public static void swipeDown(By locator , int duration){
		MobileElement element = (MobileElement) ApplicationSetup.driver.findElement(locator);
		element.swipe(SwipeElementDirection.DOWN, duration);
	}	
	
	/**
	 * Scroll forward to the element which has a description or name which contains the input text.
	 * The scrolling is performed on the first scrollView present on the UI
	 * @param text text of the element text to be found
	 */

	@SuppressWarnings("deprecation")
	public static void scrollExact(String text) {
		try{
			((AppiumDriver<MobileElement>) ApplicationSetup.driver).scrollToExact(text); 
			System.out.println("Found Element After Scrolling");
			
		}
		catch(NoSuchElementException e){
		
			throw new NoSuchElementException(e.getMessage());
		}}
	
	/**
	 * Scroll forward to the element which has a description or name which exactly matches the input text.
	 * The scrolling is performed on the first scrollView present on the UI
	 * @param text - exact text of the element to be found
	 */

	@SuppressWarnings("deprecation")
	public static void scrollAndClick(String text) {
		try{
			((AppiumDriver<MobileElement>) ApplicationSetup.driver).scrollToExact(text).click(); 
			System.out.println("Found and clicked Element After Scrolling");
			
		}
		catch(NoSuchElementException e){
			
			throw new NoSuchElementException(e.getMessage());
		}  
	}

}
