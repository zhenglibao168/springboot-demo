package cn.zlb.biz.thread;

import cn.zlb.biz.domain.UserDO;

/**
 * threadlocal测试
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set(new UserDO(123L, "zlb", "136118889999", "zlb@163.com"));
      // System.out.println(threadLocal.get());
    }
}
