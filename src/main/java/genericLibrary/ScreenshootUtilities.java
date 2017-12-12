package genericLibrary;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;

/**
 * @author Indrapal Singh
 * @getScreenShot method to capture screenshoot for failed test 
 * captureScreenShot method to capture screenshoot after every test
 */

public class ScreenshootUtilities {
	
	public static void getScreenShot(WebDriver ldriver,ITestNGMethod method){
	 
	  // Take screenshot and store as a file format
	  File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
	try {
	  // now copy the  screenshot to desired location using copyFile method
	 
		FileUtils.copyFile(src, new File(ConfigProperties.getObject("Screenshootpath")+System.currentTimeMillis()+".png"));
	       }
	 
	catch (IOException e)
	 
	{
	 
	System.out.println(e.getMessage());
	 
	    }
	 
	}


	public static void captureScreenShot(){
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)BrowserUtilities.driver).getScreenshotAs(OutputType.FILE);
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 
			FileUtils.copyFile(src, new File(ConfigProperties.getObject("Screenshootpath")+System.currentTimeMillis()+".png"));
		       }
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		    }
		 
		}

	
}


