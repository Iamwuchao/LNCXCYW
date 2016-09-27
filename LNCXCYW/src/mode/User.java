package mode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="user_table")
public class User {
	
	private int userId;
	private String userName;
	private String mail;
	private String password;
	private String school;
	private String college;
	private String remark;
	private String studentId;
	private String phoneNumber;
	private String company;
	private String address;
	
	private int role;// 0:管理员  2:学生用户    3:企业用户
	private boolean avaliable;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	
	@Column(name="user_name",nullable=false)
	public String getUserName() {
		return userName;
	}
	
	@Column(name="mail" ,nullable=false)
	public String getMail() {
		return mail;
	}
	
	@Column(name="password",nullable=false)
	public String getPassword() {
		return password;
	}
	
	@Column(name="role",nullable=false,columnDefinition="INT default 0")
	public int getRole() {
		return role;
	}
	
	
	@Column(name="avaliable" ,columnDefinition="BOOLEAN DEFAULT false")
	public boolean getAvaliable() {
		return avaliable;
	}
	
	
	
	
	@Column
	public String getSchool() {
		return school;
	}
	
	@Column
	public String getCollege() {
		return college;
	}
	
	@Column
	public String getRemark() {
		return remark;
	}
	
	@Column
	public String getStudentId() {
		return studentId;
	}
	
	@Column
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Column
	public String getCompany() {
		return company;
	}
	
	@Column
	public String getAddress() {
		return address;
	}
	
	
	
	



	public void setSchool(String school) {
		this.school = school;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
