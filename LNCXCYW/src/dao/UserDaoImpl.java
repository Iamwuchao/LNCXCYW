package dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mode.User;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> {
public List<User> findUserByEmail(String email){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq("mail", email)).list();
	return list;
}

public List<User> findUserByEmailAndPass(String email,String pass){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq("mail", email))
			.add(Restrictions.eq("password", pass)).list();
	return list;
}
public List<User> findAvaliableUser(String email,String pass){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq("mail", email))
			.add(Restrictions.eq("password", pass))
			.add(Restrictions.eq("avaliable", true)).list();
	return list;
}
public List<User> findAvaliableSuperUser(String email,String pass){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq("mail", email))
			.add(Restrictions.eq("password", pass))
			.add(Restrictions.eq("avaliable", true))
			.add(Restrictions.eq("role", 1)).list();
	return list;
}
/**
 * 返回所有该类状态的user数组
 * @return
 */
public List<User> listUserIsTreated(boolean isAvaliable){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq("avaliable", isAvaliable)).list();
	return list;
}
/**
 * 更新用户状态
 * @param id
 * @param isAvaliable
 * @return
 */
public boolean updateUserIsAvaliable(int id, boolean isAvaliable){
	Session session = getSession();
	Transaction trans=session.beginTransaction();
	String hql="update User u set u.avaliable="+
			isAvaliable+" where u.userId="+id;
Query q=session.createQuery(hql);
int ret = q.executeUpdate();
trans.commit();
if (ret>0) {
	return true;
}
	return false;
}
public List<User> listUsers(){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.list();
	Collections.reverse(list);
	session.close();
	return list;
}

public List<User> findUserByTag(String name, Object value){
	List<User> list;
	Session session = getSession();
	Criteria criteria = session.createCriteria(User.class);
	list = criteria.add(Restrictions.eq(name, value)).list();
	session.close();
	return list;
}
public void setAuthority(User u, int category){
	Session session = getSession();
	
}
}
