package cn.zlb.biz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 自定义事件发布器
 *
 * @author libao.zheng
 * @date 2020/7/17 2:14 下午
 */
@Component
public class MyContextEventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void publishEvent() {
        applicationContext.publishEvent(new MyContextEvent(applicationContext, "张三", "zhangsan@163.com"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
