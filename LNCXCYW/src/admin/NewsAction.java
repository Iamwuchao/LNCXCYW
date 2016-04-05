package admin;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
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
		List<String> list=Cache.getNewsCategoryList();
		for(String s: list){
			System.out.println(s);
		}

		categoryList=list;
		return SUCCESS;
	}

	//添加新闻
	public String newsSubmit() throws Exception {
		status="0";
		System.out.println("newsSubmit:");
		System.out.println("content:"+content);
		try{
			content=JspToHTML.getJspOutput("/jsp/third/base.jsp");
			System.out.println("content:"+content);
		}catch(Exception e){
			System.out.println(e.getMessage());
			status="1";
			return ERROR;
		}
		
		String address;
		try{
			address=util.JspToHTML.writeHTML(content);
		}catch(Exception e){
			System.out.println("error:"+e.getMessage());
			status="1";
			return ERROR;
		}
		
		News news=new News();
		NewsCategory newsCategory=Cache.getNewsCategorybyName(category);
		newsCategory.setNewscategory(category);
		
		news.setNews_address(address);
		news.setAuthor(author);
		news.setNewsTile(title);
		news.setCategory(newsCategory);
		Session session=SingletonSessionFactory.getSession();
		
		try{
			Transaction trans=session.beginTransaction();
			session.save(news);
			trans.commit();
		}catch(Exception e){
			session.close();
			System.out.println("error:"+e.getMessage());
			status="1";
			return ERROR;
		}
		session.close();
		System.out.println("save");
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	public String newsList() throws Exception{
		System.out.println("newsList:");
		Session session=SingletonSessionFactory.getSession();
		Criteria q=session.createCriteria(News.class);
		newsList=q.list();
		session.close();
		System.out.println(newsList);
		return SUCCESS;
	}
	
	/*
	 * getters and setters
	 */
	
	
	
	public String getTitle() {
		return title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
