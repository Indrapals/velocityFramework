package genericLibrary;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import actionsLibrary.CommonActionUtil;

public class BrowserUtilities {
	
	/**
	 * @author Indrapal Singh
	 *Contains methods to launch any browser with url as per constant properties file 
	 */
	
public static WebDriver driver;

	public static WebDriver getBrowser() throws IOException{
	
		if(ConfigProperties.getObject("browser").equalsIgnoreCase("firefox")){
	
				System.setProperty("webdriver.firefox.marionette",ConfigProperties.getObject("pathGeckoDriver"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		CommonActionUtil.implicitWait();
		driver.get(ConfigProperties.getObject("url"));
        
	}

	else if(ConfigProperties.getObject("browser").equalsIgnoreCase("chrome")){ 
		
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getObject("pathChromeDriver"));
		 driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		 CommonActionUtil.implicitWait();
		 driver.get(ConfigProperties.getObject("url"));

			  }	
	else if(ConfigProperties.getObject("browser").equalsIgnoreCase("ie")){
		
		 System.setProperty("webdriver.ie.driver",ConfigProperties.getObject("pathIEDriver"));
		 driver = new InternetExplorerDriver();		
		 driver.manage().window().maximize();
		 CommonActionUtil.implicitWait();
		 driver.get(ConfigProperties.getObject("url"));
	}
	
	return driver;
	
	}

	public static void getWindowHandles() throws IOException, InterruptedException{
		Thread.sleep(1000);
	//	String parentWindowHandler = BrowserUtilities.driver.getWindowHandle(); // Store your parent window
		
		String subWindowHandler = null;

		Set<String> handles = BrowserUtilities.driver.getWindowHandles(); // get all window handles

		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		   subWindowHandler = iterator.next();
		   BrowserUtilities.driver.switchTo().window(subWindowHandler);
		}

	}
	public static void closeBrowser() throws IOException{
		
		//ScreenshotUtilities.captureScreenShot();
		driver.close();
	
	}
}
