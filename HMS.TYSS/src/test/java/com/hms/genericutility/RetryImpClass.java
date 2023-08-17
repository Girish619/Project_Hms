package com.hms.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{

	int count = 0;
	int retryLimit = 3;
	public boolean retry(ITestResult result) {
		
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

	
	
}
