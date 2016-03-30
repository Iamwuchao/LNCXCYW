package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import util.SingletonSessionFactory;

public class BaseDaoImpl<T,PK> implements BaseDao{
	
	Session getSession(){
		return SingletonSessionFactory.getSession();
	}

	@Override
	public boolean save(Object entity){
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean update(Object entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAll(Collection entities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findById(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findPagination(int start, int end) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
}
