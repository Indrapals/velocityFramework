package genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigProperties {
	/**
	 * @author Indrapal Singh
	 * read and write properties to configure properties file
	 * @getobject method used to get get object from properties file 
	 */
	
	static Properties properties;
	public static void readProperties() throws IOException {
		
		properties =new Properties();
		InputStream input=new FileInputStream("C:\\Users\\Ranosys\\workspace\\velocity\\Constant.properties");
			properties.load(input);
		
	}
	
	public static void writeProperties() throws IOException{
		OutputStream output=new FileOutputStream("C:\\Users\\Ranosys\\workspace\\velocity\\Constant.properties");
		properties.setProperty("browser", "chrome");
		properties.store(output, null);
	}
	
	public static String getObject(String Data) throws IOException
	{
		readProperties();
	String data=properties.getProperty(Data);
	//System.out.println(data);
	return data;
	
	}
}
