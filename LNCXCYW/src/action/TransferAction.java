package action;

import java.io.IOException;
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

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
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
		Cache.getNewsCategoryList();
		return ActionSupport.SUCCESS;
	}
}
