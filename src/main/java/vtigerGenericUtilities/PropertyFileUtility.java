package vtigerGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * This class consists of generic methods related to property file
 * @author soundarya
 * 
 */
public class PropertyFileUtility {
/*
 * this method will read data from property file
 */
	
	public String readFileFromPropertyFile(String propertykey) throws Throwable
	{
		

		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(propertykey);
		
	return value;		
}
}
