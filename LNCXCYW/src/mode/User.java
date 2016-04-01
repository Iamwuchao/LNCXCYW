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
	private int role;
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
