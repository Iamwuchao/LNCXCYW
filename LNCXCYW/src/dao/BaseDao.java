package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/*
 * 数据库操作 DAO接口，所有数据库操作均需要继承自该接口
 */
public interface BaseDao<T,PK> {
	boolean save(T entity) throws Exception;
	boolean update(T entity) throws Exception;
	boolean delete(T entity) throws Exception;
	boolean saveAll(Collection<T> entities);
	List<T> findById(PK pk);
	List<T> find(Serializable id);
}
