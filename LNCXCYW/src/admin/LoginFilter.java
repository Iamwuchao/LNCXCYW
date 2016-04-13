package admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mode.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpServletResponse servletResponse = (HttpServletResponse)response;
		HttpSession session = servletRequest.getSession();
		
		//获得用户请求的URI
		String path = servletRequest.getRequestURI();
		System.out.println(path);
		
		//从session中获取用户信息
		User user = (User)session.getAttribute("user");
		
		//登录注册页面无需过滤
		if (path.indexOf("/login.jsp") > -1 || path.indexOf("/regist.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		//如果没有获取到员工信息，就跳转到登录页面
		if (user == null) {
			servletResponse.sendRedirect("/jsp/homepage/login.jsp");
		}
		else {
			//已经登录，继续此次请求
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
