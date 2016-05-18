package baseaction;

import java.util.List;

import mode.News;
import GlobalInfo.NewsPageInfo;
import cache.Cache;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 该类主要用于提供每日推荐和焦点图片列表信息的初始化
 * 页面上需要有焦点图片和每日推荐内容的action可以继承该类
 */
public class BasePageInfoAction extends ActionSupport{
	private List<News> pictureNewsList;//焦点图片新闻列表
	private List<News> newestNewsList;//每日推荐新闻列表
	
	public BasePageInfoAction(){
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());//初始化每日推荐新闻列表
		pictureNewsList = Cache.getNewsList("图片新闻", 0, NewsPageInfo.NEWSPAGEINFO.getPictureNewsCount());//初始化焦点图片新闻
	}

	public List<News> getPictureNewsList() {
		return pictureNewsList;
	}

	public List<News> getNewestNewsList() {
		return newestNewsList;
	}

	public void setPictureNewsList(List<News> pictureNewsList) {
		this.pictureNewsList = pictureNewsList;
	}

	public void setNewestNewsList(List<News> newestNewsList) {
		this.newestNewsList = newestNewsList;
	}
	
	
}
