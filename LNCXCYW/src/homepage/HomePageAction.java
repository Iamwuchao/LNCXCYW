package homepage;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.News;


public class HomePageAction extends ActionSupport{
	private List<News> newsList;
	private List<String> newsCategoryList;
	private final static int MAX = 10; 
	private int newsCount;
	
	public String[] orderOfCategory={"通知公告","工作动态","高校动态","政策规章","创新创业资讯","项目推介","企业需求","教指委工作动态",
			"在线交流","创新训练","创业实践","创新创业年会","优秀创新创业作品","创新创业典型","他山之石","创新创业培训","创新创业理论","创新创业教材","创新创业课程","创新创业导师","素质测评","图片新闻"};
	
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
		//getAllNewsCategoryList();
		int fromIndex=0;
		int toIndex = 10;//newsCount < MAX ? newsCount:MAX;
		newsList = new LinkedList<News>();
		for(String category:orderOfCategory){
			List<News> temList = Cache.getNewsList(category, fromIndex, toIndex);
			System.out.println(category+"  "+temList.size()); 
			newsList.addAll(temList);
		}
		System.out.println("newsList.size()"+"   "+newsList.size());
		return SUCCESS;
	}
	
}
