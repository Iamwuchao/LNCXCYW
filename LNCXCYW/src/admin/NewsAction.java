package admin;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;


import com.opensymphony.xwork2.ActionSupport;
import mode.News;
import mode.NewsCategory;
import util.SingletonSessionFactory;

import mode.News;
import util.SingletonSessionFactory;

public class NewsAction extends ActionSupport{
	private String title;
	private String category;
	private String author;
	private String content;
	
	private List<News> newsList;
	private List<String> categoryList;
	
	public String newsAdd(){
		System.out.println("newsAdd:");
//		List<String> list=cache.Cache.getNewsCategoryList();
//		for(String s: list){
//			System.out.println(s);
//		}
		categoryList=new ArrayList<String>();
		categoryList.add("cate1");
		categoryList.add("cate2");
		categoryList.add("cate3");
		
		return SUCCESS;
	}

	//添加新闻
	public String newsSubmit() throws Exception {
		System.out.println("newsSubmit:");
		System.out.println(title+""+category+""+author);
		String address;
		try{
			address=util.JspToHTML.writeHTML(content);
		}catch(Exception e){

			System.out.println(e.getMessage());
			return ERROR;
		}
		
		News news=new News();
		NewsCategory category=new NewsCategory();
		
		news.setNews_address(address);
		news.setAuthor(author);
		news.setNewsTile(title);
		
		Session session=SingletonSessionFactory.getSession();
		
		try{
			Transaction trans=session.beginTransaction();
			session.save(news);
			trans.commit();
		}catch(Exception e){

			System.out.println("error");
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
