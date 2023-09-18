package vtigerPackagePractice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoOrdganisationModule {
public static void main(String[] args) throws Throwable {
	Random r=new Random(100);
	String data="rrr"+r.nextInt();
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://localhost:8888");
	String  id=driver.getWindowHandle();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	

	driver.findElement(By.name("accountname")).sendKeys(data);//oranistion name
	Thread.sleep(3000);
	driver.findElement(By.name("website")).sendKeys("abcgmail.com"); //website
	Thread.sleep(3000);

	WebElement member=driver.findElement(By.cssSelector("img[title='Select']"));
	member.click();
	Thread.sleep(3000);
Set<String> ids=driver.getWindowHandles();
for(String i:ids)
{
	if(!(id.equalsIgnoreCase(i)))
	{

	driver.switchTo().window(i);
	Thread.sleep(3000);
	driver.findElement(By.id("2")).click();

	Alert alt=driver.switchTo().alert();
	alt.accept();
}
}
	Thread.sleep(5000);

	driver.findElement(By.id("employees")).sendKeys("mansa");//emploees
	
WebElement  industry=	driver.findElement(By.name("industry"));
industry.click();
	
	
	Select s=new Select(industry);
s.selectByVisibleText("Banking");
	
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();//save
	Thread.sleep(3000);
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	act.moveToElement(ele).perform();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();  //logout
}
	
	
	
}
