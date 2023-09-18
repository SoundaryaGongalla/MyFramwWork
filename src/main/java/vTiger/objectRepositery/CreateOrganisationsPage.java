package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class consists of all modules in ORg page
 * @author admin
 *
 */
public class CreateOrganisationsPage {
//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organisationLookupImg;
//initialisation
	public CreateOrganisationsPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	//utitilistaion
	public WebElement getOrganisationLookupImg() {
		
		return organisationLookupImg;
	}
	
	//create business librariesD
	/**
	 * this method will click on lookup img
	 */
	public void clickOnOrganisationLookUpImg()
	{
		organisationLookupImg.click();
	}
	
}
