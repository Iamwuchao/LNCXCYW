package cache;

import java.util.HashMap;

import java.util.LinkedList;

import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import mode.NewsCategory;

public class NewCategoryCache<NewsCategory> implements LeftCycle<NewsCategory>{
	private HashMap<String,NewsCategory> map;
	
	NewCategoryCache(){
		
	}
	
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
		BaseDao baseDao = DaoFactory.getDaoByName(NewsCategoryDao.class);
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	
	public void add(){
		
	}
}
