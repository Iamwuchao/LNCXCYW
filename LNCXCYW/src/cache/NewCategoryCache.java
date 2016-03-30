package cache;

import java.util.HashMap;

import java.util.LinkedList;

import mode.NewsCategory;

public class NewCategoryCache<NewsCategory> implements LeftCycle<NewsCategory>{
	private HashMap<String,NewsCategory> map;
	private Listener listener;
	public LinkedList<NewsCategory> getAllNewsCategory(){
		LinkedList<NewsCategory> list = new LinkedList<NewsCategory>();
		list.addAll(map.values());
		return list;
	}
	
	public LinkedList<String> getAllNewsCategoryName(){
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(map.keySet());
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
		if(listener == null) {
			throw new NullPointerException("Listener is null");
		}
		this.listener = listener;
	}
	
	public void add(){
		
	}

	@Override
	public void add(NewsCategory newt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(NewsCategory oldT) {
		// TODO Auto-generated method stub
		
	}
}
