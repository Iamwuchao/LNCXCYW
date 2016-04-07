package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mode.News;
import mode.NewsCategory;

public class NewsDao extends BaseDaoImpl<News,Integer> {
	
	public NewsDao(){
		super.setClass(News.class);
	}
	
	/*
	 * 按时间顺序获得最近的count条记录,start为起点
	 */
	public List<News> getNewsSubList(NewsCategory category,int start,int count){
			Session session = getSession();
			Criteria criteria = session.createCriteria(this.getClass());
			criteria.add(Restrictions.eq("category.categoryId", category.getCategoryId()));
			criteria.addOrder(Order.desc("date"));
			List<News> result = this.findPagination(criteria, start, start+count-1);
			return result;
	}
}
