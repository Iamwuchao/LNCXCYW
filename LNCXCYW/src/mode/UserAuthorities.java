package mode;

import java.util.List;
/**
 * 每个用户的所有权限
 * @author lh
 *
 */
public class UserAuthorities {
private User user;
private List<UserAuthority> userAuthoritiyList;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public List<UserAuthority> getUserAuthoritiyList() {
	return userAuthoritiyList;
}
public void setUserAuthoritiyList(List<UserAuthority> userAuthoritiyList) {
	this.userAuthoritiyList = userAuthoritiyList;
}

public String toString(){
	return "user:"+user.getUserId()+" list:"+userAuthoritiyList;
}

}
