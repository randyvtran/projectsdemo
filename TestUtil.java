package com.crm.qa.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	static Workbook wb;
	static Sheet sheet;
	 
	
	
	public void switchToFrame() {
		driver.switchTo().frame("framename");
	}


	public static Object[][] getTestData(String sheetname) {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Selenium_training\\LearnToCode\\src\\DataDrivenEx\\JobTitle.xlsx");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb = WorkbookFactory.create(file);
		
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		sheet = wb.getSheet(sheetname);
	
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for (int i=0; i < sheet.getLastRowNum(); i++) {
			
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i+1).getCell(i+1).toString();
			}
		}
		
		return data;
	}
		
	




}
