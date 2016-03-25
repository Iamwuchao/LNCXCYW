package mode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_table")
public class User {
	
	private int userId;
	private String userName;
	private String mail;
	private String password;
	private int role;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	
	@Column(name="mail")
	public String getMail() {
		return mail;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	@Column(name="role")
	/*@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="role_check")*/
	public int getRole() {
		return role;
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
