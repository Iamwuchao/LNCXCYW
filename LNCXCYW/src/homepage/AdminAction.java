package homepage;

import org.hibernate.Session;

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
//	Session session = SingletonSessionFactory.getSession();
//	session.beginTransaction();
//	User user = new User();
//	user.setMail(email);
//	user.setPassword(password);
//	user.setUserName(username);
//	
	this.register_status = "0";
	return "success";
}

}
