package user;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
import util.JspToHTML;

public class UserAction {
	
	private String authorId;
	private List<News> newsList;
	private String newsMessageTable;
	
	
	public String getNewsMessageTable() {
		return newsMessageTable;
	}


	public void setNewsMessageTable(String newsMessageTable) {
		this.newsMessageTable = newsMessageTable;
	}


	public String myProject(){
		System.out.println("get:"+authorId);
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		newsList=dao.getNewsListByID(Integer.valueOf(authorId));
		System.out.println(newsList);
		
		
		newsMessageTable = JspToHTML.getJspOutput("/jsp/user/widgets/news_table.jsp");
		return ActionSupport.SUCCESS;
	}
	
	
	public String projectAdd(){
		System.out.println("projectAdd:");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String projectManage(){
		System.out.println("projectManage:");		
		return ActionSupport.SUCCESS;
	}
	
	public String information() {
		System.out.println("information:");		
		return ActionSupport.SUCCESS;
	}
	



	
	
	

	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}


	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
	
	
	
	
	
}
