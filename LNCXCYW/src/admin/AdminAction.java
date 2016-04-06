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
		this.register_status = "0";
	}
	return ActionSupport.SUCCESS;
	
}
public String login(){
	System.out.println(password);
	System.out.println(email);
	UserDaoImpl dao = new UserDaoImpl();
	List<User> list = dao.findUserByEmailAndPass(email, password);
	if (list.size()>0) {
		this.register_status = "0";
	}
	else {
		this.register_status = "1";
	}
	return ActionSupport.SUCCESS;
}
public String execute(){
	return "success";
}
}
