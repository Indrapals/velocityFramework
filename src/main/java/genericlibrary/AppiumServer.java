package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public final class AppiumServer {

	private AppiumServer() {
		throw new IllegalStateException("Utility class");
	}

	private static AppiumDriverLocalService service;

	public static void startServer() throws IOException {

		try {
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(ConfigProperties.getObject("AppiumNodePath")))
					.withAppiumJS(new File(ConfigProperties.getObject("AppiumjsPath")))
					.withIPAddress(ConfigProperties.getObject("AppiumIPAddress")).usingPort(4723));

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

	/**
	 * Starts an emulator for the provided AVD name
	 * 
	 * @param nameOfAVD
	 * @throws IOException
	 */
	public static void launchEmulator(String nameOfAVD) throws IOException {

		String[] aCommand = new String[] {
				ConfigProperties.getObject("sdkPath") + "tools" + File.separator + "emulator", "-avd", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			LogUtilities.info("Emulator is not launching");
		}
	}
}
