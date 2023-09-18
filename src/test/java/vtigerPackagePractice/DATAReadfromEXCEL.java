package vtigerPackagePractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DATAReadfromEXCEL {

	public static void main(String[] args) throws Throwable, IOException {
		
//		step1 open the document in java readable format
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Documents\\VTIGER\\TestData.xlsx");
		
		
//		step 2 create workbook
		Workbook book=WorkbookFactory.create(fis);
		
//		step3 navigate to required sheet
		Sheet sh=book.getSheet("Contacts");
		
//		step4 navigate to required row
		Row rw=sh.getRow(0);
//		step5 navigate to required cell
		Cell cell=rw.getCell(0);
		//step 6 read the data inside the cell
		String data=cell.getStringCellValue();
		System.out.println(data);
		
//		step6 close workbook
		book.close();
		
	}
}
