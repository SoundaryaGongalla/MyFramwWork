package vtigerGenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.objectRepositery.HomePage;
import vTiger.objectRepositery.LoginPage;

public class BaseClass {
public	 static WebDriver driver=null;
 static WebDriver sdriver;
public	PropertyFileUtility putil=new PropertyFileUtility();
public	WebDriverUtility wutil=new WebDriverUtility();
public	ExcelFileUtility eutil=new ExcelFileUtility();
	@BeforeSuite(alwaysRun = true)
	public void bs()
	{
	System.out.println("---DATABASE CONNECTED");	
	}
	@AfterSuite(alwaysRun = true)
	public void as()
	{
		System.out.println("-----DATABASE DISCONNECTED");
	}
	
	@BeforeClass(alwaysRun = true)
	public void bc() throws Throwable
	{
		
	String BROWSER	=putil.readFileFromPropertyFile("browser");
String URL		=putil.readFileFromPropertyFile("url");

if(BROWSER.equalsIgnoreCase("CHROME"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if (BROWSER.equalsIgnoreCase("Edge")) {
	
	WebDriverManager.edgedriver().setup();
driver=new EdgeDriver();	
}

else
{
	System.out.println("-wrong browser choosen");
}
sdriver=driver;
wutil.getMaximize(driver);
wutil.waitforpageLoad(driver);
driver.get(URL);
System.out.println("==url is:"+URL);
System.out.println("-----BROWSER LAUNCHED-----");

	}
	
	@AfterClass(alwaysRun = true)
	public void ac()
	{

		driver.quit();
		System.out.println("-----BROWSER CLOSED");

	}
	
	@BeforeMethod(alwaysRun = true)
	public void bm() throws Throwable
	{
	
String USERNAME	=putil.readFileFromPropertyFile("username");
String PASSWORD		=putil.readFileFromPropertyFile("password");
		
LoginPage lpage=new LoginPage(driver);
lpage.getUsernameTextBox().sendKeys(USERNAME);
lpage.getPasswordTextbox().sendKeys(PASSWORD);
lpage.getLoginButton().click();


System.out.println("---LOGIN DONE---");

	}
	@AfterMethod(alwaysRun = true)
	public void am() throws Throwable
	{
		wutil.waitforpageLoad(driver);
		HomePage hpage=new HomePage(driver);
		hpage.logout(driver);
		System.out.println("---LOGOUT DONE");
	}
}