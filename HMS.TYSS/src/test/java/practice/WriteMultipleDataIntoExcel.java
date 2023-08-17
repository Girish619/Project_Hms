package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataIntoExcel {
public static void main(String[] args) throws Exception {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(".\\src\\test\\resources\\hmsTestData.xlsx"));
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of rows");
	int rowCount = sc.nextInt();
	System.out.println("Enter number of columns");
	int columnCount = sc.nextInt();
	Sheet sheet = workBook.getSheet("Practice");
	for (int i = 0; i < rowCount; i++) {
		for (int j = 0; j < columnCount; j++) {
			System.out.println("Enter cell value");
			sheet.createRow(i).createCell(j).setCellValue(sc.next());
		}
	}
	workBook.write(new FileOutputStream(".\\src\\test\\resources\\hmsTestData.xlsx"));
	workBook.close();
	sc.close();
	
}
}
