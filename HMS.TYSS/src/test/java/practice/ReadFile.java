package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFile {
public static void main(String[] args) throws Exception {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
	Properties property = new Properties();
	property.load(fis);
	
	String irctc = property.getProperty("irctc");
	String cern = property.getProperty("cern");
	
	System.out.println(irctc);
	System.out.println(cern);
	
	Workbook excel = WorkbookFactory.create(new FileInputStream(".\\src\\test\\resources\\TestData.xlsx"));
	System.out.println(excel.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue());
	System.out.println(excel.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
	excel.close();
}
}
