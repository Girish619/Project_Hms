package com.hms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * This method will read the data from property file and return value for respective key
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
public String getValue(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	String value = workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	workBook.close();
	return value;
}
/**
 * This method will write data into excel
 * @return void
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param value
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
public void writeData(String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, FileNotFoundException, IOException {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
	workBook.write(new FileOutputStream(IPathConstants.excelPath));
	workBook.close();
}
/**
 * This method will return row count
 * @param sheetName
 * @return int
 * @throws Exception
 */
public int lastRowNumber(String sheetName) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	int rowCount = workBook.getSheet(sheetName).getLastRowNum();
	workBook.close();
	return rowCount;
}
/**
 * This method will return column count
 * @param sheetName
 * @return int
 * @throws Exception
 */
public int lastColumnNumber(String sheetName) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	int columnCount = workBook.getSheet(sheetName).getRow(0).getLastCellNum();
	workBook.close();
	return columnCount;
}
/**
 * This method will fetch multiple row in key value pair
 * @param sheetName
 * @param keyColumn
 * @param valueColumn
 * @return HashMap<String, String>
 * @throws Exception
 */
public HashMap<String, String> getMultipleKeyValue(String sheetName, int keyColumn, int valueColumn) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum();
	HashMap<String, String> map = new HashMap<String, String>();
	for (int i = 0; i <= rowCount; i++) {
		String key = sheet.getRow(i).getCell(keyColumn).getStringCellValue();
		String value = sheet.getRow(i).getCell(valueColumn).getStringCellValue();
		map.put(key, value);
	}
	workBook.close();
	return map;
}
/**
 * This method will fetch multiple row in key value pair enter it in name of element and sendKeys
 * @param sheetName
 * @param keyColumn
 * @param valueColumn
 * @return HashMap<String, String>
 * @throws Exception
 */
public HashMap<String, String> getMultipleKeyValueOnCondition(WebDriver driver, String sheetName, int keyColumn, int valueColumn, String expectedResult) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum();
	HashMap<String, String> map = new HashMap<String, String>();
	for (int i = 0; i <= rowCount; i++) {
		String key = sheet.getRow(i).getCell(keyColumn).getStringCellValue();
		String value = sheet.getRow(i).getCell(valueColumn).getStringCellValue();
		map.put(key, value);
	}
	JavaUtility jLib = new JavaUtility();
	for (Map.Entry<String, String> set : map.entrySet()) {
		if(set.getValue().contains(expectedResult)) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.createRandomNumber());
		}else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		
	}
	workBook.close();
	return map;
}
/**
 * This method will fetch multiple row for particular column
 * @param sheetName
 * @param columnNum
 * @return ArrayList<String>
 * @throws Exception
 */
public ArrayList<String> getMultipleRow(String sheetName, int columnNum) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum();
	ArrayList<String> rows = new ArrayList<String>();
	for (int i = 0; i <= rowCount; i++) {
		String value = sheet.getRow(i).getCell(columnNum).getStringCellValue();
		rows.add(value);
	}
	workBook.close();
	return rows;
}
/**
 * This method will fetch multiple column for particular row
 * @param sheetName
 * @param rowNum
 * @return ArrayList<String>
 * @throws Exception
 */
public ArrayList<String> getMultipleColumn(String sheetName, int rowNum) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet(sheetName);
	int columnCount = sheet.getRow(rowNum).getLastCellNum();
	ArrayList<String> columns = new ArrayList<String>();
	for (int i = 0; i <= columnCount; i++) {
		String value = sheet.getRow(rowNum).getCell(i).getStringCellValue();
		columns.add(value);
	}
	workBook.close();
	return columns;
}

/**
 * This method will provide multiple data  to data provider
 * @param Sheetname
 * @return Object[][]
 * @throws Exception
 */
public Object[][] getMultipleDataFromDPByExcel(String Sheetname) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet(Sheetname);
	int lastRow = sheet.getLastRowNum();
	int lastCell = sheet.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastRow][lastCell];
	for (int i = 1; i < lastRow+1; i++) {
		for (int j = 0; j < lastCell; j++) {
			obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}

}
