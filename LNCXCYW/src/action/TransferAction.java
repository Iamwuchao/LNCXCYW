package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import util.JspToHTML;

import com.opensymphony.xwork2.ActionSupport;



public class TransferAction extends ActionSupport{
	public String test(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			JspToHTML.getHTMLbyJSPPath("/jsp/homepage/homepage.jsp", request, response);
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
}
