package util;

import java.util.ArrayList;
import java.util.List;

import mode.News;



public class ConcurrentMinHeap {
	private volatile List<News> heap;
	private final int HEAP_SIZE=10;
	private final Object writeLock=new Object();
	
	public ConcurrentMinHeap(ArrayList<News> list){
		this.heap=new ArrayList<News>(list);
		heapAdjust();
		System.out.println(heap);
	}
	
	public List<News> getAll(){
		return new ArrayList<News>(heap);
	}
	
	private void heapAdjust(){
		int len=heap.size();
		for(int i=(len-1)/2; i>=0; i--){
			int j=i;
			int max=j;
			int left=2*j+1;
			int right=left+1;
			
			while(left<len){
				if(heap.get(left).getClickNum()<heap.get(max).getClickNum()){
					max=left;
				}
				if(right<len&&heap.get(right).getClickNum()<heap.get(max).getClickNum()){
					max=right;
				}
				if(max==j){
					break;
				}else{
					News temp=heap.get(j);
					heap.set(j, heap.get(max));
					heap.set(max, temp);
					j=max;
					left=2*j+1;
					right=left+1;
				}
			}			
		}	
		System.out.println(heap);
	}
	
	public void update(News news){
		System.out.println("hoteatList update:");
		synchronized(writeLock){
			for(News n: heap){//先判断对应的新闻是不是已经在排行榜中了
				if(n.getNews_address().equals(news.getNews_address())){//如果已经存在了，直接更新点击量，然后维护堆的性质
					n.setClickNum(n.getClickNum()+1);
					heapAdjust();
					return ;
				}
			}
			
			//如果没有出现过，进行下一步判断		
			if(heap.size()<HEAP_SIZE){
				heap.add(news);
				heapAdjust();
				return ;
			}
			
			if(news.getClickNum()>heap.get(0).getClickNum()){
				heap.set(0, news);
				heapAdjust();
			}			
		}
	}
	
}
