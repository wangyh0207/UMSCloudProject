package cn.ekgc.ums.controller;

import cn.ekgc.ums.base.controller.BaseController;
import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.base.pojo.vo.ResponseVO;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.transport.UserTransport;
import cn.ekgc.ums.util.MD5Util;
import cn.ekgc.ums.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户信息控制器</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>用户登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginUser(String cellphone, String password) throws Exception {
		// 校验用户登陆提交信息
		if (ValidationUtil.checkCellphone(cellphone) && ValidationUtil.checkPassword(password)) {
			// 用户登陆信息有效
			String token = userTransport.loginUser(cellphone, password);
			if (token != null) {
				// 将 token 返回到前端页面
				return ResponseVO.successResponse(token);
			}
		}
		return ResponseVO.errorResponse("请填写正确的登陆信息");
	}

	/**
	 * <b>分页查询对象</b>
	 * @param pageNum
	 * @param pageSize
	 * @param draw
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public ResponseVO queryUserForPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 封装分页视图对象 Page
		Page<User> page = new Page<User>(pageNum, pageSize, draw);
		// 使用分页视图对象查询 Page 对象
		page = userTransport.getUserForPage(page);
		// 使用 Page 创建返回视图对象
		return ResponseVO.successResponse(page);
	}

	/**
	 * <b>保存用户信息</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public ResponseVO save(User user) throws Exception {
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		boolean flag = userTransport.save(user);
		if (flag) {
			return ResponseVO.successResponse("保存成功！");
		}
		return ResponseVO.errorResponse("保存失败！");
	}

	/**
	 * <b>根据 id 查找对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		User user = userTransport.getById(id);
		return ResponseVO.successResponse(user);
	}
}
