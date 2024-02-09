package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class Data extends TestBase 
{
	public static String[][] setdata(String sheetname) throws Throwable {

		File file = new File("./src/main/java/com/testdata/Frame.xlsx");
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows - 1][columns];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		
		return data;
		
	}
	
	public static void takeScreenShotEndOfTest() throws Throwable
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(dest + "/Envison/"+ System.currentTimeMillis()+".png"));
	}

}
