package genericlibrary;

import java.io.IOException;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	private TestLinkIntegration() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * @author Indrapal Singh 
	 * To configure testlink with selenium framework
	 */

	public static final String TESTLINK_PROJECT_NAME = "Geberit Automation";
	public static final String TESTLINK_PLAN_NAME = "Automation Test PLan";
	public static final String BUILD_NAME = "Build 1";

	public static void updateResult(String testCaseName, String exception, String results)
			throws TestLinkAPIException, IOException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(ConfigProperties.getObject("TESTLINK_KEY"),
				ConfigProperties.getObject("TestLinkUrl"));
		testlink.reportTestCaseResult(TESTLINK_PROJECT_NAME, TESTLINK_PLAN_NAME, testCaseName, BUILD_NAME, exception,
				results);
	}

}
