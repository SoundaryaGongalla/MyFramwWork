package vtigerGenericUtilities;
/**
 * /*This class consists of generic method related to EXCEL file
 * 
 * @author soundarya
 *
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	/**
	 * this method is used to read data from excel
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
public String readDataFromExcel(String sheetname,int row,int cell) throws Throwable, IOException
{
DataFormatter df=new DataFormatter();	

FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");
Workbook book=WorkbookFactory.create(fis);
String d=book.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
book.close();
return d;
}



/**
 * This method is used to write the data in excel
 * 
 * @param sheetname
 * @param row
 * @param cell
 * @param value
 * @throws Throwable
 */
public void writeDataInExcel(String sheetname,int row,int cell,String value) throws Throwable
{
	FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");

	Workbook book=WorkbookFactory.create(fis);
	book.createSheet(sheetname).createRow(row).createCell(cell).setCellValue(value);
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");

	book.write(fos);
	book.close();
	
}

/**
 * this method  will read multiple data from excel for the provided sheet
 * @param sheetname
 * @return
 * @throws Throwable
 * @throws Throwable
 */
public Object[][] readMultipleDataFromExcel(String sheetname) throws Throwable, Throwable
{
	FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\multiplteOrgNameWithIndustry.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	int lastRow=sh.getLastRowNum();
	int lastcel=sh.getRow(0).getLastCellNum();
	
	Object[][]data=new Object[lastRow][lastcel];
	for(int i=0;i<lastRow;i++) // i=0 is header column we dont want 
	{
		for(int j=0;j<lastcel;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			
		}
	}
	return data;
}











}