package cn.zlb;

import java.util.ArrayList;
import java.util.List;

/**
 * demo
 *
 * @author libao.zheng
 * @date 2020/8/9 12:31 下午
 */
public class Demo {
    public static List<String> getStrings() {
        List<String> list = new ArrayList<>();
        list.add(DemoTest.getAllPinyin("王雷"));
        list.add(DemoTest.getAllPinyin("张丽丽"));
        list.add(DemoTest.getAllPinyin("张丽啊"));
        list.add(DemoTest.getAllPinyin("a张丽丽"));
        list.add(DemoTest.getAllPinyin("yao文雅"));
        list.add(DemoTest.getAllPinyin("Test"));
        list.add(DemoTest.getAllPinyin("test"));
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("1333");
        String[] arr = list.toArray(new String[0]);
        for (String s : arr) {
            System.out.println(s);
        }

    }
}
