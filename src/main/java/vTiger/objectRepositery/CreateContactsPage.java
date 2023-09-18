package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactLookUpImg;
	
	
	

	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public WebElement getContactLookUpImg() {
		return contactLookUpImg;
	}

	//create businessLibrary
	public void clickOnContactsLookUpImg()
	{
		contactLookUpImg.click();
	}
}
