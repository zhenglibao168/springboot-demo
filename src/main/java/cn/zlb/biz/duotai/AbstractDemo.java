package cn.zlb.biz.duotai;

/**
 * 抽象类
 *
 * @author libao.zheng
 * @date 2020/7/27 8:47 上午
 */
public abstract class AbstractDemo {
    public void test() {
        run();
      // System.out.println("test method");
    }

    protected abstract void run();
}
