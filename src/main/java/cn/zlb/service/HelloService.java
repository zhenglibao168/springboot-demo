package cn.zlb.service;

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
@Validated
public class HelloService {
    //    读取自定义配置文件
    @Value("${app.name}")
    private String appName;
    //    读取springboot默认配置文件application.yml
    @Length(min = 2, message = "最小长度为2")
    private String name;
    private String passwd;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String doTest(String name) {
        return name;
    }

    public void sayHello() {
      // System.out.println("=====================hello=====================");
      // System.out.println("appName=" + appName);
      // System.out.println("name=" + name);
      // System.out.println("passwd=" + passwd);
    }
}
