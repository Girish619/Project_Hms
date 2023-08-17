package com.hms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method will take key and returns the respected value
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
public String readPropertyFile(String key) throws FileNotFoundException, IOException {
	Properties property = new Properties();
	property.load(new FileInputStream(IPathConstants.filePath));
	String value = property.getProperty(key);
	return value;
}
/**
 * This method takes key and value and write it in property file
 * @return void
 * @param key
 * @param value
 * @throws FileNotFoundException
 * @throws IOException
 */
public void writePropertyFile(String key, String value) throws FileNotFoundException, IOException {
	Properties property = new Properties();
	property.load(new FileInputStream(IPathConstants.filePath));
	property.put(key, value);
	property.store(new FileOutputStream(IPathConstants.filePath),"New Data");
}
}
