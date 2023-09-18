package vtigerPackagePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//create org with industry energyy and select customer in drop down
public class Scenario4 {

public static void main(String[] args) throws Throwable {
	
	//step1 launch browsers
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

	//step2 login app with valid credentials
	
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);

//step3navigate  to Organistion Link
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();

	
//	step4 create orgNIAiowith look up img
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

	
//	step5 create oranissation with mandator details
	
driver.findElement(By.name("accountname")).sendKeys("sony");
Thread.sleep(3000);
//step6 create chemicals in industry drop down
WebElement dropdown =driver.findElement(By.name("industry"));	
dropdown.click();
Select s=new Select(dropdown);
s.selectByValue("Energy");
//		step6 select customer in type dropdown
//
WebElement type= driver.findElement(By.name("accounttype"));
type.click();
Select  se=new Select(type);
se.selectByValue("Customer");

//step5 save 
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(3000);

	//	step7 verify
String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(header.equals("sony"))
{
	
	System.out.println("passed");
	System.out.println(header);
}
//else
{
//	System.out.println("fail");
}
//		step8 logout
Actions act=new Actions(driver);
WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
act.moveToElement(ele).perform();
//
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


}}
