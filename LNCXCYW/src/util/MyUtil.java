package util;

import java.sql.Date;

public class MyUtil {
	public static Date getSqlDate(){
		Date currentDate = new Date(System.currentTimeMillis());
		return currentDate;
	}
}
