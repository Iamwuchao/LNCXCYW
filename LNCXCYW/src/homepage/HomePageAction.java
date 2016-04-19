package homepage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import GlobalInfo.HomePageInfo;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.News;


public class HomePageAction extends ActionSupport{
	//private List<News> newsList;
	//private List<String> newsCategoryList;
	private final static int MAX = 100; 
	private int newsCount;
	private HashMap<String,List<News>> newsMap;
	public String[] orderOfCategory={"通知公告","工作动态","高校动态","政策规章","创新创业资讯","项目推介","企业需求","教指委工作动态",
			"高校创新创业教育季报","创新训练","创业实践","创新创业年会","优秀创新创业作品","创新创业典型","他山之石","创新创业培训","创新创业理论","创新创业教材","创新创业课程","创新创业导师","素质测评","图片新闻"};
	
	
	
	public HashMap<String, List<News>> getNewsMap() {
		return newsMap;
	}

	public void setNewsMap(HashMap<String, List<News>> newsMap) {
		this.newsMap = newsMap;
	}

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
	
	public String getHomePageNewsMap(){
		//getAllNewsCategoryList();
		int fromIndex=0;
		int toIndex = HomePageInfo.HOMEPAGEINFO.getNewsCountOfCategory();
		newsMap = new HashMap<String,List<News>>();
		if(toIndex-fromIndex>MAX) return ERROR;
	//	newsList = new LinkedList<News>();
		for(String category:orderOfCategory){
			List<News> temList = Cache.getNewsList(category, fromIndex, toIndex);
			newsMap.put(category, temList);
		}
		for(String category:orderOfCategory){
			List<News> list = newsMap.get(category);
			for(News tem:list){
				System.out.println(tem.getCategory().getNewscategory()+"  "+tem.getNewsTile());
			}
		}
		//System.out.println("newsList.size()"+"   "+newsList.size());
		return SUCCESS;
	}
	
}
