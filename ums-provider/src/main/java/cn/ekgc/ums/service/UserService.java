package cn.ekgc.ums.service;

import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.pojo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <b>用户信息数据业务层接口</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public interface UserService {

	/**
	 * <b>使用手机号码和密码登陆</b>
	 * @param cellphone
	 * @param password
	 * @return
	 */
	String loginUser(String cellphone, String password) throws Exception;

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<User> getUserForPage(Page<User> page) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @return
	 * @throws Exception
	 */
	boolean save(User user) throws Exception;

	/**
	 * <b>根据 id 查找对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getById(Long id) throws Exception;
}
