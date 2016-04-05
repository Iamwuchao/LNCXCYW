package cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import mode.News;

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
	 * 获取新闻栏目的新闻列表 ［fromIndex,toIndex)
	 * 
	 */
	public LinkedList<News> getNewCacheList(String category,int fromIndex,int toIndex){
		if(fromIndex > toIndex){
			throw new IllegalArgumentException("fromIndex > toIndex");
		}
		LinkedList<News> list = new LinkedList<News>();
		
		if(!cacheMap.containsKey(category)) return list;
		
		Iterator<News> iter = (Iterator<News>) (cacheMap.get(category)).iterator();
		for(int i=0;i<toIndex;i++){
			if(i>=fromIndex){
				list.add(iter.next());
			}
		}
		return list;
	}
	
	/*
	 * 添加一条新闻html文件的地址 ，对应的栏目如果不存在则添加该栏目对应的list
	 */
	public void add(String category,News news){
		//为初始化/或已经关闭则 直接返回
		if(!isInited.get()){
			return;
		}
		
		//add list if not exist
		cacheMap.putIfAbsent(category, new ConcurrentLinkedDeque<News>());
		
		ConcurrentLinkedDeque<News> queue = cacheMap.get(category);
		while(MAX_CACHE.get()<queue.size()){
			queue.removeLast();
		}
		queue.addFirst(news);
	}
}
