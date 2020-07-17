package cn.zlb.biz;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 自定义监听器
 *
 * @author libao.zheng
 * @date 2020/7/17 1:44 下午
 */
@Component
public class MyContextListener implements ApplicationListener<MyContextEvent> {
    @Resource
    private MyContextEventPublisher myContextEventPublisher;

    @PostConstruct
    public void init() {
        myContextEventPublisher.publishEvent();
    }

    @Override
    public void onApplicationEvent(MyContextEvent event) {
        System.out.println("自定义事件监听器MyContextListener");
        System.out.println(event);
    }
}
