package homepage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.News;
import util.JspToHTML;
import util.PageGetBaseAction;
import util.SingletonSessionFactory;

public class NewsAction extends PageGetBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	public String news_list_html;
	private List<News> newsList;
	private List<News> list;
	private String news_address;
	private List<News> addressList;
	
	
	
	@SuppressWarnings("unchecked")
	public String pictureNews() throws Exception{
		System.out.println("newsList: "+category);
		Session session1 = SingletonSessionFactory.getSession();
		Criteria q1 = session1.createCriteria(News.class);
		list = q1.list();
		
		list = Cache.getNewestNewsList(12);
		Cache.getNewsList("图片新闻", 0, 3);
		System.out.println(list);
		System.out.println(news_address);
		//图片新闻
		Session session2 = SingletonSessionFactory.getSession();
		addressList = session2.createCriteria(News.class).add(Restrictions.eq("news_address", news_address)).list();
		System.out.println(news_address);
		System.out.println(addressList);
		return ActionSupport.SUCCESS;
		
	}

	/*
	 * 获取新闻列表
	 */
	@SuppressWarnings("unchecked")
	public String newsList() throws Exception{
		System.out.println("newsList: "+category);
		Session session1 = SingletonSessionFactory.getSession();
		Criteria q1 = session1.createCriteria(News.class);
		list = q1.list();
		if(category==null){//获取所有新闻
			Session session=SingletonSessionFactory.getSession();
			Criteria q=session.createCriteria(News.class);
			/*list=q.list();*/
			newsList=q.list();
			
			session.close();
		}else{//根据参数获取对应类别
			newsList=Cache.getNewsList(category, 0, 200);
			newsList=makeCurrentPageList(newsList, 10);
		}
		list = Cache.getNewestNewsList(12);
		Cache.getNewsList("图片新闻", 0, 3);
		System.out.println(list);
		//System.out.println(newsList);
		//list = Cache.getNewestNewsList(10);
		System.out.println(list);
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	/*
	 * 获取新闻分页
	 */
	@SuppressWarnings("unchecked")
	public String newsPage(){
		System.out.println("newsPage:"+category);
		newsList=Cache.getNewsList(category, 0, 200);
		newsList=makeCurrentPageList(newsList, 12);
		news_list_html = JspToHTML.getJspOutput("/jsp/third/secondPageTable.jsp");
		return ActionSupport.SUCCESS;
		
	}

	
	
	/*
	 * getters and setters
	 */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNews_list_html() {
		return news_list_html;
	}

	public void setNews_list_html(String news_list_html) {
		this.news_list_html = news_list_html;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public String getNews_address() {
		return news_address;
	}

	public void setNews_address(String news_address) {
		this.news_address = news_address;
	}

	public List<News> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<News> addressList) {
		this.addressList = addressList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
