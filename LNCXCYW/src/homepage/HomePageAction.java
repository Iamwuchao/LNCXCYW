package homepage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import GlobalInfo.NewsPageInfo;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import mode.ExamPaper;
import mode.News;

public class HomePageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int MAX = 100; 
	private int newsCount;
	private HashMap<String,List<News>> newsMap;
	public String[] orderOfCategory={"通知公告","工作动态","高校动态","政策规章","创新创业资讯","项目推介","企业需求","教指委工作动态",
			"高校创新创业教育季报","创新创业训练计划","创新创业竞赛","创新创业年会","优秀创新创业作品","创新创业典型","他山之石","创新创业培训","创新创业理论","创新创业教材","创新创业课程","创新创业导师","素质测评","图片新闻"};
	
	
	
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
	
	/*
	 * 获取首页各个栏目的新闻列表，使用map存储
	 */
	public String getHomePageNewsMap(){
		int fromIndex=0;
		int toIndex = NewsPageInfo.NEWSPAGEINFO.getNewsCountOfCategory();
		newsMap = new HashMap<String,List<News>>();
		if(toIndex-fromIndex>MAX) return ERROR;
		for(String category:orderOfCategory){
			List<News> temList = Cache.getNewsList(category, fromIndex, toIndex-1);
			System.out.println(category);
			System.out.println(temList);
			newsMap.put(category, temList);
		}
		
		List<News> szcpList = initSuzhiceping();
		//special 素质测评
		newsMap.put("素质测评", szcpList);

		return SUCCESS;
	}
	
	//初始化素质测评模块
	private List<News> initSuzhiceping(){
		final String url = "/showExam?paperName=";
		List<ExamPaper> paperList = Cache.getAllExamPaper();
		System.out.println("paperList size "+paperList.size());
		LinkedList<News> szcpList = new LinkedList<News>();
		for(ExamPaper paper:paperList){
			News szcp = new News();
			String address = url+paper.getName();
			szcp.setNews_address(address);
			szcp.setNewsTile(paper.getName());
			szcpList.add(szcp);
		}
		return szcpList;
	}
	
}
