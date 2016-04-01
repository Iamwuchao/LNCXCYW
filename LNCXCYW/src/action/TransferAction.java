package action;

import java.io.IOException;

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

import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import mode.NewsCategory;



public class TransferAction extends ActionSupport{
	public String test(){
		BaseDao bd = DaoFactory.getDaoByName(NewsCategoryDao.class);
		NewsCategory nc = new NewsCategory();
		nc.setNewscategory("创业实践");
		bd.save(nc);
		
		return ActionSupport.SUCCESS;
	}
}
