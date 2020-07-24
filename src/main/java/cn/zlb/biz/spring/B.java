package cn.zlb.biz.spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * B依赖A
 *
 * @author libao.zheng
 * @date 2020/7/24 3:09 下午
 */
@Component
public class B {
    @Resource
    private A a;

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
