package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import mode.NewsCategory;

public class NewsCategoryDao extends BaseDaoImpl <NewsCategory,Integer>{
	public NewsCategoryDao(){
		super.setClass(NewsCategory.class);
	}
	
	
	public List<NewsCategory> getAll(){
		Session session = getSession();
		Criteria crit = session.createCriteria(NewsCategory.class);
		crit.addOrder(Order.asc("categoryId"));
		@SuppressWarnings("unchecked")
		List<NewsCategory> list = crit.list();
		session.close();
		return list;
	}
}
