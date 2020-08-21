package cn.zlb.redis;

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

    @GetMapping("testRedis")
    public Object testRedis() {
        String key = "name";
        redisTemplate.opsForValue().set(key, "test");
        return redisTemplate.opsForValue().get(key);
    }
}
