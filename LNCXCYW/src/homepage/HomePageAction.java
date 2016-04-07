package homepage;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.News;

@SuppressWarnings("serial")
public class HomePageAction extends ActionSupport{
	private List<News> newsList;
	private List<String> newsCategoryList;
	private final static int MAX = 10; 
	private int newsCount;
	

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

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
		getAllNewsCategoryList();
		int fromIndex=0;
		int toIndex = newsCount < MAX ? newsCount:MAX;
		
		for(String category:newsCategoryList){
			newsList.addAll(Cache.getNewsList(category, fromIndex, toIndex));
		}
		return SUCCESS;
	}
	
}
