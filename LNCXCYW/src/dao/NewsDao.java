package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import GlobalInfo.PathInfo;
import cache.Cache;
import mode.News;
import mode.NewsCategory;
import util.JspToHTML;

public class NewsDao extends BaseDaoImpl<News,Integer> {
	
	public NewsDao(){
		super.setClass(News.class);
	}
	
	/*
	 * 按时间顺序获得最近的count条记录,start为起点,针对某一栏目
	 */
	public List<News> getNewsSubListOrderByDate(NewsCategory category,int start,int count){
			Session session = getSession();
			Criteria criteria = session.createCriteria(News.class);
			criteria.add(Restrictions.eq("category.categoryId", category.getCategoryId()));
			criteria.addOrder(Order.desc("date"));
			List<News> result = this.findPagination(criteria, start, count);
			System.out.println("getNewsSubList "+result.size());
			session.close();
			return result;
	}
	
	/*
	 * 按时间顺序获取新闻列表 
	 */
	public List<News> getNewsSubListOrderByDate(int start,int count){
		Session session = getSession();
		Criteria criteria = session.createCriteria(News.class);
		criteria.addOrder(Order.desc("date"));
		List<News> result = this.findPagination(criteria, start, count);
		session.close();
		return result;
	}
	
	/*
	 * 按时间范围查询新闻
	 * 
	 * sql.Date
	 */
	public List<News> getNewsListByDate(Date start, Date end) throws Exception{
		System.out.println("getNewsByDate:");
		List<News> re=new ArrayList<News>();
		if(start.after(end)){
			throw new Exception("wrong date!");
		}
		Session session=getSession();
		Criteria criteria=session.createCriteria(News.class);
		criteria.add(Restrictions.between("date", start, end));
		re=criteria.list();
		System.out.println(re);
		return re;
	}
	
	
	
	/**
	 * 保存新闻 
	 * @param title
	 * @param author
	 * @param content
	 * @param category
	 * @throws Exception
	 */
	public static void newsSave(String title, String author, String content, String category) throws Exception{
		String newcontent = "";
		newcontent=JspToHTML.getJspOutput("/jsp/third/third_page.jsp");
		//System.out.println("#########################");
		//System.out.println(newcontent);
		
		String address;
		try{
			address=util.JspToHTML.writeHTML(PathInfo.NEWSPATH,newcontent);
		}catch(Exception e){
			throw new Exception("JspToHTML false!");
		}
		NewsCategory newsCategory=Cache.getNewsCategorybyName(category);
		newsCategory.setNewscategory(category);
		Date date=new Date(new java.util.Date().getTime()); 
		
		News news=new News();		
		news.setAuthor(author);
		news.setNewsTile(title);
		news.setNews_address(address);
		news.setDate(date);
		news.setCategory(newsCategory);
	
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		if(!dao.save(news)){
			throw new Exception("dao false!");
		}
		Cache.updateNews(category, news);
	}
	
	
}
