package admin;



import java.sql.Date;
import java.util.List;


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

	

	private java.util.Date startDate;
	private java.util.Date endDate;
	private String keyWords;
	private int newsId;//删除新闻的id
	
	
	
	
	/**
	 * 新闻添加
	 * 
	 * @return
	 */
	public String newsAdd() {
		System.out.println("newsAdd:");
		Cache.getNewsCategoryList();
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
		}
		JspToHTML.getJspOutput("/jsp/admin/widgets/news_message_table.jsp");
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
		}
		JspToHTML.getJspOutput("/jsp/admin/widgets/news_message_table.jsp");
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

	
}
