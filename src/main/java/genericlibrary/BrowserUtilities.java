package genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import actionslibrary.CommonActionUtil;

public final class BrowserUtilities {

	static final String BROWSER = "browser";

	private BrowserUtilities() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * @author Indrapal Singh Contains methods to launch any browser with url as per
	 *         constant properties file
	 */

	public static WebDriver driver;

	public static WebDriver getBrowser() throws IOException {

		if (ConfigProperties.getObject(BROWSER).equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.marionette", ConfigProperties.getObject("pathGeckoDriver"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			CommonActionUtil.implicitWait();
			driver.get(ConfigProperties.getObject("url"));

		}

		else if (ConfigProperties.getObject(BROWSER).equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", ConfigProperties.getObject("pathChromeDriver"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			CommonActionUtil.implicitWait();
			driver.get(ConfigProperties.getObject("url"));

		} else if (ConfigProperties.getObject(BROWSER).equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", ConfigProperties.getObject("pathIEDriver"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			CommonActionUtil.implicitWait();
			driver.get(ConfigProperties.getObject("url"));
		}
		return driver;

	}

	public static void closeBrowser() {

		driver.close();

	}
}
