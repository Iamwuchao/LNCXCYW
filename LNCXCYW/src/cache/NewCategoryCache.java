package cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import mode.NewsCategory;
/*
 * 该类主要用于缓存新闻栏目列表
 */
public class NewCategoryCache implements LeftCycle<NewsCategory>{
	private ConcurrentHashMap<String,NewsCategory> map;
	private AtomicBoolean isinited = new AtomicBoolean(false);
	NewCategoryCache(){
		map = new ConcurrentHashMap<String,NewsCategory>();
	}
	
	
	public NewsCategory getNewsCategory(String newsCategory){
		NewsCategory nc = new NewsCategory();
		NewsCategory tem = map.get(newsCategory);
		nc.setNewscategory(tem.getNewscategory());
		nc.setCategoryId(tem.getCategoryId());
		return nc;
	}
	public LinkedList<String> getAllNewsCategoryName(){
		LinkedList<String> list = new LinkedList<String>();
		Set<String> set = map.keySet();
		for(String str:set){
			System.out.println("get "+str);
		}
		list.addAll(set);
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
				 System.out.println("init "+category.getNewscategory());
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

	
	@Override
	public void registe(Cache cache) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(NewsCategory t) {
		// TODO Auto-generated method stub
		
	}
}
