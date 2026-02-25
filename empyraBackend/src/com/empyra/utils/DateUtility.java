package com.empyra.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	public String getDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

	    String formattedDate = ldt.format(myFormatObj);
	    return formattedDate;
	}
}
