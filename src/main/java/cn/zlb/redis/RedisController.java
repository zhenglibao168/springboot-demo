package cn.zlb.redis;

import cn.zlb.biz.domain.UserDO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis客户端
 *
 * @author libao.zheng
 * @date 2020/8/19 3:23 下午
 */
@RestController
public class RedisController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储字符串
     */
    @GetMapping("testRedis2")
    public Object testRedis2() {
        String key = "name";
        redisTemplate.opsForValue().set(key, "test");
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储对象
     */
    @GetMapping("testRedis")
    public Object testRedis() {
        String key = "user1";
        redisTemplate.opsForValue().set(key, new UserDO(1L, "张三", "10086", "zhangsan@163.com"));
        return redisTemplate.opsForValue().get(key);
    }
}
