package genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigProperties {
	
	private ConfigProperties() {
	    throw new IllegalStateException("Utility class");
	  }
	
	/**
	 * @author Indrapal Singh
	 * read and write properties to configure properties file
	 * @getobject method used to get get object from properties file 
	 */
	
	static Properties properties;
	public static void readProperties() throws IOException {
		
		properties =new Properties();
		InputStream input=new FileInputStream("./Constant.properties");
			properties.load(input);
		
	}
	
	public static void writeProperties() throws IOException{
		OutputStream output=new FileOutputStream("./Constant.properties");
		properties.setProperty("browser", "chrome");
		properties.store(output, null);
	}
	
	public static String getObject(String value) throws IOException
	{
		readProperties();
	
	return properties.getProperty(value);
	
	}
}
