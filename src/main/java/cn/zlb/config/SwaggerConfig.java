package cn.zlb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("cn.zlb")).build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("zlb", "https://github.com/zlba111/springboot-demo", "zhenglibao8@163.com");
        return new ApiInfo(
                "接口管理",
                "http接口管理",
                "v1.0",
                "https://github.com/zlba111",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}
