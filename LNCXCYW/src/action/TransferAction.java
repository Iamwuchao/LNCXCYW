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
		System.out.println("HHHHHHHHHHHHHHHH");
		List<String> list = Cache.getNewsCategoryList();
		for(String str:list){
			System.out.println(str);
		}
		NewsCategoryDao  ncd = (NewsCategoryDao) DaoFactory.getDaoByName(NewsCategoryDao.class);
		NewsCategory nc = new NewsCategory();
		nc.setNewscategory("测试中文乱码");
		ncd.save(nc);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXX");
		return ActionSupport.SUCCESS;
	}
}
