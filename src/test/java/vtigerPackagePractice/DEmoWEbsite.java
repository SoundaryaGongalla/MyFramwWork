package vtigerPackagePractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DEmoWEbsite {
	public static void main(String[] args) throws Throwable {
		Random r=new Random(10);
		String data="rrr"+r.nextInt();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(data);//oranistion name

		
		driver.findElement(By.name("website")).sendKeys("abcgmail.com"); //website

	
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		act.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	
	}

}
