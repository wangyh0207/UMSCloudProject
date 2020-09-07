package cn.ekgc.ums.transport.impl;

import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.service.UserService;
import cn.ekgc.ums.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>用户信息传输务层接口实现类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("userTransport")
@RequestMapping("/trans/user")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>使用手机号码和密码登陆</b>
	 * @param cellphone
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	@Override
	public String loginUser(String cellphone, String password) throws Exception {
		return userService.loginUser(cellphone, password);
	}

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public Page<User> getUserForPage(Page<User> page) throws Exception {
		return userService.getUserForPage(page);
	}
}
