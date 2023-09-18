package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
//DEclaration
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	@FindBy(linkText = "Organizations")
//	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement organisationLink;
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")  ////img[@src='themes/softed/images/user.PNG']
	private WebElement administrtion;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	//initialisation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOranisationLink() {
		return organisationLink;
	}
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	public WebElement getAdministrtion() {
		return administrtion;
	}
	public WebElement getSignoutLink() {

		
		return signoutLink;
	}
	
	//Business Library
	
	/**
	 * this method will logout the application
	 * @throws InterruptedException
	 */
	
	public void logout(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);

		mouseOverAction(driver, administrtion);
		Thread.sleep(2000);

		signoutLink.click();
		
	}
	/**
	 * this method will click on ORG link
	 */
	public void clickorganisationLink()
	{
		organisationLink.click();
	}
	
	/**
	 * this method will click on contact link
	 */
public void clickOnContactsLink()
{
	
	contactsLink.click();
}
	
public void clickOnProductsLink()
{
	ProductsLink.click();
}



}