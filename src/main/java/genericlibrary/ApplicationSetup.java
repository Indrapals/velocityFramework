package genericlibrary;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApplicationSetup {

	private ApplicationSetup()  {
	    throw new IllegalStateException("Utility class");
	  }


	
	public static AppiumDriver<MobileElement> driver;
	
	private static String appPackage ="com.radiuspaymentsolutions.vehiclecheck.dev";
	private static String appActivity = "com.radiuspaymentsolutions.vehiclecheck.Views.Activities.SplashActivity";

	
	public static void setCapability() throws IOException{
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		  capabilities.setCapability("deviceName", "Android Emulator");
	
		  capabilities.setCapability("appium-version", "1.4.16");
		
		  capabilities.setCapability("platformVersion", "5.1.1");

		  capabilities.setCapability("platformName", "Android");
		  
		  capabilities.setCapability("unicodeKeyboard", true);
		  
		  capabilities.setCapability("resetKeyboard", true);

		  capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
		  
		  capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		  
		  capabilities.setCapability("appPackage",appPackage);

	 	  capabilities.setCapability("appActivity", appActivity);
	 	  
		  
	 	  driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 		
	      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);  

		
	}
}
