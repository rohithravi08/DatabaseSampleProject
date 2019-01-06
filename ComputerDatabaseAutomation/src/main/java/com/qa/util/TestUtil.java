package com.qa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public String dateConversion(String oldDate) {
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		
			try { 
			cal = Calendar.getInstance(); 
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(oldDate)); 
			sdf = new SimpleDateFormat("dd MMM yyyy");	
			
			} catch (ParseException e) 
			{ 
				e.printStackTrace(); 
			}
			return sdf.format(cal.getTime());
		 

	}
	
}
