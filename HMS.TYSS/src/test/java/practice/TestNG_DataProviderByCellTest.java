package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.IPathConstants;

public class TestNG_DataProviderByCellTest {
	

//	public Object[][] getMultipleDataFromDPByExcelCell(String Sheetname) throws Exception {
//		Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
//		Sheet sheet = workBook.getSheet(Sheetname);
//		int lastRow = sheet.getLastRowNum();
//		int lastCell = sheet.getRow(0).getLastCellNum();
//		Object[][] obj = new Object[lastRow+1][lastCell];
//		for (int i = 0; i < lastRow; i++) {
//			for (int j = 1; j < lastCell; j++) {
//				obj[i][j-1] = sheet.getRow(i).getCell(j).getStringCellValue();
//				
//			}
//		}
////		for (int i = 0; i < lastRow; i++) {
////			for (int j = 1; j < lastCell; j++) {
////				
////				System.out.println(obj[i][j]);
////			}
////		}
//		return obj;
//	}
//	
//	
//	public static void main(String args[]) throws Throwable {
//		TestNG_DataProviderByCellTest t = new TestNG_DataProviderByCellTest();
//		Object[][] d = t.getMultipleDataFromDPByExcelCell(IPathConstants.patientMedicalHistory);
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
//				
//				System.out.println(d[i][j]);
//			}
//		}
//	}
	
	
	
	public static void main(String args[]) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		Object[][] obj = eLib.getMultipleDataFromDPByExcel("Appointments");
		System.out.println(obj);
	}
}
