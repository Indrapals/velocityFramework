package genericLibrary;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	/**
	 * @author Indrapal Singh
	 * To configure testlink with selenium framework  
	 */
	
	public static final String TESTLINK_KEY = "a9cbcc12e797030f305691a16b247202";
	public static final String TESTLINK_URL = "http://192.168.10.57/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TESTLINK_PROJECT_NAME = "Velocity-POC";
	public static final String TESTLINK_PLAN_NAME = "Velocity POC Test Plan";
	public static final String TESTLINK_CASE_NAME = "VLC-1";
	public static final String BUILD_NAME = "POC-Build";
	
	 public static void updateResult(String testCaseName, String exception, String results)    throws TestLinkAPIException
	 {
	      TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY,TESTLINK_URL);
	      testlink.reportTestCaseResult(TESTLINK_PROJECT_NAME, TESTLINK_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
	 }
	
}
