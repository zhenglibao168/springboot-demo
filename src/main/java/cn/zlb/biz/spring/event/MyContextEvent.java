package cn.zlb.biz.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;


/**
 * 自定义事件
 *
 * @author libao.zheng
 * @date 2020/7/17 11:19 上午
 */
public class MyContextEvent extends ApplicationContextEvent {
    private String name;
    private String email;
    private String publishSource;


    public MyContextEvent(ApplicationContext source, String name, String email, String publishSource) {
        super(source);
        this.name = name;
        this.email = email;
        this.publishSource = publishSource;
    }

    public String getPublishSource() {
        return publishSource;
    }

    @Override
    public String toString() {
        return "MyContextEvent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", publishSource='" + publishSource + '\'' +
                '}';
    }
}
