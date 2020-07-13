package cn.zlb.extpoint;

import cn.zlb.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MyInitializingBean implements InitializingBean, BeanPostProcessor, BeanFactoryAware {
    @Resource
    private HelloService helloService;
    private BeanFactory beanFactory;

    public MyInitializingBean() {
        System.out.println("MyInitializingBean构造方法");
        System.out.println("helloService=" + helloService);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean.afterPropertiesSet");
        System.out.println(helloService);
        System.out.println("beanFactory=" + beanFactory);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
