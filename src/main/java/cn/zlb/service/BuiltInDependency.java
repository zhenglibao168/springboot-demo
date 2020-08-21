package cn.zlb.service;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.DefaultEventListenerFactory;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 内建依赖
 *
 * @author libao.zheng
 * @date 2020/7/8 2:46 下午
 */
@Component
public class BuiltInDependency {
    @Resource
    private Environment environment;
    @Resource
    private Map<String, Object> systemProperties;
    @Resource
    private Map<String, Object> systemEnvironment;
    @Resource
    private MessageSource messageSource;
    @Resource
    private LifecycleProcessor lifecycleProcessor;
    @Resource
    private ConfigurationClassPostProcessor configurationClassPostProcessor;
    @Resource
    private ApplicationEventMulticaster applicationEventMulticaster;
    @Resource
    private AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor;
    @Resource
    private CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor;
    @Resource
    private EventListenerMethodProcessor eventListenerMethodProcessor;
    @Resource
    private DefaultEventListenerFactory defaultEventListenerFactory;

    @PostConstruct
    private void init() {
      // System.out.println(environment);
      // System.out.println(systemProperties);
      // System.out.println(systemEnvironment);
      // System.out.println(messageSource);
      // System.out.println(lifecycleProcessor);
      // System.out.println(applicationEventMulticaster);
      // System.out.println(configurationClassPostProcessor);
      // System.out.println(autowiredAnnotationBeanPostProcessor);
      // System.out.println(commonAnnotationBeanPostProcessor);
      // System.out.println(eventListenerMethodProcessor);
      // System.out.println(defaultEventListenerFactory);
    }
}
