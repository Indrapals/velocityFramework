package genericLibrary;

import java.io.File;
import java.net.MalformedURLException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {


	public static AppiumDriverLocalService service;
	
	  static String Appium_Node_Path="C:/Program Files/nodejs/node.exe";
	  static String Appium_JS_Path="C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
		
	
	public static void startServer() throws MalformedURLException {
		 
		 try {
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
			            usingDriverExecutable(new File(Appium_Node_Path)).
			            withAppiumJS(new File(Appium_JS_Path)).withIPAddress("127.0.0.1").usingPort(4723));

			 service.start();
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public static void closeServer() throws MalformedURLException {
		 
		 try {
			
			 service.stop();
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
