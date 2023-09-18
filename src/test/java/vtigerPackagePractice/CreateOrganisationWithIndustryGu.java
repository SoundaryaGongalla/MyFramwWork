package vtigerPackagePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.objectRepositery.CreateOrganisationsPage;
import vTiger.objectRepositery.HomePage;
import vTiger.objectRepositery.LoginPage;
import vTiger.objectRepositery.OrganisationInfoPage;
import vtigerGenericUtilities.ExcelFileUtility;
import vtigerGenericUtilities.JavaFileutility;
import vtigerGenericUtilities.PropertyFileUtility;
import vtigerGenericUtilities.WebDriverUtility;

public class CreateOrganisationWithIndustryGu {

	static WebDriver  driver;
	public static void main(String[] args) throws Throwable {
	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaFileutility jutil=new JavaFileutility();
	WebDriverUtility wutil=new WebDriverUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	 String BROWSER=putil.readFileFromPropertyFile("browser");
	 String URL=putil.readFileFromPropertyFile("url");
	 String USERNAME=putil.readFileFromPropertyFile("username");
	 String PASSWORD=putil.readFileFromPropertyFile("password");
	 String ORGNAME=eutil.readDataFromExcel("Organisation", 4, 2)+jutil.getrandomNumber();
	 String INDUSTRY=eutil.readDataFromExcel("Organisation", 4, 3);
	 
	System.out.println(ORGNAME);
	System.out.println(INDUSTRY);
		//step1 launch browser
		
	 System.out.println("+++++++++++++++++++++++"+URL);
	 
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		
	}
	else if (BROWSER.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();	
	}
	else
	{
		System.out.println("enter the paticular browser");
	}

		wutil.waitforpageLoad(driver);
		
//		//step2 login app with valid credentials
		
		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
LoginPage lpage=new LoginPage(driver);
lpage.getUsernameTextBox().sendKeys(USERNAME);
lpage.getPasswordTextbox().sendKeys(PASSWORD);
lpage.getLoginButton().click();
		
//			step3navigate  to Organistion Link
		
		//driver.findElement(By.xpath("//a[text()='Organizations']")).click();

HomePage hpage=new HomePage(driver);
hpage.getOranisationLink().click();

////			step4 create orgNIAiowith look up img
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//CreateOrganisationsPage createOrg=new CreateOrganisationsPage();
//createOrg.getOrganisationLookupImg().click();




////			step5create oranissation with mandator details
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	Thread.sleep(2000);
////			step6 create chemicals in industry drop down
	WebElement dropdown =driver.findElement(By.name("industry"));	
	//dropdown.click();

	wutil.handleDropDown(dropdown, INDUSTRY);

////			step7 saveIOP-
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);


////			step8 verify
	String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(header.equals(ORGNAME))
	{
		
		System.out.println("passed");
		System.out.println(header);
	}
	else
	{
		System.out.println("fail");
	}
	////step9 logout


	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	wutil.mouseOverAction(driver, ele);

	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

	}

