package vtigerGenericUtilities;

import java.text.SimpleDateFormat;



import java.util.Date;
import java.util.Formatter;
import java.util.Random;
/**
 * This class consists of reusable methods related to java
 * @author soundarya
 * 
 */
public class JavaFileutility {

	
	/**
	 * This method will return random number for ever execution
	 * @return
	 */
	public int getrandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
		
	}
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formattater=new SimpleDateFormat("dd-mm-yyyy");
				String data=formattater.format(d);
				return data;
	}
	
	
	
}
