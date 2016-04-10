package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
	/**
	 * 根据查询满足条件的标签项，获取新闻列表
	 * @param name
	 * @param value
	 * @return
	 */
	public List<NewsCategory> findNewsCategoryByTag(String name, Object value){
		List<NewsCategory> list;
		Session session = getSession();
		Criteria crit = session.createCriteria(NewsCategory.class);
		list = crit.add(Restrictions.eqOrIsNull(name, value)).list();
		session.close();
		return list;
		
	}
}
