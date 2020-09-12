package cn.zlb.biz.spring.extpoint;

import cn.zlb.service.ValidationService;
import cn.zlb.web.ValidationController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextAware
 *
 * @author libao.zheng
 * @date 2020/7/8 3:31 下午
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ValidationService validationService = applicationContext.getBean(ValidationService.class);
        ValidationController validationController = applicationContext.getBean(ValidationController.class);
        System.out.println("validationService = " + validationService.hashCode());
        System.out.println("validationController = " + validationController.hashCode());
    }
}
