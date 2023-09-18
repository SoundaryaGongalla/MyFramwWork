package vtigerPackagePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoProductCreateanddlogout {
public static void main(String[] args) throws Throwable {
WebDriver driver=new ChromeDriver();
	
	driver.get("http://localhost:8888");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
	
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	
	
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("productname")).sendKeys("amazon");
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
}
}
