package cn.zlb.extpoint;

import cn.zlb.service.HelloService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MyInitializingBean implements InitializingBean {
    @Resource
    private HelloService helloService;

    /**
     * bean实例化过程中调用,afterPropertiesSet方法优先于init-method指定的方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
    }

    public MyInitializingBean() {
        System.out.println("MyInitializingBean构造方法");
        System.out.println(helloService);
    }
}
