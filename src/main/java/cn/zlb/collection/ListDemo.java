package cn.zlb.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * list demo
 *
 * @author libao.zheng
 * @date 2020/7/21 7:35 下午
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> vector = new Vector<>();
        List<String> linkedList = new LinkedList<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        vector.add(null);
      // System.out.println(copyOnWriteArrayList);
    }
}
