package cn.zlb.redis;

import cn.zlb.biz.domain.UserDO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * redis客户端
 *
 * @author libao.zheng
 * @date 2020/8/19 3:23 下午
 */
@RestController
public class RedisController {
    public static final int BASE_ID = 10000;
    public static final String CASE_ID_KEY = "caseId";
    public static final String COUNT_KEY = "count";
    public static final String LIMIT_KEY = "limit";
    public static final int TPS_LIMIT = 10;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    private void initRedis() {
        redisTemplate.opsForValue().setIfAbsent(CASE_ID_KEY, BASE_ID);
        redisTemplate.opsForValue().setIfAbsent(COUNT_KEY, 0);
        redisTemplate.opsForValue().setIfAbsent(LIMIT_KEY, 0);
    }

    /**
     * 存储字符串
     */
    @GetMapping("testRedisString")
    public Object testRedis2() {
        String key = "name";
        redisTemplate.opsForValue().set(key, "test");
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储对象
     */
    @GetMapping("testRedisObject")
    public Object testRedis() {
        String key = "user1";
        redisTemplate.opsForValue().set(key, new UserDO(1L, "张三", "10086", "zhangsan@163.com"));
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * id生成器
     *
     * @return
     */
    @GetMapping("createId")
    public Object createId() {
        return redisTemplate.opsForValue().increment(CASE_ID_KEY);
    }

    /**
     * 计数器
     *
     * @return
     */
    @GetMapping("count")
    public Object count() {
        return redisTemplate.opsForValue().increment(COUNT_KEY);
    }

    @GetMapping("limit")
    public Object limit() {
        return null;
    }
}
