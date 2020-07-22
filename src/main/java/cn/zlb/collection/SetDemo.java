package cn.zlb.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set
 *
 * @author libao.zheng
 * @date 2020/7/21 7:30 下午
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        linkedHashSet.add("admin");
        linkedHashSet.add("user");
        linkedHashSet.add("test");
        linkedHashSet.add("bayy");
        linkedHashSet.forEach(item -> System.out.println("item=" + item));
    }
}
