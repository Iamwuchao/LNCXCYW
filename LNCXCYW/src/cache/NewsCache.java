package cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import dao.DaoFactory;
import dao.NewsCategoryDao;
import dao.NewsDao;
import mode.News;
import mode.NewsCategory;

/*
 * 新闻html文件地址缓存，保存MAX_VALUE条记录
	一个栏目对应一个list
 */

public class NewsCache implements LeftCycle<String>{
	private  AtomicBoolean isInited = new AtomicBoolean(false); 
	private  AtomicInteger MAX_CACHE = new AtomicInteger(1000);
	private HashMap<String,ConcurrentLinkedDeque<News>> cacheMap; 
	
	NewsCache(){

	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(isInited.compareAndSet(false, true)){
			cacheMap = new HashMap<String,ConcurrentLinkedDeque<News>>();
			 NewsCategoryDao dao = (NewsCategoryDao) DaoFactory.getDaoByName(NewsCategoryDao.class);
			 List<NewsCategory> newsCategorylist = (List<NewsCategory>) dao.getAll();
			 NewsDao nd = (NewsDao) DaoFactory.getDaoByName(NewsDao.class);
			for(NewsCategory category:newsCategorylist){
				List<News> list = nd.getNewsSubListOrderByDate(category, 0, MAX_CACHE.get());
				System.out.println("init news cache"+"  "+category.getNewscategory()+"  "+list.size());
				ConcurrentLinkedDeque<News> cdq = new ConcurrentLinkedDeque<News>();
				cdq.addAll(list);
				cacheMap.put(category.getNewscategory(),cdq);
			}
		}
	}
	@Override
	public void destory() {
		// TODO Auto-generated method stub
		if(isInited.get()){
			if(isInited.compareAndSet(true, false)){
				cacheMap.clear();
			}
		}
		
	}
	
	public void setMaxCache(int max){
		if(max<0){
			return;
		}
		MAX_CACHE.set(max);
	}
	
	//缓存是否可用
	public boolean isAvaliable(){
		return isInited.get();
	}
	
	/*
	 * 获取新闻栏目的新闻列表 ［fromIndex,toIndex],下标从零开始
	 * 
	 */
	public LinkedList<News> getNewCacheList(String category,int fromIndex,int toIndex){
		if(fromIndex > toIndex){
			throw new IllegalArgumentException("fromIndex > toIndex");
		}
		LinkedList<News> list = new LinkedList<News>();
		
		if(!cacheMap.containsKey(category)) return list;
		ConcurrentLinkedDeque<News> newsList = cacheMap.get(category);
		if(fromIndex < newsList.size()){
			Iterator<News> iter = (Iterator<News>) (newsList).iterator();
			int index=0;
			while(iter.hasNext()){
				News news = iter.next();
				if(index>=fromIndex&& index<=toIndex){
						list.add(news);
				} 
				index++;
			}
		}
        if(newsList.size() < toIndex){
			NewsDao newsDao = (NewsDao) DaoFactory.getDaoByName(NewsDao.class);
			NewsCategory newsCategory = Cache.getNewsCategorybyName(category);
			List<News> temList = newsDao.getNewsSubListOrderByDate(newsCategory, newsList.size(), toIndex);
			for(News news:temList){
				list.add(news);
			}
		}
		return list;
	}
	
	/*
	 * 添加一条新闻html文件的地址 ，对应的栏目如果不存在则添加该栏目对应的list
	 */
	public void add(String category,News news) throws Exception{
		//为初始化/或已经关闭则 直接返回
		if(!isInited.get()){
			return;
		}
		if(null==Cache.getNewsCategorybyName(category)){
			throw new Exception("该新闻栏目不存在");
		}
		//add list if not exist
		cacheMap.putIfAbsent(category, new ConcurrentLinkedDeque<News>());
		
		ConcurrentLinkedDeque<News> queue = cacheMap.get(category);
		while(MAX_CACHE.get()<queue.size()){
			queue.removeLast();
		}
		queue.addFirst(news);
	}

	public void remove(String category,News news){
		ConcurrentLinkedDeque<News> list = cacheMap.get(category);
		if(list == null || list.size()<1) return ;
		list.remove(news);
	}
	
	@Override
	public void registe(Cache cache) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String t) {
		// TODO Auto-generated method stub
		
	}
}
