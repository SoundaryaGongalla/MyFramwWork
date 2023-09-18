package vtigerGenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class provides implementation  for IretryAnalyser interface for testNg
 * @author admin
 *
 */
public class IretryAnalzerImplementation implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		
		int count =0;
		int retrycount=2;
		while(count<retrycount)
		{
			count++;
			return true;
			
		}
		return false;
	}

	
	
	
}
