package homepage;

import java.util.List;

import cache.Cache;

public class HomePageAction {
	private List<String> newsList;
	private List<String> newsCategoryList;
	private final static int newsNum = 10; 
	
	
	public List<String> getNewsList() {
		return newsList;
	}



	public void setNewsList(List<String> newsList) {
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
	
	void getNewsListByCategoryName(String category){
		newsList = Cache.getNewsList(category,0,newsNum);
	}
}
