package cn.zlb.biz.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

/**
 * 自定义事件发布器
 *
 * @author libao.zheng
 * @date 2020/7/17 2:14 下午
 */
@Component
public class MyContextEventPublisher implements ApplicationEventPublisherAware, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent() {
        applicationContext.publishEvent(new MyContextEvent(applicationContext, "张三", "zhangsan@163.com", "ApplicationContext"));
        applicationEventPublisher.publishEvent(new MyContextEvent(applicationContext, "王雷", "wanglei@163.com", "ApplicationEventPublisher"));
        ApplicationEventMulticaster applicationEventMulticaster = applicationContext.getBean("applicationEventMulticaster", ApplicationEventMulticaster.class);
        applicationEventMulticaster.multicastEvent(new MyContextEvent(applicationContext, "李四", "lisi@163.com", "ApplicationEventMulticaster"));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
