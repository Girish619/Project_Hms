package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoProperty {
public static void main(String[] args) throws Exception {
	Properties property = new Properties();
	
	property.put("browser", "chrome");
	property.put("url", "http://rmgtestingserver/domain/Hospital_Management_System/hms/doctor/");
	property.put("un", "nitesh@gmail.com");
	property.put("pwd", "Test@123");
	
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\HmsCommonData.Properties");
	property.store(fos, "HMS Common Data");
	
}
}
