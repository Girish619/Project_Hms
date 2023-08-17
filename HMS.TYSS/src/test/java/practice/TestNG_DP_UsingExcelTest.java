package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.genericutility.IPathConstants;

public class TestNG_DP_UsingExcelTest {
	@DataProvider(name="doc")
public Object[][] data() throws Throwable {
	Workbook workBook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
	Sheet sheet = workBook.getSheet("DP");
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
	@Test(dataProvider = "doc")
	public void testData(String doc, String patient, String issue, String prescription) {
		System.out.println(doc+" | "+patient+" | "+issue+" | "+prescription);
	}
}
