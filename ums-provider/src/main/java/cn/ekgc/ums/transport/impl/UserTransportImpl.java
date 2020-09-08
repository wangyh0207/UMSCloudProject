package cn.ekgc.ums.transport.impl;

import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.service.UserService;
import cn.ekgc.ums.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public String loginUser(@RequestParam String cellphone,@RequestParam String password) throws Exception {
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

	/**
	 * <b>保存用户信息</b>
	 * @return
	 * @throws Exception
	 */
	@Override
	@PostMapping("/save")
	public boolean save(@RequestBody User user) throws Exception {
		return userService.save(user);
	}

	/**
	 * <b>根据 id 查找对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id")
	@Override
	public User getById(@RequestParam Long id) throws Exception {
		return userService.getById(id);
	}
}
