package cn.zlb.extpoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在bean实例化前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 在bean实例化后调用
     * 如果bean实现了InitializingBean，则在执行完* 该接口的afterPropertiesSet方法后调用
     * 如果实现了init-method则在执行完init-method后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
