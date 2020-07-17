package cn.zlb.biz;

import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 注解形式的监听器
 *
 * @author libao.zheng
 * @date 2020/7/17 1:50 下午
 */
//开启异步
@EnableAsync
@Component
public class AnnotationListener {
    @Async
    @EventListener
    @Order(1)
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("annotation context is started!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }

    @Async
    @EventListener
    @Order(2)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("annotation context is refreshed!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }

    @Async
    @EventListener
    @Order(3)
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("annotation context is closed!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }

    @Async
    @EventListener
    @Order(4)
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("annotation context is stopped!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
