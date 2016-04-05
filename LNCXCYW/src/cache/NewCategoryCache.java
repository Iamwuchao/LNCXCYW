package cache;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import mode.NewsCategory;

public class NewCategoryCache implements LeftCycle<NewsCategory>{
	private ConcurrentHashMap<String,NewsCategory> map;
	private AtomicBoolean isinited = new AtomicBoolean(false);
	NewCategoryCache(){
		
	}
	
	public LinkedList<String> getAllNewsCategory(){
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(map.keySet());
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
		if(isinited.get()) return;
		if(isinited.compareAndSet(false, true)){
			 NewsCategoryDao dao = (NewsCategoryDao) DaoFactory.getDaoByName(NewsCategoryDao.class);
			 List<NewsCategory> list = (List<NewsCategory>) dao.getAll();
			 for(NewsCategory category:list){
				 map.put(category.getNewscategory(),category);
			 }
		}
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		if(!isinited.get()) return;
		if(!isinited.compareAndSet(false,true)){
			map.clear();
		}
	}

	
	public void update(NewsCategory oldCategory,NewsCategory newCategory){
		if(isinited.get()){
			if(oldCategory!=null)
			map.remove(oldCategory.getNewscategory());
			if(newCategory!=null)
			map.put(newCategory.getNewscategory(), newCategory);
		}
	}
}
