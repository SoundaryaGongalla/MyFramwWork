package vTiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	// declaration
@FindBy(className = "dvHeaderText")
private WebElement orgHeader;
//initialisation
public OrganisationInfoPage(WebDriver driver) {
PageFactory.initElements(driver, this);

}
//uitlisation
public WebElement getOrgHeader() {
	return orgHeader;
}
	//Create bussiness library
/**
 * this method will return header
 * @return
 */
public String orgHeaderText()
{
	String header=orgHeader.getText();
	return header;
	
}


}
