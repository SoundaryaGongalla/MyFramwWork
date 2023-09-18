package vtigerPackagePractice;

import java.time.Duration;
import java.util.Random;

import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.annotations.VisibleForTesting;

public class Scenario2 {
public static void main(String[] args) throws Throwable {
	

	Random r=new Random();
	String data="rrr"+r.nextInt();
//step1 launch browser
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

		
//step2 login app with valid credentials
	
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);

//	step3navigate  to Organistion Link
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	
	//click on create Organisstion with lookup img
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
//	step4 create Org with mandator detail
	driver.findElement(By.name("accountname")).sendKeys(data);

//	step5 save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);
//Alert alt=driver.switchTo().alert();
//alt.accept();
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//	step6 verify and validate
String  header =	driver.findElement(By.className("dvHeaderText")).getText();
	if(header.equals(data))
	{
		System.out.println("passed");
	System.out.println("header data is:"+header);
	}
	
//	step7 logout

	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	act.moveToElement(ele).perform();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
}
	

}
