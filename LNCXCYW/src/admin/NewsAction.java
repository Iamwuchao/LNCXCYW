package admin;


import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import GlobalInfo.PathInfo;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
import mode.NewsCategory;
import util.JspToHTML;
import util.SingletonSessionFactory;

public class NewsAction extends ActionSupport{
	private String status;
	private String title;
	private String category;
	private String author;
	private String content;
	
	private List<News> newsList;
	private List<String> categoryList;
	
	public String newsAdd(){
		System.out.println("newsAdd:");
		categoryList=Cache.getNewsCategoryList();
//		for(String s: categoryList){
//			System.out.println(s);
//		}
		return SUCCESS;
	}

	//添加新闻
	public String newsSubmit() throws Exception {
		status="0";
		System.out.print("newsSubmit: ");
		System.out.println(title+""+category+""+author);
		try{
			content=JspToHTML.getJspOutput("/jsp/third/third_page.jsp");
		}catch(Exception e){
			System.out.println(e.getMessage());
			status="1";
			return SUCCESS;
		}
		
		String address;
		try{
			address=util.JspToHTML.writeHTML(PathInfo.NEWSPATH,content);
		}catch(Exception e){
			System.out.println("error:"+e.getMessage());
			status="1";
			return SUCCESS;
		}
		
		News news=new News();
		NewsCategory newsCategory=Cache.getNewsCategorybyName(category);
		newsCategory.setNewscategory(category);
		
		Date date=new Date(new java.util.Date().getTime()); 
		//System.out.println(date);
		news.setAuthor(author);
		news.setNewsTile(title);
		news.setNews_address(address);
		news.setDate(date);
		news.setCategory(newsCategory);
		
		
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		if(!dao.save(news)){
			System.out.println("dao false!");
			status="1";
			return SUCCESS;
		}
		
		Cache.updateNews(category, news);
		System.out.println("save");
		return SUCCESS;
	}

	
	public String newsList() throws Exception{
		System.out.println("newsList: "+category);
		
		if(category==null){//获取所有新闻
			Session session=SingletonSessionFactory.getSession();
			Criteria q=session.createCriteria(News.class);
			newsList=q.list();
			session.close();
		}else{//根据参数获取对应类别
			newsList=Cache.getNewsList(category, 1, 200);
		}
		
		//System.out.println(newsList);
		
		
		return SUCCESS;
	}
	
	/*
	 * getters and setters
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
