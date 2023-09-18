package vtigerContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.objectRepositery.CreateContactsPage;
import vTiger.objectRepositery.CreateNewContactPage;
import vTiger.objectRepositery.CreateNewOrganisationPage;
import vTiger.objectRepositery.CreateOrganisationsPage;
import vTiger.objectRepositery.HomePage;
import vTiger.objectRepositery.LoginPage;
import vTiger.objectRepositery.OrganisationInfoPage;
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.ExcelFileUtility;
import vtigerGenericUtilities.JavaFileutility;
import vtigerGenericUtilities.PropertyFileUtility;
@Listeners(vtigerGenericUtilities.ListnersImpplementation.class)
public class CreateContactWithOranisationTest extends BaseClass{
	//WebDriver driver;
	
@Test
public void contact() throws Throwable
{
	
	JavaFileutility jutil=new JavaFileutility();
	String ORGNAME=eutil.readDataFromExcel("Contacts", 4, 2)+jutil.getrandomNumber();
	String LASTNAME=eutil.readDataFromExcel("Contacts", 4, 3)+jutil.getrandomNumber();	
	System.out.println(ORGNAME);
	System.out.println(LASTNAME);
	
	
	
	HomePage hp=new HomePage(driver);
	Thread.sleep(3000);
 hp.clickorganisationLink();
//hp.getOranisationLink().click();

CreateOrganisationsPage cpage=new CreateOrganisationsPage(driver);
cpage.clickOnOrganisationLookUpImg();

CreateNewOrganisationPage cnewPage=new CreateNewOrganisationPage(driver);
ExcelFileUtility eutil=new ExcelFileUtility();

CreateNewOrganisationPage cNewOrgPage=new CreateNewOrganisationPage(driver);
cNewOrgPage.CreateNewOrganisation(ORGNAME);

 // cNewOrgPage.getSaveButton().click();



// Assert.fail();
OrganisationInfoPage opage=new OrganisationInfoPage(driver);
String header=opage.orgHeaderText();

//if(header.contains(ORGNAME))
	Assert.assertTrue(header.contains(ORGNAME));

	System.out.println("pass    :"+header);


// click contact link
	hp.clickOnContactsLink();
CreateContactsPage ccp=new CreateContactsPage(driver);
Thread.sleep(2000);
ccp.clickOnContactsLookUpImg();

CreateNewContactPage ccot=new CreateNewContactPage(driver);


ccot.createNewContact(ORGNAME, LASTNAME, driver);

 // hp.getSignoutLink();
}
}































