package vtigerPackagePractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedatainECEL {
	public static void main(String[] args) throws Throwable {
		
		
//		step1:OPen doc in java readable format
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");
		
//		step2:create workbook
		Workbook book=WorkbookFactory.create(fis);
//		step3:navigate to sheet
		Sheet sh=book.createSheet("pizza");
//		step4: navigate to row
		
		Row rw=sh.createRow(0);
//		step5:navigate to cell
		Cell ce=rw.createCell(0);
//		step6:provide data  to be written
		ce.setCellValue("selenium");
//		step7:provide the doc in java write format
		FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\Selenium\\qco-soeajd-A1\\src\\test\\resources\\TestData.xlsx");
		
//		step to write data in book
		book.write(fos);
		System.out.println("add succesfully");
		
//		step8:close the data
		book.close();
		
		
		
		
		
		
		
		
	}

}
