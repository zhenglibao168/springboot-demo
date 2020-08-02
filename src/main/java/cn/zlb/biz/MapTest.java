package cn.zlb.biz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * map 测试
 *
 * @author libao.zheng
 * @date 2020/7/30 3:39 下午
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, User> map = new LinkedHashMap<>();
        map.put("abc", new User(1001, "user1"));
        map.put("dfd", new User(1002, "user2"));
        map.put("jkd", new User(1003, "user3"));
        map.put("ajj", new User(1004, "user4"));
        for (User user : map.values()) {
            System.out.println(user.getId());
        }

        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(new ArrayList<>());
        unmodifiableCollection.add("11");



    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private Integer id;
    private String name;

}
