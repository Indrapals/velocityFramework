package genericLibrary;
import org.apache.log4j.Logger;
 
public class Log {
// Initialize Log4j logs
     private static Logger Log = Logger.getLogger(Log.class.getName()); 
// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
public static void startTestCase(String sTestCaseName){
    Log.info("****************************************************************************************");
    Log.info("****************************************************************************************");
    Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
    Log.info("****************************************************************************************");
    Log.info("****************************************************************************************");
    }
 
    //This is to print log for the ending of the test case
public static void endTestCase(String sTestCaseName){
    Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
    Log.info("X");
    Log.info("X");
    Log.info("X");
    Log.info("X");
    }
 
public static String getTestCaseName(String sTestCase)throws Exception{
String value = sTestCase;
try{
int posi = value.indexOf("@");
value = value.substring(0, posi);
posi = value.lastIndexOf(".");	
value = value.substring(posi + 1);
return value;
}catch (Exception e){
Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
throw (e);
}
}

    // Need to create these methods, so that they can be called  
public static void info(String message) {
        Log.info(message);
        }
public static void warn(String message) {
    Log.warn(message);
    }
public static void error(String message) {
    Log.error(message);
    }
public static void fatal(String message) {
    Log.fatal(message);
    }
public static void debug(String message) {
    Log.debug(message);
    }
}
