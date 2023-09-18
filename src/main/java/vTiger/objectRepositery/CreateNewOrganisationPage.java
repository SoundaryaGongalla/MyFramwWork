package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage {
//declaration
	@FindBy(name="accountname")
	private WebElement organisationTextBox;
	
	@FindBy(name = "industry") private WebElement industryDropDown;
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//initialisation
	
	public CreateNewOrganisationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

//uitilisation
	public WebElement getOrganisationTextBox() {
		return organisationTextBox;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	// create businessLibrary
	public void CreateNewOrganisation(String ORGNAME)
	{
		organisationTextBox.sendKeys(ORGNAME);
		saveButton.click();
	}
	
	WebDriverUtility wutil=new WebDriverUtility();
	/**
	 * this method will createOrganistionwith industry
	 * @param ORGNAME
	 * @param INDUSTRYTYPE
	 */
	public void CreateOrganisationWithIndustry(String ORGNAME,String INDUSTRYTYPE)
	{
		wutil.handleDropDown(industryDropDown, INDUSTRYTYPE);
		
		organisationTextBox.sendKeys(ORGNAME);
//	handleDropDown(industryDropDown, INDUSTRYTYPE);
	saveButton.click();
	}

	
	
	
}
