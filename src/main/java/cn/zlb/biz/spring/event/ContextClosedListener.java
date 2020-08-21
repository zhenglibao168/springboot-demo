package cn.zlb.biz.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 应用上下文-已关闭监听器
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
@Component
public class ContextClosedListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
      // System.out.println("context is closed!");
      // System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
