package dao;

import java.util.concurrent.ConcurrentHashMap;

public class DaoFactory {
	private static ConcurrentHashMap<Class,BaseDao> daoMap = new ConcurrentHashMap<Class,BaseDao>();
	public static BaseDao getDaoByName(Class daoclass){
		return  daoMap.computeIfAbsent(daoclass,(key)->{
			try {
				BaseDao dao =  (BaseDao)key.newInstance();
				dao.setClass(key);
				return dao;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		});
	}
	
}
