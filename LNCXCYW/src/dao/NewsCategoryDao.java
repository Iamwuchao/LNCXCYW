package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mode.NewsCategory;
public class NewsCategoryDao extends BaseDaoImpl <NewsCategory,Integer>{
	public NewsCategoryDao(){
		super.setClass(NewsCategory.class);
	}
	
	public List<NewsCategory> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Criteria crit = session.createCriteria(NewsCategory.class);
		List<NewsCategory> list = crit.list();
		transaction.commit();
		session.close();
		return list;
	}
}
