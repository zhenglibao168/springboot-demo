package cn.zlb.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("testRedis")
    public String testRedis() {
        String key = "name";
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, "zhenglibao");
        return valueOperations.get(key);
    }
}
