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
      // System.out.println("map 遍历所有元素：");
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        //过滤map中符合条件的元素
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream().filter(value -> {
            if (value.getValue() == 104) {
                return false;
            }
            return true;
        });
      // System.out.println("map 过滤后结果：");
        entryStream.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));


        //TreeMap/LinkedHashMap按key降序排序
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("a", 3);
        treeMap.put("c", 1);
        treeMap.put("b", 2);
        List<Map.Entry<String, Integer>> treeMapList = new ArrayList<>(treeMap.entrySet());
        treeMapList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        LinkedHashMap<String, Integer> newTreeMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : treeMapList) {
            newTreeMap.put(entry.getKey(), entry.getValue());
        }

      // System.out.println("treeMap按key降序排序之后结果：");
        newTreeMap.forEach((key, value) -> System.out.println(key + ":" + value));

        //TreeMap/LinkedHashMap按value升序排序
        Map<String, Integer> treeMap2 = new TreeMap<>();
        treeMap2.put("aa", 22);
        treeMap2.put("bb", 11);
        treeMap2.put("cc", 33);
        List<Map.Entry<String, Integer>> treeMapList2 = new ArrayList<>(treeMap2.entrySet());
        treeMapList2.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        LinkedHashMap<String, Integer> newTreeMap2 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : treeMapList2) {
            newTreeMap2.put(entry.getKey(), entry.getValue());
        }

      // System.out.println("treeMap按value升序排序之后结果：");
        newTreeMap2.forEach((key, value) -> System.out.println(key + ":" + value));


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
      // System.out.println("list 遍历所有元素:");
        list.forEach(item -> System.out.println("item=" + item));

        //过滤list中符合条件的元素，生成新list
        List<String> collect = list.stream().filter(item -> {
            if ("bbb".equals(item)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
      // System.out.println("list 过滤后结果：");
        collect.forEach(item -> System.out.println("item=" + item));

        //list基本类型排序
        List<Integer> list2 = new ArrayList<>();
        list2.add(333);
        list2.add(222);
        list2.add(111);
        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              // System.out.println("list2 比较元素大小:" + o1 + " vs " + o2);
                return o1.compareTo(o2);
            }
        });
      // System.out.println("list2 按升序排序结果：" + list2);


        //list对象类型排序
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "test1", 15));
        students.add(new Student(2, "test1", 14));
        students.add(new Student(3, "test1", 20));
        students.add(new Student(4, "test1", 18));
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
      // System.out.println("students按age升序排序后：" + students);


        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
      // System.out.println("students按age降序排序后：" + students);

        //List转数组
        ArrayList<String> sourceList = new ArrayList<>();
        sourceList.add("454");
        sourceList.add("234");
        sourceList.add("234");
        sourceList.add("555");

        String[] descArray = sourceList.toArray(new String[0]);
      // System.out.println("List转数组后:");
        for (String s : descArray) {
          // System.out.println(s);
        }


        //List排序并去重
        List<String> aList = new ArrayList<>(Arrays.asList("aaa", "xyr", "xyr", "ddd", "aaa"));
        aList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        List<String> sortedList = list.stream().distinct().collect(Collectors.toList());
      // System.out.println("List排序并去重:");
        list.forEach(System.out::println);
    }
}
