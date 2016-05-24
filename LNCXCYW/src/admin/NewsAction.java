package admin;



import java.sql.Date;
import java.util.List;



import GlobalInfo.NewsPageInfo;
import cache.Cache;
import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
import util.JspToHTML;
import util.PageGetBaseAction;

public class NewsAction extends PageGetBaseAction{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String category;
	private String author;
	private String content;
	public String news_list_html;
	private List<News> newsList;
	private List<String> categoryList;
	

	private java.util.Date startDate;
	private java.util.Date endDate;
	private String keyWords;
	private int newsId;//删除新闻的id
	
	private List<News> newestNewsList;//每日推荐的新闻列表
	private List<News> pictureNewsList;//焦点图片新闻列表
	private String newsMessageTable;//返回给前台显示的的新闻HTML字符串
	private String status;
	/*
	 * 没办法我也不知道怎么改了，要实现这俩的初始化，只能这么干了
	 */
	public NewsAction(){
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());//初始化每日推荐新闻列表
		pictureNewsList = Cache.getNewsList("图片新闻", 0, NewsPageInfo.NEWSPAGEINFO.getPictureNewsCount());//初始化焦点图片新闻
	}
	
	/**
	 * 新闻添加
	 * 
	 * @return
	 */
	public String newsAdd() {
		System.out.println("newsAdd:");
		categoryList=Cache.getNewsCategoryList();
		//System.out.println(categoryList);
		for(int i=0; i<categoryList.size(); i++){
			if(categoryList.get(i).equals("素质测评")){
				categoryList.remove(i);
				break;
			}			
		}
		//System.out.println(categoryList);
		return SUCCESS;
	}
	
	/**
	 * 按照关键字查询
	 * @return
	 */
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
		if (newsList.size()>0) {
			status = "1";
		}
		newsMessageTable = JspToHTML.getJspOutput("/jsp/admin/widgets/news_message_table.jsp");
		return SUCCESS;
	}
	
	/**
	 * 按照时间进行查询
	 * @return
	 */
	public String newsSearchByTime(){
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		System.out.println("NewsAction.newsSearchByTime()");
		Date start=new Date(startDate.getTime());
		Date end=new Date(endDate.getTime());
		System.out.println(start+" "+end);
		try{
			newsList = dao.getNewsListByDate(start, end);
		}catch(Exception e){
			System.out.println("查询失败！  日期不对");
		}
		if (newsList.size()>0) {
			status = "1";
		}
		newsMessageTable = JspToHTML.getJspOutput("/jsp/admin/widgets/news_message_table.jsp");
		//System.out.println("RRRRRR$$$$$$$$$$$");
		return SUCCESS;
	}
	
	/**
	 * 删除新闻
	 * @return
	 */
	public String newsDelete(){
		
		System.out.println("NewsAction.newsDelete()");
		System.out.println(newsId);
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		try{
			dao.deleteNewsById(newsId);
			status = "success";
		}catch(Exception e){
			System.out.println("wrong!!!"+e.getMessage());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 提交新闻
	 * 
	 * @return
	 * @throws Exception
	 */
	public String newsSubmit() throws Exception {
		System.out.print("newsSubmit: ");
		System.out.println(title+""+category+""+author);		
		try{
			dao.NewsDao.newsSave(title, author, content, category);
		}catch(Exception e){
			System.out.println("error:"+e.getMessage());
			return SUCCESS;
		}
		System.out.println("save");
		return SUCCESS;
	}
	
	

	
	/*
	 * getters and setters
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
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

	public String getNewsMessageTable() {
		return newsMessageTable;
	}

	public void setNewsMessageTable(String newsMessageTable) {
		this.newsMessageTable = newsMessageTable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
