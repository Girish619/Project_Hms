package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
public static void main(String[] args) throws Exception {
	Workbook excel = WorkbookFactory.create(new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"));
	int lastRow = excel.getSheet("Sheet1").getLastRowNum();
	for (int i = 0; i <= lastRow; i++) {
		System.out.println(excel.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue());	
//		int lastCell = excel.getSheet("Sheet1").getRow(i).getLastCellNum();
//		for (int j = 0; j <= lastCell; j++) {
//			System.out.println(excel.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue());	
//		}
	}
	excel.close();
}
}
