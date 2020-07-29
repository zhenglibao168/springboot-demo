package cn.zlb.biz.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8 lambda表达式
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
public class LambdaDemo {
    public static void main(String[] args) {

//************************* Map相关操作 *************************//
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 101);
        map.put("2", 102);
        map.put("3", 103);
        map.put("4", 104);
        map.put("6", 106);
        map.put("5", 105);
        map.put("7", 107);

        //根据map的key删除元素
        map.keySet().removeIf(key -> {
            if ("1".equals(key)) {
                return true;
            }
            return false;
        });

        //根据map的key删除元素
        map.entrySet().removeIf(value -> "3".equals(value.getKey()));

        //根据map的value删除元素
        map.entrySet().removeIf(value -> {
            if (value.getValue() == 102) {
                return true;
            }
            return false;
        });

        //遍历map所有元素
        System.out.println("map 遍历所有元素：");
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        //过滤map中符合条件的元素
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream().filter(value -> {
            if (value.getValue() == 104) {
                return false;
            }
            return true;
        });
        System.out.println("map 过滤后结果：");
        entryStream.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

//************************* List相关操作 *************************//
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //根据list元素值删除元素
        list.removeIf(item -> {
            if ("aaa".equals(item)) {
                return true;
            }
            return false;
        });

        //遍历list所有元素
        System.out.println("list 遍历所有元素:");
        list.forEach(item -> System.out.println("item=" + item));

        //过滤list中符合条件的元素，生成新list
        List<String> collect = list.stream().filter(item -> {
            if ("bbb".equals(item)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println("list 过滤后结果：");
        collect.forEach(item -> System.out.println("item=" + item));

        //list基本类型排序
        List<Integer> list2 = new ArrayList<>();
        list2.add(333);
        list2.add(222);
        list2.add(111);
        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("list2 比较元素大小:" + o1 + " vs " + o2);
                return o1.compareTo(o2);
            }
        });
        System.out.println("list2 按升序排序结果：" + list2);


        //list对象类型排序
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "test1", 15));
        students.add(new Student(2, "test1", 14));
        students.add(new Student(3, "test1", 20));
        students.add(new Student(4, "test1", 18));
        System.out.println("students排序前：" + students);
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println("students按age升序排序后：" + students);


        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        System.out.println("students按age降序排序后：" + students);
    }
}
