package cn.zlb.service;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 加载自定义配置文件
 */
@PropertySource("classpath:app-test.properties")
@ConfigurationProperties(prefix = "mysql.user")
@Service
@Data
@Validated
public class HelloService {
    //    读取自定义配置文件
    @Value("${app.name}")
    private String appName;
    //    读取springboot默认配置文件application.yml
    @Length(min = 2, message = "最小长度为2")
    private String name;
    private String passwd;

    public void sayHello() {
        System.out.println("=====================hello=====================");
        System.out.println("appName=" + appName);
        System.out.println("name=" + name);
        System.out.println("passwd=" + passwd);
    }
}
