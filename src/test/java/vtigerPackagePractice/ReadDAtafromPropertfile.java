package vtigerPackagePractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDAtafromPropertfile {
public static void main(String[] args) throws Throwable {
		
//	step1 open doc to in java readable format
	FileInputStream 	 fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\CommonData.properties");
	
//	step2 create an object of Properties file
	Properties pobj=new Properties();
	
//	step3 load the document into properties file
	pobj.load(fis);
//	//step4 fetch the value by providing the key
//	provide the key and read  the value
	String data=pobj.getProperty("url");
	System.out.println(data);
//	
//	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
}
