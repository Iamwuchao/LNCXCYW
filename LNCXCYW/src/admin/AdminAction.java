package admin;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDao;
import dao.DaoFactory;
import dao.NewsCategoryDao;
import dao.UserDaoImpl;
import mode.NewsCategory;
import mode.User;
import mode.UserAuthority;
import util.Password;
import util.SingletonSessionFactory;
import util.mail.MailSenderInfo;
import util.mail.SimpleMailSender;

public class AdminAction {
private String username;
private String password;
private String email;
private String register_status;
private String college;
private String phoneNumber;
private String remark;
private String studentId;
private String company;
private int role;


/**
 * 退出登录
 * @return
 */
public String logout(){
	Map session = ActionContext.getContext().getSession();
	session.remove("user");
	return ActionSupport.SUCCESS;
}
	
	
	public String regist(){
		System.out.println("regist: "+role);
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(email);
		
		UserDaoImpl dao = new UserDaoImpl();
		
		User u = new User();
		u.setMail(email);
		u.setPassword(password);
		u.setUserName(username);
		List<User> list = dao.findUserByEmail(email);
		if (list.size()>0) {
			this.register_status = "1";
		}
		else {
			if(role==2){
				u.setCollege(college);
				u.setStudentId(studentId);
				
			}
			if(role == 3){
				u.setCompany(company);
			}
			u.setRole(role);
			u.setPhoneNumber(phoneNumber);
			u.setRemark(remark);
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
		List<User> list2 = dao.findAvaliableUser(email, password);
		List<User> list3 = dao.findAvaliableSuperUser(email, password);
		if (list3.size()>0) {
			this.register_status="3";//超级管理员
			Map session = ActionContext.getContext().getSession();
			session.put("user", list3.get(0));
		}
		else if (list2.size()>0) {//普通管理员
			this.register_status = "0";
			Map session = ActionContext.getContext().getSession();
			session.put("user", list2.get(0));
		}
		else if (list.size()>0 && list2.size()==0) {
			this.register_status = "审核还未通过，请等待";
		}
		
		else if (list.size()==0) {
			this.register_status = "1";//用户名或密码错误
		}
		
		
		
		return ActionSupport.SUCCESS;
	}
	/**
	 * 找回密码
	 * @return
	 */
	public String findPassword(){
		System.out.println(email);
		UserDaoImpl dao = new UserDaoImpl();
		try{
			List<User> userList = dao.findUserByEmail(email);
			if(userList ==null || userList.size()==0){
				this.register_status = "该邮箱未被注册";
				return "success";
			}
			User user = userList.get(0);
			String newPass = Password.getNewPassword();
			user.setPassword(newPass);
			dao.updateUserInfo(user);
			//发送邮件
			
				MailSenderInfo mailInfo = new MailSenderInfo();  
			    mailInfo.setMailServerHost("smtp.163.com");  
			    mailInfo.setMailServerPort("25");  
			    mailInfo.setValidate(true);  
			    mailInfo.setUserName("wutongshu0325@163.com"); // 实际发送者  1
			    mailInfo.setPassword("123456lu");// 您的邮箱密码  
			    mailInfo.setFromAddress("wutongshu0325@163.com"); // 设置发送人邮箱地址 和1处相同 
			    mailInfo.setToAddress(email); // 设置接受者邮箱地址  
			    mailInfo.setSubject("找回密码");  
			    mailInfo.setContent("您好辽宁省大学生创新创业网，您的密码已重新设置为："+newPass);  
			    // 这个类主要来发送邮件  
			    SimpleMailSender sms = new SimpleMailSender();  
			    sms.sendTextMail(mailInfo); // 发送文体格式  
	//		    sms.sendHtmlMail(mailInfo); // 发送html格式 
			    this.register_status = "ok";		
		}
		catch(Exception e){
			e.printStackTrace();
			this.register_status = "操作失败";
		}
		return "success";
	}
	/**
	 * 发送邮件
	 */
	public void sendEmail(){
		// 这个类主要是设置邮件  
	    MailSenderInfo mailInfo = new MailSenderInfo();  
	    mailInfo.setMailServerHost("smtp.163.com");  
	    mailInfo.setMailServerPort("25");  
	    mailInfo.setValidate(true);  
	    mailInfo.setUserName("wutongshu0325@163.com"); // 实际发送者  1
	    mailInfo.setPassword("123456lu");// 您的邮箱密码  
	    mailInfo.setFromAddress("wutongshu0325@163.com"); // 设置发送人邮箱地址 和1处相同 
	    mailInfo.setToAddress("wutongshu1993@qq.com"); // 设置接受者邮箱地址  
	    mailInfo.setSubject("么么么么哒");  
	    mailInfo.setContent("设置邮箱内容<b>h6啊啊啊啊么么哒</b>");  
	    // 这个类主要来发送邮件  
	    SimpleMailSender sms = new SimpleMailSender();  
	    sms.sendTextMail(mailInfo); // 发送文体格式  
	    sms.sendHtmlMail(mailInfo); // 发送html格式  
	}
	//public static void main(String[] args){
	//	UserDaoImpl dao = new UserDaoImpl();
	//	User user = dao.findUserByEmail("510719804@qq.com").get(0);
	//	user.setUserName("Hui");
	//	dao.updateUserInfo(user);
	//}
	public String execute(){
		return "success";
	}
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}




}
