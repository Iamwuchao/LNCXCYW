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



public class TransferAction extends ActionSupport{
	public String test(){
		System.out.println("hehehe");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("TTTTTTT");
		try {
			JspToHTML.getHTMLbyJSPPath("/jsp/homepage/homepage.jsp", request, response);
			String str = JspToHTML.writeHTML("ttt");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
}
