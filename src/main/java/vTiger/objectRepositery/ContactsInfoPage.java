package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeader;
	//initialisation
	public ContactsInfoPage(WebDriver driver) {
	 
			PageFactory.initElements(driver, this);

	}
	//uitlisation
	public WebElement getOrgHeader() {
		return orgHeader;
	}
		//Create bussiness library
	/*
	 * this method will the orPHeader text (Contact inforamtion
	 */
	public String orgHeaderText()
	{
		return orgHeader.getText();
		
	}

}
