package vtigerOranisationtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.objectRepositery.CreateNewOrganisationPage;
import vTiger.objectRepositery.CreateOrganisationsPage;
import vTiger.objectRepositery.HomePage;
import vTiger.objectRepositery.OrganisationInfoPage;
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.ExcelFileUtility;
import vtigerGenericUtilities.JavaFileutility;
@Listeners(vtigerGenericUtilities.ListnersImpplementation.class)
public class CreateOranisatioWithIndustryTest extends BaseClass{

@Test
	public void t() throws Throwable, Throwable
	{
	HomePage hpage=new HomePage(driver);
	
	Thread.sleep(3000);
	//	hpage.clickorganisationLink();
	hpage.getOranisationLink().click();
	
//	step create new Organisation look up img
	CreateOrganisationsPage corgpage=new CreateOrganisationsPage(driver);
	corgpage.clickOnOrganisationLookUpImg();
//	step 6  create Organisation with mandatory info
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaFileutility jutil=new JavaFileutility();
		String ORGNAME=eutil.readDataFromExcel("Organisation", 4, 2)+jutil.getrandomNumber();
		String INDUSTRY=eutil.readDataFromExcel("Organisation", 4, 3);	
System.out.println(ORGNAME);
System.out.println(INDUSTRY);
CreateNewOrganisationPage cNewOrgPage=new CreateNewOrganisationPage(driver);
cNewOrgPage.CreateOrganisationWithIndustry(ORGNAME, INDUSTRY);
	//	cNewOrgPage.CreateOrganisationWithIndustry(ORGNAME, INDUSTRY);
//cNewOrgPage.CreateNewOrganisation(ORGNAME);
//	step7  validate
OrganisationInfoPage oIpage=new OrganisationInfoPage(driver);

//if(oIpage.getOrgHeader().equals(ORGNAME))

String header=oIpage.orgHeaderText();
System.out.println(header);
if(header.equalsIgnoreCase(ORGNAME))
	{
		System.out.println("pass"+header);
	}
	else
	{
		System.out.println("fail"+oIpage.orgHeaderText());
	}
		
		
	
	}

	
	
@Test(groups = "SmokeSuite")
public void demo()
{
	System.out.println("this this demo");
}
}