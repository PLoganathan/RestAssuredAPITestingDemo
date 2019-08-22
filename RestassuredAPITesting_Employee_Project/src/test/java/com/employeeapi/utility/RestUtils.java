package com.employeeapi.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName() {
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return("john"+generatedString);
	}
	
	public static String empSal() {
		String generatedString=RandomStringUtils.randomNumeric(5);
		return(generatedString);
	}
	
	public static String empAge() {
		String generatedString=RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}
}
