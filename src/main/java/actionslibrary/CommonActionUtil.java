package actionslibrary;

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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericlibrary.BrowserUtilities;
import genericlibrary.LogUtilities;

public class CommonActionUtil {

	private CommonActionUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * @author Indrapal Singh Commonly used Webdriver actions perform on
	 *         webelement
	 */

	public static final int TIMEOUT = 70;
	public static final int I = 0;
	public static final int N = 0;

	

	public static List<WebElement> findElements(By locator) {
		try {

			return BrowserUtilities.driver.findElements(locator);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	/**
	 * method to get message test of alert
	 * 
	 * @return message text which is displayed
	 * @throws InterruptedException
	 */
	public static String getAlertText() throws InterruptedException {
		try {
			Alert alert = BrowserUtilities.driver.switchTo().alert();
			BrowserUtilities.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return alert.getText();
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	/**
	 * method to verify if alert is present
	 * 
	 * @return returns true if alert is present else false
	 */
	public static boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
			wait.until(ExpectedConditions.alertIsPresent());
			BrowserUtilities.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	/**
	 * method to verify if element is clickable
	 * 
	 * @return returns true if element is clickable else false
	 */
	public static void isClickable(WebElement element) {
		if (element.isEnabled())

			LogUtilities.error("Element is clickable");
		else

			LogUtilities.error("Element is not clickable");

	}

	/**
	 * method to verify if element is selected
	 * 
	 * @return returns true if element is selected else false
	 */
	public static void isSelected(WebElement element) {

		if (element.isSelected())

			LogUtilities.error("Element is selected");

		else

			LogUtilities.error("Element is not selected");

	}

	/**
	 * method to verify if element is selected
	 * 
	 * @return returns true if element is selected else false
	 */
	public static void isNotSelected(WebElement element) {

		if (!element.isSelected())

			LogUtilities.error("Element is not selected");

		else

			LogUtilities.error("Element is selected");

	}

	/**
	 * method to verify if element is Displayed
	 * 
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isDisplayed(WebElement element) {

		if (element.isDisplayed())

		{
			LogUtilities.error(element + "is displayed");

			return true;
		}

		else {

			LogUtilities.error(element + "is not displayed");
			return false;
		}
	}

	/**
	 * method to verify if elements list is Displayed
	 * 
	 * @return returns true if element is Displayed else false
	 */
	public static boolean isListDisplayed(List<WebElement> element) {

		if (((WebElement) element).isDisplayed())

		{
			LogUtilities.error(element + "is displayed");

			return true;
		}

		else {

			LogUtilities.error(element + "is not displayed");
			return false;
		}
	}

	/**
	 * method to Accept Alert if alert is present
	 */

	public static void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().accept();
	}

	/**
	 * method to Dismiss Alert if alert is present
	 */

	public static void dismissAlert() {
		WebDriverWait wait = new WebDriverWait(BrowserUtilities.driver, TIMEOUT);
		wait.until(ExpectedConditions.alertIsPresent());
		BrowserUtilities.driver.switchTo().alert().dismiss();
	}

	/**
	 * method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown300() {
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}

	/**
	 * method to scrollpage using JavaScript Executor
	 */

	public static void scrollPageDown600() {
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,600)", "");
	}

	/**
	 * method to scrollpage up using JavaScript Executor
	 */

	public static void scrollPageUp300() {
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		js.executeScript("window.scrollBy(0,-300)", "");
	}

	/**
	 * method to scroll page down to element using JavaScript Executor
	 */

	public static void scrollDownToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	/**
	 * method to scroll page up to element using JavaScript Executor
	 */

	public static void scrollUpToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BrowserUtilities.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * method to release hold element
	 */

	public static void release(WebElement element) {
		Actions action = new Actions(BrowserUtilities.driver);
		action.release(element).build().perform();

	}

	/**
	 * method to move to element
	 */

	public static void moveTo(WebElement element) {
		Actions action = new Actions(BrowserUtilities.driver);
		action.moveToElement(element).build().perform();

	}

	/**
	 * method to drag and drop element
	 */

	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(BrowserUtilities.driver);
		action.dragAndDrop(element1, element2);
	}

	/**
	 * method to handle windows using for loop
	 */

	public static void winHandle() {

		Set<String> winlist = BrowserUtilities.driver.getWindowHandles();

		for (String win : winlist) {

			BrowserUtilities.driver.switchTo().window(win);

		}
	}
	
	/**
	 * method to handle windows using iterator(Priority)
	 */

	public static void getWindowHandles() throws InterruptedException {
		CommonActionUtil.implicitWait();

		String subWindowHandler = null;

		Set<String> handles = BrowserUtilities.driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
			BrowserUtilities.driver.switchTo().window(subWindowHandler);
		}

	}
	/**
	 * method to get rgba color style of element
	 */

	public static String getcolor(WebElement element) {

		return element.getCssValue("background-color");
	}

	public static void implicitWait() {
		BrowserUtilities.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void expWaitElementClick(WebDriver driver, By by) {

		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException ser) {

			driver.findElement(by).click();
		} catch (TimeoutException toe) {
			LogUtilities.error("Timeout of session");
		}
	}

	public static void expWaitElementLocated(WebDriver driver, WebElement element) {

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By) element));

	}

	public static void locateThenClick(WebDriver driver, By by) {

		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException ser) {
			driver.findElement(by).click();
		} catch (TimeoutException toe) {
			LogUtilities.error("Timeout of session");
		}

	}

}
