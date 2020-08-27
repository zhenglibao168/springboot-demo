package cn.zlb;

import org.testng.annotations.Test;

/**
 * 测试类
 *
 * @author libao.zheng
 * @date 2020/8/26 10:42 上午
 */
public class MyTest {
    @Test
    public void test() {
        Long a = 128L;
        Long b = 128L;
        System.out.println(a == b);//false
    }
}
