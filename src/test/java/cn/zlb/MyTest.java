package cn.zlb;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * 测试类
 *
 * @author libao.zheng
 * @date 2020/8/26 10:42 上午
 */
public class MyTest {
    @Test
    public void test() {
        ArrayList<Integer> list1 = new ArrayList<>();
        int initialCapacity = 1000000;
        ArrayList<Integer> list2 = new ArrayList<>(initialCapacity);
        long begin1 = System.currentTimeMillis();
        for (int i = 0; i < initialCapacity; i++) {
            list1.add(1);
        }
        System.out.println("list1 cost time: " + (System.currentTimeMillis() - begin1));


        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < initialCapacity; i++) {
            list2.add(1);
        }
        System.out.println("list2 cost time: " + (System.currentTimeMillis() - begin2));
    }
}
