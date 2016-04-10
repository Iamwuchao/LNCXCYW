package admin;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import dao.UserDaoImpl;
import mode.NewsCategory;
import mode.User;
import mode.UserAuthority;
import util.SingletonSessionFactory;

public class AdminAction {
private String username;
private String password;
private String email;
private String register_status;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public String getRegister_status() {
	return register_status;
}

public void setRegister_status(String register_status) {
	this.register_status = register_status;
}

public String regist(){
	System.out.println(username);
	System.out.println(password);
	System.out.println(email);
	
	UserDaoImpl dao = new UserDaoImpl();
	
	
//	BaseDao bd = DaoFactory.getDaoByName(User.class);
	User u = new User();
	u.setMail(email);
	u.setPassword(password);
	u.setUserName(username);
	List<User> list = dao.findUserByEmail(email);
	if (list.size()>0) {
		this.register_status = "1";
	}
	else {
		dao.save(u);
//		UserAuthority userAuthority = new UserAuthority();
//		userAuthority.setUser(u);
//		dao.save(userAuthority);
		this.register_status = "0";
	}
	
	return ActionSupport.SUCCESS;
	
}
public String login(){
	System.out.println(password);
	System.out.println(email);
	UserDaoImpl dao = new UserDaoImpl();
	List<User> list = dao.findUserByEmailAndPass(email, password);
	List<User> list2 = dao.findAvaliableUser(email, password);
	List<User> list3 = dao.findAvaliableSuperUser(email, password);
	if (list3.size()>0) {
		this.register_status="3";//超级管理员
	}
	else if (list2.size()>0) {//普通管理员
		this.register_status = "0";
	}
	else if (list.size()>0 && list2.size()==0) {
		this.register_status = "审核还未通过，请等待";
	}
	
	else if (list.size()==0) {
		this.register_status = "1";//用户名或密码错误
	}
	
	
	
	return ActionSupport.SUCCESS;
}
public String execute(){
	return "success";
}
}
