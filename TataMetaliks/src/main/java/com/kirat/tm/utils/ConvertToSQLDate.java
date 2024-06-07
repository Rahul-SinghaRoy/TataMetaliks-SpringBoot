package com.kirat.tm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConvertToSQLDate {

	public String SQLDateFormatGenerator(String dateString) throws ParseException {
		// TODO Auto-generated method stub
		//String dateStr = "Mon Oct 18 00:00:00 IST 2012";
		//System.out.println(dateString);    
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = (Date)formatter.parse(dateString);
		//System.out.println(date);        

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
		String formatedDate =  cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +cal.get(Calendar.DATE);
		
		//System.out.println("formatedDate : " + formatedDate);
		return formatedDate;

	}

}
