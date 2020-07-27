package cn.zlb.biz;

import cn.zlb.biz.spring.A;

/**
 * 实现类A继承实现类A
 *
 * @author libao.zheng
 * @date 2020/7/27 8:50 上午
 */
public class C extends A {
    public void ccc() {
        //调用父类AbstractDemo的test()方法,父类test()方法会调用子类实现，即实现类A的run()方法
        test();
    }

    public static void main(String[] args) {
        new C().ccc();
    }
}
