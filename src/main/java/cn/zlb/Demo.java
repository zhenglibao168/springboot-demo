package cn.zlb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * demo
 *
 * @author libao.zheng
 * @date 2020/8/9 12:31 下午
 */
public class Demo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Demo> list = new ArrayList<>();
        List<Demo> list2 = new ArrayList<>();
        list.add(new Demo("aa"));
        list.add(new Demo("aa"));
        list.add(new Demo("bb"));
        list.add(new Demo("cc"));
        list2.addAll(list.stream().filter(x -> "aa".equals(x.getName())).collect(Collectors.toList()));
        list2.addAll(list.stream().filter(x -> "bb".equals(x.getName())).collect(Collectors.toList()));
        list2.addAll(list.stream().filter(x -> "cc".equals(x.getName())).collect(Collectors.toList()));
        System.out.println(list2);

    }
}
