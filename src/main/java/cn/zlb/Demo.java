package cn.zlb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * demo
 *
 * @author libao.zheng
 * @date 2020/8/9 12:31 下午
 */
public class Demo {
    public static List<String> getStrings() {
        List<String> list = new ArrayList<>();
        list.add(PinYinUtil.getPinYin("王雷"));
        list.add(PinYinUtil.getPinYin("张丽丽"));
        list.add(PinYinUtil.getPinYin("张丽啊"));
        list.add(PinYinUtil.getPinYin("a张丽丽"));
        list.add(PinYinUtil.getPinYin("yao文雅"));
        list.add(PinYinUtil.getPinYin("Test"));
        list.add(PinYinUtil.getPinYin("test"));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}