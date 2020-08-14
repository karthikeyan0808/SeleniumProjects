package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	// Creating static variables for load time and implicit wait which can be used
	// in the base class using the class name

	public static long PAGE_LOAD_TIME = 20;

	public static long IMPLICIT_WAIT = 10;

	// Creating a common method for switching between frames

	public void switchToFrame() {

		driver.switchTo().frame("mainpanel");

	}

	static Workbook book;
	static Sheet sheet;

	public static String TESTDATA_SHEETPATH = "C:\\Users\\K\\Desktop\\FreeCRMTestData.xlsx\\";

	// creating a two dimensional array for reading and storing the values from the
	// cell

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATA_SHEETPATH);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		/*
		 * System.out.println(sheet.getLastRowNum()); sheet.getRow(0).getLastCellNum();
		 */

		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		
		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir = System.getProperty("user.dir");
		
	
		
		FileUtils.copyFile(scrFile , new File(currentDir + "/screenshot/" + System.currentTimeMillis() + ".png"));
	}

}










