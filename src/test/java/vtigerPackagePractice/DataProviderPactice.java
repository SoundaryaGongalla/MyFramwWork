package vtigerPackagePractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPactice {
@Test(dataProvider = "testData")
public void addToCart(String pname,String model,int price)
{
	System.out.println(pname);
	System.out.println(model);
	System.out.println(price);

}
	
	@DataProvider
	public Object[][] testData()
	{
		
		Object[][] data=new Object[4][3];
		
		data[0][0]="Samsung";
		data[0][1]="A1";
		data[0][2]=37000;
		
		
		data[1][0]="Vivo";
		data[1][1]="V1pro";
		data[1][2]=3500;
		
		

		data[2][0]="Iphone";
		data[2][1]="promax";
		data[2][2]=355674;
		
		

		data[3][0]="Redmi";
		data[3][1]="Note9";
		data[3][2]=3334;
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
