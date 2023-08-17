package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderTest {
	
	@DataProvider
public Object[][] data(){
	Object[][] obj = new Object[2][3];
	obj[0][0] = "Girish";
	obj[0][1] = "bangalore";
	obj[0][2] = "KST";
	
	obj[1][0] = "Kiran";
	obj[1][1] = "bangalore";
	obj[1][2] = "Laggere";
	return obj;
}
	@Test(dataProvider = "data")
	public void testing(String name, String city, String area) {
		System.out.println(name+"--->"+city+"--->"+area);
	}
}
