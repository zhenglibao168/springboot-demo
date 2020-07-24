package cn.zlb.biz.spring;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * a
 *
 * @author libao.zheng
 * @date 2020/7/24 3:08 下午
 */
@Component
public class A {
    @Resource
    private B b;

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
