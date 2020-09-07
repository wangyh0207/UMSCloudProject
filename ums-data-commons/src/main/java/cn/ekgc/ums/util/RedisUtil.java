package cn.ekgc.ums.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>Redis 工具类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	public boolean saveValue(String key, Object value) throws Exception {
		// 将 Object 对象转换为 json
		JsonMapper jsonMapper = new JsonMapper();
		String valueJson = jsonMapper.writeValueAsString(value);
		// 保存到 Redis
		redisTemplate.opsForValue().set(key, valueJson);
		// 设定过期时间
		redisTemplate.expire(key, ConstantUtil.REDIS_TIMEOUT_MINUTE, TimeUnit.MINUTES);
		return true;
	}
}
