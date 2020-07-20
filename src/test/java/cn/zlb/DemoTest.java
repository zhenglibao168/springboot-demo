package cn.zlb;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * demo test
 *
 * @author libao.zheng
 * @date 2020/7/20 10:29 上午
 */
public class DemoTest {
    @Test
    public void test() {
        System.out.println("A测试啊".toLowerCase());
        System.out.println("测试a啊".toUpperCase());
        System.out.println("测试啊a".toUpperCase());
        //多个字符串比较，只有有2个相同返回true，都不相同返回false
        boolean b1 = StringUtils.equalsAnyIgnoreCase("abc", "AbcD", "ABC");
        //比较不区分大小写
        boolean b2 = StringUtils.equalsIgnoreCase("aBCd", "AbcD");
        System.out.println(b1);
        System.out.println(b2);
    }
}
