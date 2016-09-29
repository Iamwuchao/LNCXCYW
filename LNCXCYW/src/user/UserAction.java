package user;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import dao.NewsDao;
import mode.News;
import mode.User;


public class UserAction {
	
	private String authorId;
	private List<News> newsList;
	private String newsMessageTable;
	
	private String email;
	private String username;
	private String college;
	private String studentId;
	private String company;
	private String address;
	private String phoneNumber;
	private String remark;
	private String status;
	


	
	
	
	public String informationChange(){
		System.out.println("informationChange:");
		User user=(User) ActionContext.getContext().getSession().get("user");
		System.out.println(user.getUserId());	
		
		user.setCollege(college);
		user.setStudentId(studentId);
		user.setCompany(company);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		user.setRemark(remark);		
		ActionContext.getContext().getSession().put("user", user);
		//数据路还没写
		return ActionSupport.SUCCESS;
	}
	
	public String projectAdd(){
		System.out.println("projectAdd:");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String projectManage(){
		System.out.println("projectManage:");		
		
		User user=(User) ActionContext.getContext().getSession().get("user");
		
		NewsDao dao=(NewsDao) DaoFactory.getDaoByName(NewsDao.class);
		newsList=dao.getNewsListByID(Integer.valueOf(user.getUserId()));
		System.out.println(newsList);
		
		return ActionSupport.SUCCESS;
	}
	
	public String information() {
		System.out.println("information:");	
		User user=(User) ActionContext.getContext().getSession().get("user");
		System.out.println(user.getUserId());	
		
		email=user.getMail();
		username=user.getUserName();
		college=user.getCollege();
		studentId=user.getStudentId();
		company=user.getCompany();
		address=user.getAddress();
		phoneNumber=user.getPhoneNumber();
		remark=user.getRemark();
		
		System.out.println(username+""+email+""+studentId);
		
		
		return ActionSupport.SUCCESS;
	}
	



	
	
	

	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}


	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
	
	
	public String getNewsMessageTable() {
		return newsMessageTable;
	}


	public void setNewsMessageTable(String newsMessageTable) {
		this.newsMessageTable = newsMessageTable;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
