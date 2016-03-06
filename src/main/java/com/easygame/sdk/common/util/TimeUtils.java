package com.easygame.sdk.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 时间工具类 */
public class TimeUtils {

	public static String getNowDate(String format) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		
		return formatter.format(new Date());
		
	}
	
	public static String getFirstDayOfThisMonth(){
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		return formatter.format(c.getTime());
		
	}
	
	public static String getThisMonth() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		
		return formatter.format(new Date());
		
	}
	
}
