package cn.zlb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 默认扫描@SpringBootApplication主类的当前package的所有bean
 * 也可以通过scanBasePackages配置
 * SpringBootApplication注解等价于@Configuration @EnableAutoConfiguration @ComponentScan
 */
@SpringBootApplication
@EnableTransactionManagement
//@ImportResource(locations = "classpath:bean.xml")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
