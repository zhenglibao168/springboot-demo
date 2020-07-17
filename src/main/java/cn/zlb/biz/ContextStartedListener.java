package cn.zlb.biz;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * 应用上下文-已启动监听器
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
@Component
public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("context is started!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
