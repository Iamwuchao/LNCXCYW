package admin;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import mode.News;
import util.SingletonSessionFactory;


public class NewsShowAction {
	private List<News> news_list;

	public List<News> getNews_list() {
		return news_list;
	}

	public void setNews_list(List<News> news_list) {
		this.news_list = news_list;
	} 

	public String showNews() throws Exception{
		try{
			System.out.println("youyouyou");
			Session session = SingletonSessionFactory.getSession();
			session.beginTransaction();
			Criteria q=session.createCriteria(News.class);
			
			news_list=q.list();
			for(News m:news_list)
				System.out.println(m.getNewsTile()+"  "+m.getAuthor());
			System.out.println("test");
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
	
}
