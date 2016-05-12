package cache;

import java.util.LinkedList;
import java.util.List;

import mode.ExamPaper;
import mode.News;
import mode.NewsCategory;

public class Cache {
	private NewCategoryCache categoryCache;//新闻栏目缓存
	private NewsCache newsCache;//新闻列表缓存 各个栏目
	private NewestNewsCache newestNews;//最新新闻列表缓存
	private ExamPaperCache examPaper = new ExamPaperCache();
	private static final Cache cache = new Cache();
	
	//初始化各个缓存
	private Cache(){
		categoryCache = new NewCategoryCache();
		newsCache = new NewsCache();
		newestNews = new NewestNewsCache();
		categoryCache.init();
		newsCache.init();
		newestNews.init();
	}
	
	/*
	 * 获取新闻列表 获取范围为[fromIndex,toIndex]两端都包含
	 */
	public static List<News> getNewsList(String newsCategory,int fromIndex,int toIndex){
		return cache.newsCache.getNewCacheList(newsCategory, fromIndex, toIndex);
	}
	
	public static void updateNews(String newsCategory,News news) throws Exception{
		cache.newsCache.add(newsCategory,news);
	}
	
	public static void updateNewsCategory(NewsCategory oldCategory,NewsCategory newCategory){
		cache.categoryCache.update(oldCategory, newCategory);
	}
	
	public static NewsCategory getNewsCategorybyName(String name){
		return cache.categoryCache.getNewsCategory(name);
	}
	
	public static LinkedList<String> getNewsCategoryList(){
		return cache.categoryCache.getAllNewsCategoryName();
	}
	
	public static void setMaxNewsCache(int max){
		if(max>0){
			cache.newsCache.setMaxCache(max);
		}
	}
	
	public static List<News> getNewestNewsList(int fromIndex,int toIndex){
		return cache.newestNews.getNewestNewsList(fromIndex, toIndex);
	}
	
	public static List<News> getNewestNewsList(int count){
		List<News> list = new LinkedList<News>();
		if(count>0){
			list = cache.newestNews.getNewestNewsList(0,count-1);
		}
		return list;
	}
	
	public static List<ExamPaper> getAllExamPaper(){
		return cache.examPaper.getAllExamPaper();
	}
	
	public static void clear(){
		cache.categoryCache.destory();
		cache.newsCache.destory();
	}
}
