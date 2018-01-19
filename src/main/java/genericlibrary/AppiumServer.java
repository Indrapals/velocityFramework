package genericlibrary;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public final class AppiumServer {

	private AppiumServer()  {
	    throw new IllegalStateException("Utility class");
	  }

	private static AppiumDriverLocalService service;
	
	public static void startServer() throws IOException  {
		 
		 try {
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
			            usingDriverExecutable(new File(ConfigProperties.getObject("AppiumNodePath"))).
			            withAppiumJS(new File(ConfigProperties.getObject("AppiumjsPath")))
			            .withIPAddress(ConfigProperties.getObject("AppiumIPAddress"))
			            .usingPort(4723));

			 service.start();
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {

			throw new AppiumServerHasNotBeenStartedLocallyException(e.getMessage());
		}
	 }

	public static void closeServer() {
		 
		 try {
			
			 service.stop();
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			throw new AppiumServerHasNotBeenStartedLocallyException(e.getMessage());
		}
	 }

}
