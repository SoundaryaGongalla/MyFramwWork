package vtigerPackagePractice;
// create contact
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import vtigerGenericUtilities.WebDriverUtility;

public class Scenario1 {
public static void main(String[] args) throws Throwable {
	//step1 open browseR
	
WebDriver driver=new EdgeDriver();
WebDriverUtility w=new WebDriverUtility();
w.captureScreenShot(driver, "hello");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

	//step2 open app
driver.get("http://localhost:8888");
driver.findElement(By.name("use_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);


	//step 3 navigae the contacts link

	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//step4  create the contact look img
	
	//step5 create contact withlook up img

	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//step6  enter lastname

	driver.findElement(By.name("lastname")).sendKeys("sharathTrust");
	
	//step 7  save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);

	// step7 verfiy  and validation
	
	String orgheader=driver.findElement(By.className("dvHeaderText")).getText();
	if(orgheader.equals("sharathTrust"));
	{
		
		System.out.println("pass");
		System.out.println(orgheader);
		
	}
	
	
	//logout the app
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	act.moveToElement(ele).perform();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
