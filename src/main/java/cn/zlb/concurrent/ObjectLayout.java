package cn.zlb.concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * 对象布局
 *
 * @author libao.zheng
 * @date 2020/12/2 9:14 上午
 */
public class ObjectLayout {
    public static void main(String[] args) {
        Person jack = new Person(1, "jack");
        // 打印对象布局
        System.out.println(ClassLayout.parseInstance(jack).toPrintable());
    }
}
