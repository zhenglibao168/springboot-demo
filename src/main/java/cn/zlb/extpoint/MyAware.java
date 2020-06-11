package cn.zlb.extpoint;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class MyAware implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DruidDataSource druidDataSource = beanFactory.getBean("druidDataSource", DruidDataSource.class);
        System.out.println("minIdle=" + druidDataSource.getMinIdle());
        System.out.println("maxActive=" + druidDataSource.getMaxActive());
    }
}
