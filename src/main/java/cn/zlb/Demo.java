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
        List<Field> excel = new ArrayList<>();
        excel.add(new Field("1", "aaa", "hangzhou"));
        excel.add(new Field("2", "bbb", "hangzhou"));
        excel.add(new Field("3", "ccc", "hangzhou"));

        List<Field> db = new ArrayList<>();
        db.add(new Field("2", "bbb", "hangzhou"));
        db.add(new Field("3", "ccc", "hangzhou"));

        excel.removeAll(db);
        for (Field field : excel) {
            System.out.println(field);
        }

    }
}
