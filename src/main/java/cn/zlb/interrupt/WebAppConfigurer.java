package cn.zlb.interrupt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * web配置类
 *
 * @author libao.zheng
 * @date 2020/7/20 1:56 下午
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
    }
}
