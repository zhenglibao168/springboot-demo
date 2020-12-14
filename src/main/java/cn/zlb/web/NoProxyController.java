package cn.zlb.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 未被代理控制器
 *
 * @author libao.zheng
 * @date 2020/12/14 9:39 上午
 */
@RestController
public class NoProxyController implements BeanFactoryAware {

    @GetMapping("/no_proxy")
    public void noProxy() {
        System.out.println("no proxy method");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        NoProxyController noProxyController = beanFactory.getBean(NoProxyController.class);
        HelloController helloController = beanFactory.getBean(HelloController.class);
        System.out.println("NoProxyController bean = " + noProxyController);
        System.out.println("HelloController bean = " + helloController);
    }
}
