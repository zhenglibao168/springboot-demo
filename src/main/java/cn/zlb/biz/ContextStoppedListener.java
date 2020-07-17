package cn.zlb.biz;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 应用上下文-已停止监听器
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
@Component
public class ContextStoppedListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("context is stopped!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
