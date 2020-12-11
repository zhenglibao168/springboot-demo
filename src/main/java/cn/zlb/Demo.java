package cn.zlb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * demo
 *
 * @author libao.zheng
 * @date 2020/8/9 12:31 下午
 */
public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "a");
        map.get("1");
    }
}
