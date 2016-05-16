package baseaction;

import java.util.List;

import mode.News;
import GlobalInfo.HomePageInfo;
import cache.Cache;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private List<News> pictureNewsList;//焦点图片新闻列表
	private List<News> newsList;//每日推荐新闻列表
	
	public BaseAction(){
		pictureNewsList = Cache.getNewestNewsList(HomePageInfo.HOMEPAGEINFO.getNewestNewsCount());//初始化每日推荐新闻列表
		newsList = Cache.getNewsList("图片新闻", 0, 3);//初始化焦点图片新闻
	}
	
	public List<News> getPictureNewsList() {
		return pictureNewsList;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setPictureNewsList(List<News> pictureNewsList) {
		this.pictureNewsList = pictureNewsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
}
