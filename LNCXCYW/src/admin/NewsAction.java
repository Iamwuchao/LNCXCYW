package admin;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import GlobalInfo.NewsPageInfo;
import cache.Cache;
import dao.DaoFactory;
import dao.NewsDao;
import dao.UserAuthorityDao;
import mode.News;
import mode.User;
import mode.UserAuthorities;
import mode.UserAuthority;
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
	private int authorId;
	private String source;
	private String content;
	private String date;
	private String pictureLink;
	public String news_list_html;
	private List<News> newsList;
	private List<String> categoryList;
	

	private java.util.Date startDate;
	private java.util.Date endDate;
	private String keyWords;
	private int newsId;//删除新闻的id
	
	private List<News> newestNewsList;//每日推荐的新闻列表
	private List<News> pictureNewsList;//焦点图片新闻列表
	private List<News> hotestNewsList;//排行榜新闻列表
	private List<News> projectList;//对接项目列表
	private String newsMessageTable;//返回给前台显示的的新闻HTML字符串
	private String status;
	
	private String newsRowID;
	private String isPass;
	private String strValue;
	/*
	 * 没办法我也不知道怎么改了，要实现这俩的初始化，只能这么干了
	 */
	public NewsAction(){
		System.out.println("构造函数");
		newestNewsList = Cache.getNewestNewsList(NewsPageInfo.NEWSPAGEINFO.getNewestNewsCount());//初始化每日推荐新闻列表
		pictureNewsList = Cache.getNewsList("图片新闻链接", 0, NewsPageInfo.NEWSPAGEINFO.getPictureNewsCount());//初始化焦点图片新闻
		hotestNewsList=Cache.getHotestNewsList();	
		System.out.println(pictureNewsList);
	}
	
	
	public String projectManage() {
		System.out.println("getProjectList:");
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		projectList=dao.getUnhandledProject();	
		System.out.println(projectList);
		return SUCCESS;
	}
	
	/*
	 * 审核通过对接项目
	 */
	public String projectRequestEnsure(){
		System.out.println("projectRequestEnsure: "+newsRowID+" "+isPass);		
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		int avaliable=0;;
		if (isPass.equals("0")) {
			avaliable = 1;
		}
		else if (isPass.equals("1")) {
			avaliable = 2;
		}
		
		if(dao.updateNewsIsPassed(newsRowID, avaliable)){
			
			News news=dao.getNewsByID(Integer.valueOf(newsRowID));
			try{
				Cache.updateNews(news.getCategory().getNewscategory(), news);//更新到缓存,异常没有处理
			}catch(Exception e){
				return ActionSupport.ERROR;
			}
			System.out.println("ok!");
			strValue=ActionSupport.SUCCESS;
			return ActionSupport.SUCCESS;
		}		
		return ActionSupport.ERROR;
	}
	
	
	
	/**
	 * 新闻添加
	 * 
	 * @return
	 */
	public String newsAdd() {
		System.out.println("newsAdd:");
		//获取当前登录的用户
		HttpSession session=ServletActionContext.getRequest().getSession();
		User nowUser=(User)session.getAttribute("user");
		//System.out.println(nowUser.getMail());
		
		//查找对应的权限
		UserAuthorityDao authorityDao = new UserAuthorityDao();
		UserAuthorities uAuthorities = authorityDao.showAuthoritiesByUser(nowUser);
		categoryList=new ArrayList<String>();
		for(UserAuthority L: uAuthorities.getUserAuthoritiyList()){
			categoryList.add(L.getCategory().getNewscategory());
		}			
		//System.out.println(categoryList);
		return SUCCESS;
	}
	
	
	
	public String pictureLink() {
		System.out.println("pictureLink: "+newsRowID);
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
		SimpleDateFormat  formatter=new SimpleDateFormat("yyyy-MM-dd");
		date=formatter.format(new java.util.Date());
		System.out.println(authorId+" "+title+" "+source+" "+category+" "+author+" "+date);	
		int isPassed=2;
		if(category.equals("项目推介")||category.equals("企业需求")){
			isPassed=0;
		}
		
		try{
			dao.NewsDao.newsSave(title, author, authorId, content, category, isPassed, pictureLink);//保存新闻的时候直接通过，不用审核
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


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public List<News> getNewestNewsList() {
		return newestNewsList;
	}


	public void setNewestNewsList(List<News> newestNewsList) {
		this.newestNewsList = newestNewsList;
	}


	public List<News> getPictureNewsList() {
		return pictureNewsList;
	}


	public void setPictureNewsList(List<News> pictureNewsList) {
		this.pictureNewsList = pictureNewsList;
	}


	public List<News> getHotestNewsList() {
		return hotestNewsList;
	}


	public void setHotestNewsList(List<News> hotestNewsList) {
		this.hotestNewsList = hotestNewsList;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<News> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<News> projectList) {
		this.projectList = projectList;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public String getPictureLink() {
		return pictureLink;
	}


	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}


	public String getNewsRowID() {
		return newsRowID;
	}


	public void setNewsRowID(String newsRowID) {
		this.newsRowID = newsRowID;
	}


	public String getStrValue() {
		return strValue;
	}


	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}


	public String getIsPass() {
		return isPass;
	}


	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}



	

}
