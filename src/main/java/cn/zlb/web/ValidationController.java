package cn.zlb.web;

import cn.zlb.biz.spring.extpoint.MyApplicationContextAware;
import cn.zlb.service.ValidationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * controller加上@Validated注解且controller方法是private时，controller依赖注入ValidationService值为null
 *
 * @author libao.zheng
 * @date 2020/9/11 9:51 上午
 */
@RestController
@Validated
public class ValidationController {
    @Resource
    private ValidationService validationService;

    @Resource
    private MyApplicationContextAware myApplicationContextAware;

    @GetMapping("testPrivate")
    private String testPrivate() {
        validationService.test();
        return "testPrivate";
    }

    @GetMapping("testPublic")
    public String testPublic() {
        ValidationController bean = myApplicationContextAware.getApplicationContext().getBean(ValidationController.class);
        System.out.println(bean);
        validationService.test();
        return "testPublic";
    }
}
