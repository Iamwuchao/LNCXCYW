package admin;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDaoImpl;
import mode.User;

public class RequestAction {
	private int userId;
//	private boolean avaliable;
	private List<User> users;
	private String strValue;
	private String isPass;
/**
 * 显示所有没有审核的用户信息
 * @return
 */
public String userRequest(){
	System.out.println("RequestAction.userRequest()");
	UserDaoImpl dao = new UserDaoImpl();
	users = dao.listUserIsTreated(false);
	return ActionSupport.SUCCESS;
}
/**
 * 更改用户状态
 * @return
 */
public String userRequestEnsure(){
	UserDaoImpl dao = new UserDaoImpl();
	boolean avaliable=false;
	if (isPass!=null) {
		if (isPass.equals("0")) {
			avaliable = false;
		}
		else if (isPass.equals("1")) {
			avaliable = true;
		}
	}
	
	if (dao.updateUserIsAvaliable(userId, avaliable)) {
		strValue=ActionSupport.SUCCESS;
		return ActionSupport.SUCCESS;
	}
	return ActionSupport.ERROR;
}
/**
 * 显示所有用户的状态信息
 * @return
 */
public String userRequestResult(){
	UserDaoImpl dao = new UserDaoImpl();
	users =dao.listUsers();
	return ActionSupport.SUCCESS;
}
/**
 * 撤销用户的状态信息,由通过改为不通过
 * @return
 */
public String userRequestChange(){
	return ActionSupport.SUCCESS;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getStrValue() {
	return strValue;
}
public void setStrValue(String strValue) {
	this.strValue = strValue;
}
public String getIsPass() {
	return isPass;
}
public void setIsPass(String isPass) {
	this.isPass = isPass;
}


}
