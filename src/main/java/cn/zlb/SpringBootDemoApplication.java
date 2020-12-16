package cn.zlb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
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
        // 该设置用于输出jdk动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib");
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
