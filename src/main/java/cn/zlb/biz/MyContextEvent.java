package cn.zlb.biz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 自定义事件
 *
 * @author libao.zheng
 * @date 2020/7/17 11:19 上午
 */
public class MyContextEvent extends ApplicationContextEvent {
    private String name;
    private String email;


    public MyContextEvent(ApplicationContext source, String name, String email) {
        super(source);
        this.name = name;
        this.email = email;
    }

    public MyContextEvent(ApplicationContext source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "MyContextEvent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
