package vtigerPackagePractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class IretryAnalyzerPractice {
@Test(retryAnalyzer = vtigerGenericUtilities.IretryAnalzerImplementation.class)
	public void demo()
	{
		Assert.fail();
		System.out.println("hello");
	}
	
	
}
