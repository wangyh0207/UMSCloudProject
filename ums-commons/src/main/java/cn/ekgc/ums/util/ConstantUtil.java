package cn.ekgc.ums.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class ConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("props/system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页信息：每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));

	/**
	 * <b>秘钥</b>
	 */
	public static final String SECRET_KEY = props.getProperty("secret.key");

	/**
	 * <b>redis 存储过期时间</b>
	 */
	public static final Integer REDIS_TIMEOUT_MINUTE = Integer.parseInt(props.getProperty("redis.timeout.minute"));
}
