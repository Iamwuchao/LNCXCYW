package cache;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.NewsDao;
import mode.News;

public class HotestNewsCache implements LeftCycle<News> {
	
	private final int LIST_SIZE=10;
	private volatile List<News> hotestList;
	private final Object writeLock=new Object();
	
	
	@Override
	public void init() {
		System.out.println("hotestList init:");
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		List<News> re=dao.getNewsListByClick(10);
		hotestList=new ArrayList<News>(re);
		heapAdjust();	
	}	
	
	
	private void heapAdjust(){//维护一个小顶堆
		int len=hotestList.size();
		for(int i=(len-1)/2; i>=0; i--){
			int j=i;
			int max=j;
			int left=2*j+1;
			int right=left+1;
			
			while(left<len){
				if(hotestList.get(left).getClickNum()<hotestList.get(max).getClickNum()){
					max=left;
				}
				if(right<len&&hotestList.get(right).getClickNum()<hotestList.get(max).getClickNum()){
					max=right;
				}
				if(max==j){
					break;
				}else{
					News temp=hotestList.get(j);
					hotestList.set(j, hotestList.get(max));
					hotestList.set(max, temp);
					j=max;
					left=2*j+1;
					right=left+1;
				}
			}			
		}	
		System.out.println(hotestList);
	}
	
	
	@Override
	public void update(News news) {
		System.out.println("hotestList update:");
		synchronized(writeLock){
			for(News n: hotestList){//先判断对应的新闻是不是已经在排行榜中了
				if(n.getNews_address().equals(news.getNews_address())){//如果已经存在了，直接更新点击量，然后维护堆的性质
					n.setClickNum(n.getClickNum()+1);
					heapAdjust();
					return ;
				}
			}
			
			//如果没有出现过，进行下一步判断		
			if(hotestList.size()<LIST_SIZE){
				hotestList.add(news);
				heapAdjust();
				return ;
			}
			
			if(news.getClickNum()>hotestList.get(0).getClickNum()){
				hotestList.set(0, news);
				heapAdjust();
			}	
		}
			
	}
	
	
	public List<News> getHotestNewsList(){		
		return new ArrayList<News>(hotestList);
	}
	


	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registe(Cache cache) {
		// TODO Auto-generated method stub
		
	}



}
