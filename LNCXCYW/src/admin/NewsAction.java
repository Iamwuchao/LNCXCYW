package admin;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.IOException;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;


import com.opensymphony.xwork2.ActionSupport;
import mode.News;
import util.SingletonSessionFactory;

import mode.News;
import util.SingletonSessionFactory;

public class NewsAction extends ActionSupport{
	private String title;
	private String classify;
	private String author;
	private String content;
	
	private List<News> newsList;
	
	

	//添加新闻
	public String newsSubmit() throws Exception {
		System.out.println("newsSubmit:");
		System.out.println(title+""+classify);
		String address;
		
		try{
			address=util.JspToHTML.writeHTML(content);
		}catch(Exception e){

			System.out.println(e.getMessage());
			return ERROR;
		}
		
		News news=new News();
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
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
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
	
}
