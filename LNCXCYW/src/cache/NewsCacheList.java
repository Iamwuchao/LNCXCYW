package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import mode.NewsCategory;

public class NewsCacheList<String> implements LeftCycle<String>{
	private volatile boolean isInited = false; 
	private HashMap<NewsCategory,ConcurrentLinkedQueue<String>> cacheMap; 
	
	public LinkedList<String> getNewCacheList(NewsCategory nc){
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(cacheMap.get(nc));
		return list;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(Listener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(String newt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String oldT) {
		// TODO Auto-generated method stub
		
	}

}
