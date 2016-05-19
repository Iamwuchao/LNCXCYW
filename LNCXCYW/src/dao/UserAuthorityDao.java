package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mode.NewsCategory;
import mode.User;
import mode.UserAuthorities;
import mode.UserAuthority;

public class UserAuthorityDao extends BaseDaoImpl<UserAuthority, Integer>{
/**
 * 显示某个用户的权限
 * @param user
 * @return
 */
	public UserAuthorities showAuthoritiesByUser(User user){
	UserAuthorities userAuthorities=new UserAuthorities();;
	List<UserAuthority> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(UserAuthority.class);
	list = criteria.add(Restrictions.eq("user", user)).list();
//	if (list.size()>0) {
//		userAuthorities = new UserAuthorities();
		userAuthorities.setUser(user);
		userAuthorities.setUserAuthoritiyList(list);
//		userAuthorities.setAuthorityArray(authorityArray);
//	}
		session.close();
	return userAuthorities;
}
	public void addAuthorityForUser(User user, NewsCategory category){
		List<UserAuthority> list;
		Session session = getSession();
		Criteria criteria = session.createCriteria(UserAuthority.class);
		list = criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("category", category))
				.list();
		//用户已经有了该权限
		if (list.size()>0) {
			session.close();
			return;
		}
		//如果用户没有改权限，则给用户增加该权限
		else {
			UserAuthority userAuthority = new UserAuthority();
			userAuthority.setUser(user);
			userAuthority.setCategory(category);
			save(userAuthority);
			session.close();
		}
	}
	
	public void deleteAuthorityForUser(User user, NewsCategory category){

		List<UserAuthority> list;
		Session session = getSession();
		Criteria criteria = session.createCriteria(UserAuthority.class);
		list = criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("category", category))
				.list();
		//用户拥有该权限，则删除
		if (list.size()>0) {
			UserAuthority userAuthority = list.get(0);
			Transaction tx = session.beginTransaction();
			session.delete(userAuthority);
			tx.commit();
			//delete(userAuthority);
			session.close();
		}
		//
		else {
			session.close();
			return;
		}
	
	}
	
	
}
