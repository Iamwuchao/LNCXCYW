package homepage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import GlobalInfo.NewsPageInfo;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
import util.JspToHTML;
import util.PageGetBaseAction;
import util.SingletonSessionFactory;

public class NewsAction extends PageGetBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	public String news_list_html;
	public String paginationTable;
	private List<News> newsList;
	private String news_address;
	private List<News> addressList;
	private Map<String, List<News>> newsMap;
	private List<News> newestNewsList;//每日推荐的新闻列表
	private List<News> pictureNewsList;//焦点图片新闻列表
	private List<News> hotestNewsList;//排行榜新闻列表
	
	public List<News> getHotestNewsList() {
		return hotestNewsList;
	}

	public void setHotestNewsList(List<News> hotestNewsList) {
		this.hotestNewsList = hotestNewsList;
	}

	private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	/*
	 * 没办法我也不知道怎么改了，要实现这俩的初始化，只能这么干了,这个构造函数不要删
	 */
	public NewsAction(){
		//更新每日推荐焦点图片和排行榜
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());//初始化每日推荐新闻列表
		pictureNewsList = Cache.getNewsList("图片新闻", 0,NewsPageInfo.NEWSPAGEINFO.getPictureNewsCount()-1 );//初始化焦点图片新闻
		hotestNewsList=Cache.getHotestNewsList();	
	}
	
	@SuppressWarnings("unchecked")
	public String pictureNews() throws Exception{
		System.out.println("pictureNews: ");
		//图片新闻
		Session session2 = SingletonSessionFactory.getSession();
		addressList = session2.createCriteria(News.class).add(Restrictions.eq("news_address", news_address)).list();
		session2.close();
		System.out.println(news_address);
		System.out.println(addressList);
		
		
		//更新每日推荐焦点图片和排行榜
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());
		hotestNewsList=Cache.getHotestNewsList();		
		Cache.getNewsList("图片新闻", 0, 3);
		return ActionSupport.SUCCESS;
		
	}

	/*
	 * 获取新闻列表
	 */
	@SuppressWarnings("unchecked")
	public String newsList() throws Exception{
		System.out.println("newsList: "+category);
		if(category==null){//获取所有新闻
			Session session=SingletonSessionFactory.getSession();
			Criteria q=session.createCriteria(News.class);
			newsList=q.list();			
			session.close();
		}else{//根据参数获取对应类别
			newsList=getNewsListByCategory(category, 0, 200);
			newsList=makeCurrentPageList(newsList, NewsPageInfo.NEWSPAGEINFO.getNewsCountOfCategory());
		}
		
		//更新每日推荐焦点图片和排行榜
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());		
		hotestNewsList=Cache.getHotestNewsList();		
		Cache.getNewsList("图片新闻", 0, 3);		
		return ActionSupport.SUCCESS;
		
	}
	
	/*
	 * 获取大类新闻列表
	 */
	public String newsList_Big(){
		Map<String, List<String>> map=GlobalInfo.NewsPageInfo.NEWSPAGEINFO.getMap();
		System.out.println(map);
		Map<String, List<News>> re=new LinkedHashMap<String, List<News>>();		
		if(map.containsKey(category)){
			List<String> list=map.get(category);
			for(String cate:list){
				re.put(cate, new ArrayList<News>(Cache.getNewsList(cate, 0, 10)));
			}
		}		
		//System.out.println(re);
		newsMap=re;
		return ActionSupport.SUCCESS;
	}
	
	
	
	/*
	 * 获取新闻分页
	 */
	@SuppressWarnings("unchecked")
	public String newsPage(){
		System.out.println("newsPage:"+category);
		newsList=getNewsListByCategory(category, 0, 200);
		newsList=makeCurrentPageList(newsList, NewsPageInfo.NEWSPAGEINFO.getNewsCountOfCategory());
		news_list_html = JspToHTML.getJspOutput("/jsp/third/secondPageTable.jsp");
		paginationTable=JspToHTML.getJspOutput("/jsp/base/widgets/paginationTable.jsp");		
		return ActionSupport.SUCCESS;
	}
	

	public String newsSearchByTitle(){
		System.out.println("NewsAction.newsSearchByTitle()");
		System.out.println(keyWords+"keyOoo");
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		try{
			newsList=dao.getNewsListByKeyword(keyWords);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(newsList);
		
		//更新每日推荐焦点图片和排行榜
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());		
		hotestNewsList=Cache.getHotestNewsList();			
		Cache.getNewsList("图片新闻", 0, 3);
		return SUCCESS;
	}

	/*
	 * 获取新闻分类
	 * 
	 * 由于分类加了大类，category不能直接用
	 * 用来替代之前的 Cache.getNewsList(category, start, end)
	 */
	private static List<News> getNewsListByCategory(String category, int start, int end){
		List<News> re;
		re=Cache.getNewsList(category, start, end);
		return re;
	}
	
	
	
	
	
	
	
	/*
	 * getters and setters
	 */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNews_list_html() {
		return news_list_html;
	}

	public void setNews_list_html(String news_list_html) {
		this.news_list_html = news_list_html;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getNews_address() {
		return news_address;
	}

	public void setNews_address(String news_address) {
		this.news_address = news_address;
	}

	public List<News> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<News> addressList) {
		this.addressList = addressList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<News> getNewestNewsList() {
		return newestNewsList;
	}

	public List<News> getPictureNewsList() {
		return pictureNewsList;
	}

	public void setNewestNewsList(List<News> newestNewsList) {
		this.newestNewsList = newestNewsList;
	}

	public void setPictureNewsList(List<News> pictureNewsList) {
		this.pictureNewsList = pictureNewsList;
	}

	public Map<String, List<News>> getNewsMap() {
		return newsMap;
	}

	public void setNewsMap(Map<String, List<News>> newsMap) {
		this.newsMap = newsMap;
	}

	public String getPaginationTable() {
		return paginationTable;
	}

	public void setPaginationTable(String paginationTable) {
		this.paginationTable = paginationTable;
	}

}
