package vTiger.objectRepositery;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.ExcelFileUtility;

public class CreateNewContactPage {

	@FindBy(name = "lastname") private WebElement lastNameTextBox;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateNewContactPage(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
// business Librar
	public void CreateLastnameandSave(String LASTNAME)
	{
		lastNameTextBox.sendKeys(LASTNAME);
		saveButton.click();
		
	}
	
	public void createNewContact(String ORGNAME,String LASTNAME, WebDriver driver) throws Throwable
	{
		
		lastNameTextBox.sendKeys(LASTNAME);
		//input[@name='account_id']/following-sibling::img
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		
		//step7 switch to control to child window
		String mainid=driver.getWindowHandle();
		Set<String>allWinids=driver.getWindowHandles();
		for(String id:allWinids)
		{
			if(!mainid.equals(id))
			{
				driver.switchTo().window(id);

	System.out.println("window switched to child window");			
				
		//	break;
			
		//driver.switchTo().window(mainid);
//		step8 search for organistaion
		Thread.sleep(3000);
	WebElement ele=	driver.findElement(By.id("search_txt"));
	ele.sendKeys(ORGNAME);

		driver.findElement(By.name("search")).click();
			
//	driver.findElement(By.xpath("//a[.='a']")).click();
			driver.findElement(By.xpath("//tr[@class='lvtColData']")).click();
				
		}
		}
	//step 9 save
//
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	saveButton.click();
		Thread.sleep(3000);


	// step 10 validate

	String orgheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

	if(orgheader.contains(ORGNAME))

	{
		System.out.println(ORGNAME+"pass");
	}
		
		
		
	}
	
	
	
}
