package cn.zlb.biz;

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

class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
