package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import mode.NewsCategory;

public class NewsCache<String> implements LeftCycle<String>{
	private  AtomicBoolean isInited = new AtomicBoolean(false); 
	private HashMap<String,ConcurrentLinkedQueue<String>> cacheMap; 
	
	public LinkedList<String> getNewCacheList(NewsCategory nc,int fromIndex,int toIndex){
		if(fromIndex > toIndex){
			throw new IllegalArgumentException("fromIndex > toIndex");
		}
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(((List<String>) cacheMap.get(nc)).subList(fromIndex, toIndex));
		return list;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(isInited.compareAndSet(false, true)){
			cacheMap = new HashMap<String,ConcurrentLinkedQueue<String>>();
			
		}
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
