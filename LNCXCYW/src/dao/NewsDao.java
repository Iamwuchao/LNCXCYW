package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
	 * 删除新闻
	 */
	public void deleteNewsById(int id) throws Exception{
		System.out.println("deleteNewsById: "+id);
		Session session=getSession();
		News news = null;
		try{
			Criteria criteria=session.createCriteria(News.class);
			criteria.add(Restrictions.eq("id", id));
			news=(News)criteria.list().get(0);
		}catch(Exception e){
			session.close();
			throw new Exception("wrong id!");
		}
		
		Transaction trans=session.beginTransaction();
		try{
			session.delete(news);
			trans.commit();
		}catch(Exception e){
			if(trans!=null){
				trans.rollback();
			}
			throw e;
		}finally{
			System.out.println("session close");
			session.close();
		}
		
		String address=PathInfo.ROOTPATH.getValue()+news.getNews_address();
		util.FileOperate.deleteFile(address);
		Cache.remove(news.getCategory().getNewscategory(), news);
	}
	
	
	/*
	 * 按时间顺序获得最近的count条记录,start为起点,针对某一栏目
	 */
	public List<News> getNewsSubListOrderByDate(NewsCategory category,int start,int count){
			Session session = getSession();
			Criteria criteria = session.createCriteria(News.class);
			criteria.add(Restrictions.eq("category.categoryId", category.getCategoryId()));
			criteria.addOrder(Order.desc("newsId"));
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
	 * 获取未处理的对接项目
	 */
	public List<News> getUnhandledProject(){
		Session session=getSession();
		Criteria criteria = session.createCriteria(News.class);
		criteria.add(Restrictions.eq("isPassed", 0));
		@SuppressWarnings("unchecked")
		List<News> result=criteria.list();
		return result;
	}
	
	/*
	 * 按userID查询
	 */
	@SuppressWarnings("unchecked")
	public List<News> getNewsListByID(int id){
		System.out.println("getNewsListByID:");
		List<News> re=new ArrayList<News>();
		Session session=getSession();
		Criteria criteria=session.createCriteria(News.class);
		criteria.add(Restrictions.eq("authorId", id));
		re=criteria.list();
		session.close();
		return re;
	}
	
	
	/*
	 * 按时间范围查询新闻
	 * 
	 * sql.Date
	 */
	@SuppressWarnings("unchecked")
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
		session.close();
		return re;
	}
	
	/*
	 * 按关键字查询
	 */
	@SuppressWarnings("unchecked")
	public List<News> getNewsListByKeyword(String keyword){
		System.out.println("getNewsByKeyword:"+keyword);
		List<News> re=new ArrayList<News>();
		Session session=getSession();
		Criteria criteria=session.createCriteria(News.class);
		criteria.add(Restrictions.like("newsTile", "%"+keyword+"%"));
		re=criteria.list();
		session.close();
		return re;
	}
	
	/*
	 * 按点击量查询
	 */
	@SuppressWarnings("unchecked")
	public List<News> getNewsListByClick(int n){
		System.out.println("getNewsListByClick:");
		List<News> re;
		Session session=getSession();
		Query q=session.createQuery("from News news order by news.clickNum desc");
		re=q.list();
		session.close();
		int len=re.size()>n? n:re.size();		
		return re.subList(0, len);
	}
	
	
	/*
	 * 更新点击量
	 */
	@SuppressWarnings("unchecked")
	public void increaseClick(String url){
		Session session=getSession();
		Criteria criteria=session.createCriteria(News.class);
		criteria.add(Restrictions.eq("news_address", url));
		List<News> list=criteria.list();
		if(list.isEmpty()){
			return;
		}
		News news=list.get(0);
		news.setClickNum(news.getClickNum()+1);
		Transaction trans=session.beginTransaction();
		try{
			session.update(news);
			trans.commit();
		}catch(Exception e){
			System.out.println("点击量跟新失败！"+e.getMessage());
		}finally{
			session.close();
		}		
		
		Cache.updateHotestNews(news);//更新缓存
	}
	
	
	/**
	 * 保存新闻 
	 * @param title
	 * @param author
	 * @param content
	 * @param category
	 * @param isPassed: 0 未处理； 1 不通过；2 通过
	 * @throws Exception
	 */
	public static void newsSave(String title, String author, int authorId, String content, String category, int isPassed, String pictureLink) throws Exception{
		String address;
		
		if(category.equals("图片新闻链接")||category.equals("成果展示链接")||category.equals("创新创业资讯链接")||category.equals("项目推介链接")){
			System.out.println(category);
			address=util.FileOperate.getPictrueAddress(content);
			if(address==null){
				throw new Exception("get pictrue false!");
			}
		}else{
			String newcontent=JspToHTML.getJspOutput("/jsp/third/third_page.jsp");
			try{
				address=util.JspToHTML.writeHTML(PathInfo.NEWSPATH,newcontent);
			}catch(Exception e){
				throw new Exception("JspToHTML false!");
			}
		}
		System.out.println("newsAdd::"+""+category);
		
		NewsCategory newsCategory=Cache.getNewsCategorybyName(category);
		newsCategory.setNewscategory(category);
		Date date=new Date(new java.util.Date().getTime()); 
		System.out.println("newsAdd::");
		News news=new News();		
		news.setAuthor(author);
		news.setAuthorId(authorId);
		news.setNewsTile(title);
		news.setNews_address(address);
		news.setNews_content(pictureLink);
		news.setDate(date);
		news.setCategory(newsCategory);
		news.setClickNum(0);
		news.setIsPassed(isPassed);
	
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		if(!dao.save(news)){
			throw new Exception("dao false!");
		}
		Cache.updateNews(category, news);
	}
	
	
}
