package com.hms.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate random numbers
	 * @return int
	 */
public int createRandomNumber() {
	Random random = new Random();
	int randomNum = random.nextInt(500);
	return randomNum;
}
/**
 * This method will return today's date
 * @return String
 */
public String getSystemDate() {
	Date date = new Date();
	String todayDate = date.toString();
	return todayDate;
}
/**
 * This method will return today's date and current time in format
 * @return String
 */
public String getSystemDateInFormat() {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh-MM-ss");
	String formattedDate = dateFormat.format(date);
	return formattedDate;
}
}
