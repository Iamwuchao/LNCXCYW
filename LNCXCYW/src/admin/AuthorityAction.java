package admin;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.NewsCategoryDao;
import dao.UserAuthorityDao;
import dao.UserDaoImpl;
import mode.NewsCategory;
import mode.User;
import mode.UserAuthorities;
import mode.UserAuthority;


public class AuthorityAction {
	private List<UserAuthorities> userAuthorities = new ArrayList<UserAuthorities>();
	private List<NewsCategory> categories = new NewsCategoryDao().getAll();
	
	private int selected;
	private int userId;
	private String strValue;
	/**
	 * 查询所有用户已有权限
	 * @return
	 */
	public  String authorityEdit(){
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> users = userDao.listUsers();
		UserAuthorityDao authorityDao = new UserAuthorityDao();
		for(User user : users){
			UserAuthorities uAuthorities = authorityDao.showAuthoritiesByUser(user);
			userAuthorities.add(uAuthorities);
		}
		return ActionSupport.SUCCESS;
	}
	/**
	 * 为指定用户增添权限
	 * @return
	 */
	public String addEnsure(){
		System.out.println(userId+" "+selected);
		UserDaoImpl uDao = new UserDaoImpl();
		//根据前台传过来的userID获得该user对象
		User user = uDao.findUserByTag("userId", userId).get(0);
		NewsCategoryDao nDao = new NewsCategoryDao();
		NewsCategory category = nDao.findNewsCategoryByTag("categoryId", selected).get(0);
		UserAuthorityDao aDao = new UserAuthorityDao();
		aDao.addAuthorityForUser(user, category);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteEnsure(){
		System.out.println(userId+" "+selected);
		UserDaoImpl uDao = new UserDaoImpl();
		//根据前台传过来的userID获得该user对象
		User user = uDao.findUserByTag("userId", userId).get(0);
		NewsCategoryDao nDao = new NewsCategoryDao();
		NewsCategory category = nDao.findNewsCategoryByTag("categoryId", selected).get(0);
		UserAuthorityDao aDao = new UserAuthorityDao();
		aDao.deleteAuthorityForUser(user, category);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteAuthority(){
		return ActionSupport.SUCCESS;
	}
	public List<NewsCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<NewsCategory> categories) {
		this.categories = categories;
	}
	
	public List<UserAuthorities> getUserAuthorities() {
		return userAuthorities;
	}
	public void setUserAuthorities(List<UserAuthorities> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
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
	
}
