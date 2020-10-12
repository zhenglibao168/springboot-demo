package cn.zlb;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试类
 *
 * @author libao.zheng
 * @date 2020/8/26 10:42 上午
 */
public class MyTest {

    @Test
    public void test() {
        List<String> listA = new ArrayList(Arrays.asList("11", "2", "31","1"));
        List<String> listB = new ArrayList(Arrays.asList("11", "4", "2"));
        List<String> sameListByLoop = getSameListByLoop(listA, listB);
        sameListByLoop.forEach(System.out::println);
    }

    public List<String> getSameListByLoop(List<String> listA, List<String> listB) {
        long begin = System.nanoTime();//纳秒
        List<String> listC = new ArrayList<>();
        for (String str : listA) {
            if (listB.contains(str)) {
                listC.add(str);
            }
        }
        long end = System.nanoTime();
        System.out.println("take  " + (end - begin) + " time ");
        return listC;
    }
}
