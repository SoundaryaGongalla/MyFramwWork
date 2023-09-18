package vtigerOranisationtest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.objectRepositery.CreateNewOrganisationPage;
import vTiger.objectRepositery.CreateOrganisationsPage;
import vTiger.objectRepositery.HomePage;
import vTiger.objectRepositery.OrganisationInfoPage;
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.ExcelFileUtility;
import vtigerGenericUtilities.JavaFileutility;

public class CreateOrgnaistionWithMultipleIndustry extends BaseClass {

	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaFileutility jutil=new JavaFileutility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgWithIndustry(String ORGNAME,String INDUSTRY) throws InterruptedException
	{
		HomePage hpage=new HomePage(driver);
		
		Thread.sleep(3000);
			hpage.clickorganisationLink();
	//	hpage.getOranisationLink().click();
		
//		step create new Organisation look up img
		CreateOrganisationsPage corgpage=new CreateOrganisationsPage(driver);
		corgpage.clickOnOrganisationLookUpImg();
//		step 6  create Organisation with mandatory info
		//	ExcelFileUtility eutil=new ExcelFileUtility();
			JavaFileutility jutil=new JavaFileutility();
//			String ORGNAME=eutil.readDataFromExcel("Organisation", 4, 2)+jutil.getrandomNumber();
	//		String INDUSTRY=eutil.readDataFromExcel("Organisation", 4, 3);	
//	System.out.println(ORGNAME);
//	System.out.println(INDUSTRY);
	CreateNewOrganisationPage cNewOrgPage=new CreateNewOrganisationPage(driver);
	cNewOrgPage.CreateOrganisationWithIndustry(ORGNAME+jutil.getrandomNumber(), INDUSTRY);
		//	cNewOrgPage.CreateOrganisationWithIndustry(ORGNAME, INDUSTRY);
	//cNewOrgPage.CreateNewOrganisation(ORGNAME);
//		step7  validate
	OrganisationInfoPage oIpage=new OrganisationInfoPage(driver);

	//if(oIpage.getOrgHeader().equals(ORGNAME))

	String header=oIpage.orgHeaderText();
	System.out.println(header);
	  // if(header.equalsIgnoreCase(ORGNAME))
	if(header.contains(ORGNAME))	
	{
			System.out.println("pass"+header);
		}
		else
		{
			System.out.println("fail"+oIpage.orgHeaderText());
		}
			
			
		
		}
	
//		System.out.println(ORGNAME+"---"+INDUSTRY);
		
	
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		Object[][] data=eutil.readMultipleDataFromExcel("MultipleOrgIndustry");
		
		return data;
		
	}
	
	
}
