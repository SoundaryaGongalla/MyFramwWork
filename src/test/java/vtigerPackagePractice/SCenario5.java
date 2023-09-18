package vtigerPackagePractice;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vTiger.objectRepositery.CreateContactsPage;
import vTiger.objectRepositery.HomePage;
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.ExcelFileUtility;

public class SCenario5 extends BaseClass {


@Test
public void m() throws Throwable, Throwable
{

	//step1 launch browser
	
		//WebDriver driver=new EdgeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

		//step2 login app with valid credentials
		
		//driver.get("http://localhost:8888");
		//driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	
	//step3 navigate  to contacts list
//	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
	HomePage hp=new HomePage(driver);
	//stepa4 click on contacts lookup img
	//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	hp.clickOnContactsLink();
	Thread.sleep(2000);
	CreateContactsPage cp=new CreateContactsPage(driver);
	cp.clickOnContactsLookUpImg();
	//step5 create contact name with mandatory details
	ExcelFileUtility ef=new ExcelFileUtility();
	String name = ef.readDataFromExcel("organisation", 2, 2);
	//driver.findElement(By.name("lastname")).sendKeys("tle");
	
	// step6 click on organisation lookup img
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::input/following-sibling::img")).click();
	
	
	//step7 switch to control to child window
	String mainid=driver.getWindowHandle();
	Set<String>allWinids=driver.getWindowHandles();
	for(String id:allWinids)
	{
		if(id!=mainid)
		{
			driver.switchTo().window(id);
System.out.println("window switched to child window");			
			
		
	//driver.switchTo().window(mainid);
//	step8 search for organistaion
	Thread.sleep(3000);
WebElement ele=	driver.findElement(By.id("search_txt"));
ele.sendKeys(name);

	driver.findElement(By.name("search")).click();
	
driver.findElement(By.xpath("//a[.='a']")).click();
			}
	}
//step 9 save
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(3000);


// step 10 validate

String orgheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

if(orgheader.equals(name))

{
	System.out.println("pass");
}
//step11 logout
//Actions act=new Actions(driver);
//WebElement ele1=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
//act.moveToElement(ele1).perform();
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();




}
}
