package vtigerGenericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * this method is used to maximise
	 * @param driver
	 */
public void getMaximize(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * this method is used to minimize
 * @param driver
 */
public void getMinimize(WebDriver driver)
{
	driver.manage().window().minimize();
}
	/**
	 * This method will wait 10 sec  for all Web elemenets to load
	 * @param driver
	 */
	
	
	public void waitforpageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
//	public void waitForElementTbeVisible(WebDriver driver)
//	{
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions);
//	}
	/**
	 * Thiswthod will handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This ,method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/**
	 * This  method will handle dropdown using visibletext
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}
	/**
	 * this method will perform move cursor to 
	 * Web element element 
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will perform right click anywhere in the web page
	 * @param driver
	 */
	
	
	public void rightClickMouseOver(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on particular Web element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickMouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method perform right click on webpage
	 * @param driver
	 */
	
public void doubleclick(WebDriver driver) {
	
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
	
/**
 * this method will perform double click on WebElement
 * @param driver
 * @param element
 */
public void doubleclick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}

/**
 * this method will perform dragand drop  frm src to dest
 * @param driver
 * @param src
 * @param dest
 */

public void draganddrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, dest).perform();
}

/**
 * this method will move the cursor  offset and click
 * @param driver
 * @param x
 * @param y
 */
public void draganddrop(WebDriver driver,WebElement element,int x,int y)
{
	Actions act=new Actions(driver);
	act.dragAndDropBy(element, x, y).perform();
}

/**
 * this method will scroll down to 500 units
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.ScrollBy(0,500)","");
	
}
/**
 * this method will scroll up to the web element
 * @param driver
 * @param element
 */
public void scrollACtion(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("arguments[0].ScrollIntoview;",element);

}

/**
 * This method will accept alert pop up
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * This method will dismiss the alert pop up
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public String getAlertText(WebDriver driver)
{
	
	String msg=driver.switchTo().alert().getText();
	return msg;
}
/**
 * this method will handdle frame using index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * this method will handle frameusing string value
 * @param driver
 * @param name
 */
public void handleFrame(WebDriver driver,String name)
{
	driver.switchTo().frame(name);
}

/**
 * this method will handle frame using frame element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}

/**
 * this method will switch immediate parent from frame
 * @param driver
 */
public void switchToParentframe(WebDriver driver)
{
	driver.switchTo().parentFrame();
}

/**
 * This method will switch to default page
 * @param driver
 */
public void switchToDefaultContent(WebDriver driver)
{
	driver.switchTo().defaultContent();
	
}
/**
 * this method is used to switch window
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle)
{
//step1 capture alla the window ids
	Set<String> allids=driver.getWindowHandles();
//step2 navigate through all the window	
	for(String id:allids)
	{
		//step3mswitch to each window and capture the title
		String actualTitle=driver.switchTo().window(id).getTitle();
		//step 4 compare the actual title with partialwindow tile
		if(actualTitle.contains(partialWindowTitle))
		{
			break;
		}
	}
}
/**
 * this method will take sceenshot
 * @param driver
 * @param screenshotname
 * @return
 * @throws Throwable
 */
public String captureScreenShot(WebDriver driver,String screenshotname) throws Throwable
{
	
	TakesScreenshot sh=(TakesScreenshot)driver;
	File src=sh.getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\screenshots"+screenshotname+".png");
	
	Files.copy(src, dest);
	
	return dest.getAbsolutePath(); //used for extend reporting
}






}