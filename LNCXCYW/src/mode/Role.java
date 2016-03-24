package mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_authority_table")
public class Role {
	private int roleId;
	private String roleDescription;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRoleId() {
		return roleId;
	}
	
	@Column(name="role_name")
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
}
