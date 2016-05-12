package action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import util.JspToHTML;
import util.MyUtil;
import GlobalInfo.PathInfo;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import dao.NewsDao;
import mode.ExamPaper;
import mode.News;
import mode.NewsCategory;



public class TransferAction extends ActionSupport{
	public String test(){
	/*	System.out.println("HHHHHHHHHHHHHHHHHHHHHH");
		try {
			String url = JspToHTML.writeHTML("hehehe");
			System.out.println("DDDDDD "+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXX");*/
		
		/*
		 * 插入500条新闻记录 对每个新闻栏目
		 */
		/*Date date = MyUtil.getSqlDate();
		List<String> list = Cache.getNewsCategoryList();
		NewsDao nd = (NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		for(String str:list){
			for(int i=0;i<50;i++)
			{
				News news = new News();
				news.setAuthor("普利策");
				news.setCategory(Cache.getNewsCategorybyName(str));
				news.setDate(date);
				news.setNews_address("/jsp/homepage.jsp");
				news.setNewsTile("测试新闻");
				try {
					cache.Cache.updateNews(str, news);
					System.out.println(str+"  "+i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
	/*	String content = JspToHTML.getJspOutput("/homepage/homepageGetNewsList.action");
		
		try {
			String url = JspToHTML.writeHTML(PathInfo.HOMEPAGEPATH,content);
			System.out.println(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	/*	List<News> list = Cache.getNewestNewsList(10);
		if(list ==null || list.size()<1){
			System.out.println("why ###################");
		}
		for(News tem:list){
			System.out.println(tem.getNewsTile());
		}*/
		List<ExamPaper> list = Cache.getAllExamPaper();
		for(ExamPaper tem:list){
			System.out.println(tem.getId()+" "+tem.getDescription());
		}
		return ActionSupport.SUCCESS;
	}
}
