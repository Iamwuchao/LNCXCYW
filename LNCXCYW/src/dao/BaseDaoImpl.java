package dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.SingletonSessionFactory;

public class BaseDaoImpl<T,PK> implements BaseDao{
	
	private Class classType;
	
	Session getSession(){
		return SingletonSessionFactory.getSession();
	}

	@Override
	public void save(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public boolean update(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public boolean delete(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public void saveAll(Collection<T> entities) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		for(Object ob:entities){
			session.save(ob);
		}
		tx.commit();
		session.close();
	}

	@Override
	public List findById(Object pk) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Criteria crit = session.createCriteria(classType);
		crit.add(Restrictions.eq("id", pk));
		List list = crit.list();
		session.close();
		return list;
	}


	public List<T> findPagination(Criteria query,int start, int end) {
		if(start>end){
			throw new IllegalArgumentException("start > end");
		}
		// TODO Auto-generated method stub
		query.setFirstResult(start);
		query.setMaxResults(end-start);
		List<T> list = query.list();
		return list;
	}

	@Override
	public void setClass(Class classType) {
		// TODO Auto-generated method stub
		this.classType = classType;
	}
	
}
