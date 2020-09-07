package cn.ekgc.ums.dao;

import cn.ekgc.ums.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>用户信息数据持久层接口</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据查询对象查询列表信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findListByQuery(User query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(User entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(User entity) throws Exception;
}
