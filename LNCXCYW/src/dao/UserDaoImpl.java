package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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

}
