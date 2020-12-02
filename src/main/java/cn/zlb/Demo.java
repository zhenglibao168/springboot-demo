package cn.zlb;

import java.math.BigDecimal;

/**
 * demo
 *
 * @author libao.zheng
 * @date 2020/8/9 12:31 下午
 */
public class Demo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("34343.234567484155E8");
        System.out.println(bigDecimal.toPlainString());
        test(null);

    }

    private static void test(String name) {
        name="null";
        System.out.println(name);
    }
}
