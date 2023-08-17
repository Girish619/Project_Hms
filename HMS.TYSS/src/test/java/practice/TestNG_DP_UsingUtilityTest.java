package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.genericutility.ExcelUtility;
import com.hms.genericutility.IPathConstants;

public class TestNG_DP_UsingUtilityTest {
	@DataProvider(name="doc")
	public Object[][] data() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		Object[][] obj = eLib.getMultipleDataFromDPByExcel(IPathConstants.dataProvider);
		return obj;
	}
		@Test(dataProvider = "doc")
		public void testData(String doc, String patient, String issue, String prescription) {
			System.out.println(doc+" | "+patient+" | "+issue+" | "+prescription);
		}
}
