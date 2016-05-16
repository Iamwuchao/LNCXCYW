package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.SingletonSessionFactory;

public class BaseDaoImpl<T,PK> implements BaseDao<T,PK>{
	
	protected Class classType;
	
	Session getSession(){
		return SingletonSessionFactory.getSession();
	}

	@Override
	public boolean save(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
		session.save(entity);
		tx.commit();
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	@Override
	public boolean update(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
		session.update(entity);
		tx.commit();
		}catch(Exception e){
			return false;
		}finally{
		session.close();
		}
		return true;
	}

	@Override
	public boolean delete(Object entity){
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
		session.delete(entity);
		tx.commit();
		}catch(Exception e){
			tx.rollback();
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	@Override
	public boolean saveAll(List<T> entities) {
		// TODO Auto-generated method stub
		boolean result = true;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			for(Object ob:entities){
				session.save(ob);
			}
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			result = false;
		}
		session.close();
		return result;
	}

	@Override
	public List<T> findById(String pkname,Object pk) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Criteria crit = session.createCriteria(classType);
		crit.add(Restrictions.eq(pkname, pk));
		List<T> list = crit.list();
		session.close();
		return list;
	}

	public List<T> findPagination(Criteria query,int start, int count) {
		if(start<0 || count<0){
			throw new IllegalArgumentException("start < 0 || count < 0");
		}
		// TODO Auto-generated method stub
		query.setFirstResult(start);
		query.setMaxResults(count);
		List<T> list = query.list();
		return list;
	}

	@Override
	public void setClass(Class classType) {
		// TODO Auto-generated method stub
		this.classType = classType;
	}
}
