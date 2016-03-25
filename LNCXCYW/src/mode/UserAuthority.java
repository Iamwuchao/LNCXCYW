package mode;

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
@Table(name="user_authority_table")

public class UserAuthority {
	private int id;
	private User user;
	private NewsCategory category;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	public User getUser() {
		return user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	public NewsCategory getCategory() {
		return category;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setCategory(NewsCategory category) {
		this.category = category;
	}
	
	
}
