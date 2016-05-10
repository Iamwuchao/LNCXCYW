package admin;



import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

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
	private String status;
	private String title;
	private String category;
	private String author;
	private String content;
	public String news_list_html;
	private List<News> newsList;
	private List<News> list;
	private List<News> pictureNewsList;
	
	public List<News> getPictureNewsList() {
		return pictureNewsList;
	}

	public void setPictureNewsList(List<News> pictureNewsList) {
		this.pictureNewsList = pictureNewsList;
	}

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	private List<String> categoryList;
	
	private java.util.Date startDate;
	private java.util.Date endDate;
	private String newsMessageTable;
	private String keyWords;
	/**
	 * 删除新闻的id
	 */
	private int newsId;
	/*
	 * 新闻添加
	 */
	public String newsAdd() {
		System.out.println("newsAdd:");
		categoryList=Cache.getNewsCategoryList();
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
//		System.out.println("RRRRRR$$$$$$$$$$$");
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
			dao.deleteNewsByIde(newsId);
			status = "success";
		}catch(Exception e){
			System.out.println("wrong!!!"+e.getMessage());
		}
		
		return SUCCESS;
	}
	
	/*
	 * 提交新闻
	 */
	public String newsSubmit() throws Exception {
		status="0";
		System.out.print("newsSubmit: ");
		System.out.println(title+""+category+""+author);		
		try{
			dao.NewsDao.newsSave(title, author, content, category);
		}catch(Exception e){
			System.out.println("error:"+e.getMessage());
			status="1";
			return SUCCESS;
		}
		System.out.println("save");
		return SUCCESS;
	}

	/*
	 * 获取新闻列表
	 */
	@SuppressWarnings("unchecked")
	public String newsList() throws Exception{
		System.out.println("newsList: "+category);
		Session session1 = SingletonSessionFactory.getSession();
		Criteria q1 = session1.createCriteria(News.class);
		list = q1.list();
		if(category==null){//获取所有新闻
			Session session=SingletonSessionFactory.getSession();
			Criteria q=session.createCriteria(News.class);
			/*list=q.list();*/
			newsList=q.list();
			
			session.close();
		}else{//根据参数获取对应类别
			newsList=Cache.getNewsList(category, 0, 200);
			newsList=makeCurrentPageList(newsList, 10);
		}
		list = Cache.getNewestNewsList(12);
		pictureNewsList = Cache.getNewsList("图片新闻", 0, 3);
		System.out.println(list);
		//System.out.println(newsList);
	//	list = Cache.getNewestNewsList(10);
		System.out.println(list);
		
		
		return ActionSupport.SUCCESS;
		
	}
	
	/*
	 * 获取新闻分页
	 */
	@SuppressWarnings("unchecked")
	public String newsPage(){
		System.out.println("newsPage:"+category);
		newsList=Cache.getNewsList(category, 0, 200);
		newsList=makeCurrentPageList(newsList, 12);
		news_list_html = JspToHTML.getJspOutput("/jsp/third/secondPageTable.jsp");
		return ActionSupport.SUCCESS;
		
	}

	
	/*
	 * getters and setters
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getNewsMessageTable() {
		return newsMessageTable;
	}
	public void setNewsMessageTable(String newsMessageTable) {
		this.newsMessageTable = newsMessageTable;
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
	
	
	
	
}
