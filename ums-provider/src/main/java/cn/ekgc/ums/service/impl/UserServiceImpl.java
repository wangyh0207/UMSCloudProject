package cn.ekgc.ums.service.impl;

import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.dao.UserDao;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.service.UserService;
import cn.ekgc.ums.util.MD5Util;
import cn.ekgc.ums.util.PageUtil;
import cn.ekgc.ums.util.RedisUtil;
import cn.ekgc.ums.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户信息数据业务层接口实现类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>使用手机号码和密码登陆</b>
	 * @param cellphone
	 * @param password
	 * @return
	 */
	@Override
	public String loginUser(String cellphone, String password) throws Exception {
		// 通过手机号码查询用户信息
		User query = new User();
		query.setCellphone(cellphone);
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && userList.size() > 0) {
			User user = userList.get(0);
			password = MD5Util.encrypt(password);
			if (password.equals(user.getPassword())) {
				// 生成 token
				String token = TokenUtil.createToken(user.getId());
				// 存储 token
				redisUtil.saveValue(token, user);
				return token;
			}
		}
		return null;
	}

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<User> getUserForPage(Page<User> page) throws Exception {
		// 创建 PageHelper 分页过滤器
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		// 查询列表
		List<User> list = userDao.findListByQuery(new User());
		// 根据列表获得 PageHelper 的 PageInfo 对象
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// 进行数据切换
		page = PageUtil.parsePageFromPageInfo(page, pageInfo);
		return page;
	}
}
