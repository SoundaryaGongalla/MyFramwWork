package vtigerPackagePractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.objectRepositery.LoginPage;

public class CreateOranisationWithIndustryUsingDDT {
	static WebDriver driver;
public static void main(String[] args) throws Throwable {
	Random r=new Random();
	int random=r.nextInt(1000);
//step1 read all data required
	FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\CommonData.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL=pobj.getProperty("url");
	String USERNAME=pobj.getProperty("username");
	String PASSWORD=pobj.getProperty("password");
	String BROWSER =pobj.getProperty("browser");
	//read data from Excel file
	FileInputStream f=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");
	Workbook book=WorkbookFactory.create(f);
	Sheet sh=book.getSheet("Organisation");
	String ORGNAME=sh.getRow(4).getCell(2).getStringCellValue()+random;
	String INDUSTRY=sh.getRow(0).getCell(2).getStringCellValue();
	
	
//	step2 launch the browswer
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		 driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("edge")) {
	
		
		driver=new EdgeDriver();
		
	}
	else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser name");
	}
	
	//step2 open app
	driver.get(URL);
	LoginPage loginp=new LoginPage(driver);
	loginp.getUsernameTextBox().sendKeys(USERNAME);
	loginp.getPasswordTextbox().sendKeys(PASSWORD);
	loginp.getLoginButton().click();
	
	
	
	
	
	
	
	
	
	
	
	
}
}
