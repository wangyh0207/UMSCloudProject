package cn.ekgc.ums.transport;

import cn.ekgc.ums.base.pojo.vo.Page;
import cn.ekgc.ums.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户信息传输务层接口</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@FeignClient(name = "ums-provider")
@RequestMapping("/trans/user")
public interface UserTransport {
	/**
	 * <b>使用手机号码和密码登陆</b>
	 * @param cellphone
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	String loginUser(@RequestParam String cellphone, @RequestParam String password) throws Exception;

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	Page<User> getUserForPage(@RequestBody Page<User> page) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody User user) throws Exception;

	/**
	 * <b>根据 id 查找对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id")
	User getById(@RequestParam("id") Long id) throws Exception;
}
