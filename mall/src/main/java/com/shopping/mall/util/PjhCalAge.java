package com.shopping.mall.util;

import java.util.Calendar;
import java.util.Date;

public class PjhCalAge {

	public static int getAges(Date birth) {
		
		Date current = new Date();
		
		Calendar cal = Calendar.getInstance();
				 cal.setTime(current);

		int cYear = cal.get(Calendar.YEAR);
		
		         cal.setTime(birth);
		         
		int bYear =  cal.get(Calendar.YEAR);
		
		int gap = cYear - bYear;
		
		System.out.println(gap);
		
		return gap > 9 ? (gap - (gap % 10)) / 10 : 0;
	}
	
}
