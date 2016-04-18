package cache;

import java.util.LinkedList;
import java.util.List;

import mode.News;
import mode.NewsCategory;

public class Cache {
	private NewCategoryCache categoryCache;
	private NewsCache newsCache;
	//private NewestNewsCache newestNews
	private static final Cache cache = new Cache();
	private Cache(){
		categoryCache = new NewCategoryCache();
		newsCache = new NewsCache();
		categoryCache.init();
		newsCache.init();
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
	
	public static List<News> getNewestNewsList(int count){
		LinkedList<News> list = new LinkedList<News>();
		if(count>0){
			//list = 
		}
		return list;
	}
	
	public static void clear(){
		cache.categoryCache.destory();
		cache.newsCache.destory();
	}
}
