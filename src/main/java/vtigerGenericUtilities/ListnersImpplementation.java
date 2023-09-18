package vtigerGenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImpplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	
	String methodname=result.getMethod().getMethodName();
	System.out.println(methodname+"---pass");
	
	}

	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();

		System.out.println(methodname+" ---on test success");

	}

	public void onTestFailure(ITestResult result) {
	
		
		
	String methodname	=result.getMethod().getMethodName();
		WebDriverUtility wutil=new WebDriverUtility();
		JavaFileutility jutil=new JavaFileutility();
		String screenshotname=methodname+jutil.getSystemDate();
		try {
			wutil.captureScreenShot(BaseClass.driver, screenshotname);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+" ---on test skipped");

	}

	public void onStart(ITestContext result) {
//		String methodname=((ITestResult) result).getMethod().getMethodName();
//
//		System.out.println(methodname+" --- start");
System.out.println("started");
	}

	public void onFinish(ITestContext result) {
//		String methodname=((ITestResult) result).getMethod().getMethodName();
//
//		System.out.println(methodname+" ---finish");
		System.out.println("finished");

	}
	

}
