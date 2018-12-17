package com.blb.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String TIME_PATTREN="yyyy-MM-dd HH:mm:ss";
    /**
	 * 
	 */
	private DateUtil() {
		// do nothing
	}

	public static final Logger logger = Logger.getLogger(DateUtil.class.getName());
    public static String getDateStr(Date date,String pattern){
        SimpleDateFormat df=new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df.format(date);
    }
    public static Date getDate(String dateStr,String pattern){
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            return df.parse(dateStr);
        } catch (Exception ex) {
            logger.error("error:", ex);
        }
        return null;
    }
    
}
