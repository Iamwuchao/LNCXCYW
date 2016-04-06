package homepage;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.News;

public class HomePageAction extends ActionSupport{
	private List<News> newsList;
	private List<String> newsCategoryList;
	private final static int newsNum = 10; 
	
	
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	public List<String> getNewsCategoryList() {
		return newsCategoryList;
	}

	public void setNewsCategoryList(List<String> newsCategoryList) {
		this.newsCategoryList = newsCategoryList;
	}

	void getAllNewsCategoryList(){
		newsCategoryList = Cache.getNewsCategoryList();
	}
	
	public String getHomePageNewsList(){
		
		return SUCCESS;
	}
	
}
