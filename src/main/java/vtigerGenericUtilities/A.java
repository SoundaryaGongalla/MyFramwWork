package vtigerGenericUtilities;

import java.io.IOException;

public class A {
public static void main(String[] args) throws Throwable, Throwable {
	ExcelFileUtility eutil=new ExcelFileUtility();
	String data =eutil.readDataFromExcel("Organisation", 1, 1);
	System.out.println(data);
}
}
