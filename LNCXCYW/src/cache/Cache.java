package cache;

import java.util.List;

import mode.NewsCategory;

public class Cache {
	private NewCategoryCache<NewsCategory> categoryCache;
	private NewsCache<String> newsCache;
	private static final Cache cache = new Cache();
	private Cache(){
		categoryCache = new NewCategoryCache<NewsCategory>();
		newsCache = new NewsCache<String>();
		categoryCache.init();
		newsCache.init();
	}
	
	public static List<String> getNewsList(String newsCategory,int fromIndex,int toIndex){
		return cache.newsCache.getNewCacheList(newsCategory, fromIndex, toIndex);
	}
	
	public static void updateNews(String newsCategory,String news){
		cache.newsCache.add(newsCategory,news);
	}
	
	public static void updateNewsCategory(){
		
	}
	
	public static void setMaxNewsCache(int max){
		if(max>0){
			cache.newsCache.setMaxCache(max);
		}
	}
	
	public static void clear(){
		cache.categoryCache.destory();
		cache.newsCache.destory();
	}
}
