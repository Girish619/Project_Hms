package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
public static void main(String[] args) throws Exception {
	Workbook excel = WorkbookFactory.create(new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"));
	excel.getSheet("Sheet1").getRow(0).getCell(0).setCellValue("Girish.R");
	//FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	excel.write(new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx"));

	excel.close();
}
}
