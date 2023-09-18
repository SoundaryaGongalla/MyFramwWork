package vtigerPackagePractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(vtigerGenericUtilities.ListnersImpplementation.class)
public class ListnerPractice {

	@Test
	public void demo()
	{
		Assert.fail();
	System.out.println("hello");
	}
	
}
