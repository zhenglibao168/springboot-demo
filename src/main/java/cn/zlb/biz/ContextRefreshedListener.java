package cn.zlb.biz;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 应用上下文-已刷新监听器
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("context is refreshed!");
        System.out.println("beanDefinition数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
