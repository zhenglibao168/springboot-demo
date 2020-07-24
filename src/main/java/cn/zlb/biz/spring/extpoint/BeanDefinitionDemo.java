package cn.zlb.biz.spring.extpoint;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * 注册普通bean
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
public class BeanDefinitionDemo {
    private int age = 20;

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        beanDefinitionReader.register(BeanDefinitionDemo.class);
        BeanDefinitionDemo beanDefinitionDemo = beanFactory.getBean(BeanDefinitionDemo.class);
        System.out.println(beanDefinitionDemo.age);
    }

    @Override
    public String toString() {
        return "BeanDefinitionDemo{" +
                "age=" + age +
                '}';
    }
}
