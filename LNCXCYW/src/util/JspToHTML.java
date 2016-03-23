package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class JspToHTML {
	public static String getHTMLbyJSPPath(String pathofJsp,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		WrapperResponse wrapperResponse = new WrapperResponse(response);
		request.getRequestDispatcher(pathofJsp).include(request, wrapperResponse);
		return wrapperResponse.getContent();
	}
	
	public static void updateStaticHTML(String newContent,String pathofHTMLFile){
		
	}
}
