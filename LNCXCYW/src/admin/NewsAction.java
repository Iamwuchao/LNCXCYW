package admin;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import mode.News;
import util.SingletonSessionFactory;

public class NewsAction extends ActionSupport{
	private String title;
	private String classify;
	private String author;
	private String content;
	
	
	
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
		news.setAuthor(author);
		news.setNewsTile(title);
		news.setNews_address(address);
		
		Session session=SingletonSessionFactory.getSession();
		try{
			Transaction trans=session.beginTransaction();
			session.save(news);
			trans.commit();
		}catch(Exception e){
			System.out.println("error");	
			session.close();
			return ERROR;
		}
		session.close();
		System.out.println("save");
		
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
