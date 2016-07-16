package cache;
import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
/*
 * 该类主要用于缓存每日推荐的新闻列表，保存最新的新闻，不分栏目
 */
public class NewestNewsCache implements LeftCycle<News>{
	
	private ConcurrentLinkedDeque<News> cacheNewsList = new ConcurrentLinkedDeque<News>();
	private AtomicInteger MAX_CACHE = new AtomicInteger(10);
	private AtomicBoolean isInited = new AtomicBoolean(false);
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(isInited.get()) return;
		if(isInited.compareAndSet(false, true)){
			NewsDao nd = (NewsDao) DaoFactory.getDaoByName(NewsDao.class);
			List<News> temList = nd.getNewsSubListOrderByDate(0, MAX_CACHE.get());
			cacheNewsList.addAll(temList);
		}
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		if(isInited.compareAndSet(true, false)){
			if(cacheNewsList!=null){
				cacheNewsList.clear();
			}
		}
	}
	
	
	
	public List<News> getNewestNewsList(int fromIndex,int toIndex){
		int index=0;
		List<News> list = new LinkedList<News>();
		if(fromIndex > toIndex) return list;
		if(fromIndex < cacheNewsList.size()){
			Iterator<News> iter = cacheNewsList.iterator();
			while(iter.hasNext()){
				News news = iter.next();
				if(index>=fromIndex&& index<=toIndex){
						list.add(news);
				}
				index++;
			}
		}
		if(toIndex >= cacheNewsList.size()){
			NewsDao newsDao = (NewsDao) DaoFactory.getDaoByName(NewsDao.class);
			List<News> temlist = newsDao.getNewsSubListOrderByDate(cacheNewsList.size(), toIndex + 1 - cacheNewsList.size());
			for(News tem:temlist){
				list.add(tem);
			}
		}
		return list;
	}

	@Override
	public void registe(Cache cache) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(News t) {
		// TODO Auto-generated method stub
		while(cacheNewsList.size() >= this.MAX_CACHE.get()){
			cacheNewsList.removeLast();
		}
		cacheNewsList.addFirst(t);
	}

	public void remove(News t){
		for(News news: cacheNewsList){
			if(news.getNewsId()==t.getNewsId()){
				System.out.println("newest remove: "+cacheNewsList.remove(news));
				break;
			}
		}
		
	}
}
