package util;

import java.sql.Date;

import dao.DaoFactory;
import dao.NewsDao;

public class MyUtil {
	public static Date getSqlDate(){
		Date currentDate = new Date(System.currentTimeMillis());
		return currentDate;
	}
	
	public static void updateClick(String url){
		System.out.println("更新访问量："+url);
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		dao.increaseClick(url);
		return;
	}
}
