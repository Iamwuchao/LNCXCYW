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
		
	}
	
	
	
	public List<News> getNewestNewsList(int start,int count){
		Iterator<News> iter = cacheNewsList.iterator();
		int fromIndex=start,toIndex=start+count;
		int index=0;
		List<News> list = new LinkedList<News>();
		while(iter.hasNext()){
			News news = iter.next();
			if(index>=fromIndex&& index<=toIndex){
					list.add(news);
			}
			index++;
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
		
	}

}
