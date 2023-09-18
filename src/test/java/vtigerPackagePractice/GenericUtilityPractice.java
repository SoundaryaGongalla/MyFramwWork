package vtigerPackagePractice;

import vtigerGenericUtilities.ExcelFileUtility;
import vtigerGenericUtilities.JavaFileutility;
import vtigerGenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
public static void main(String[] args) throws Throwable {
//	PropertyFileUtility pfu=new PropertyFileUtility();
//	String  value=pfu.readFileFromPropertyFile("browser");
//		System.out.println(value);
//		
//		String url=pfu.readFileFromPropertyFile("url");
//		System.out.println(url);
//		
//		String un=pfu.readFileFromPropertyFile("username");
//		System.out.println(un);
//		
//		String password=pfu.readFileFromPropertyFile("pasword");
//		System.out.println(password);
//		
//		// random number
//		JavaFileutility j=new JavaFileutility();
//	int random=	j.getrandomNumber();
//	System.out.println(random);
	
//		String datatime=j.getSystemDate();
//		System.out.println(datatime);
//		

	ExcelFileUtility exel=new ExcelFileUtility();
	String data=exel.readDataFromExcel("WER", 0, 0);
	System.out.println(data);
	
		
	ExcelFileUtility exelf=new ExcelFileUtility();
	exelf.writeDataInExcel("WERe", 0, 0, "spiderman");
	System.out.println("added successfull");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
}
