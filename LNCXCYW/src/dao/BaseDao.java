package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/*
 * 数据库操作 DAO接口，所有数据库操作均需要继承自该接口
 */
public interface BaseDao<T,PK> {
	/*
	 * 返回函数是否执行成功 如果中间出现异常可选择向上抛出
	 */
	boolean save(T entity);
	boolean update(T entity) throws Exception;
	boolean delete(T entity) throws Exception;
	boolean saveAll(Collection<T> entities);
	
	List<T> findById(PK pk);
	List<T> find(Serializable id);
	List findPagination(int start, int end);
}
