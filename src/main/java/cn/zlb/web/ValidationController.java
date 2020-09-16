package cn.zlb.web;

import cn.zlb.service.ValidationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 1、IOC容器存放的bean是ValidationController的cglib代理类，beanName为validationController,不会存储ValidationController的bean
 * 2、cglib只能代理非private非final非static方法，通过回调 实现方法调用
 * 3、cglib不能代理private或final方法，通过反射 实现方法调用，详见VisibilityPredicate类evaluate方法
 * 4、testPublic方法调用通过FastClass回调ValidationController对象，ValidationController对象是在bean初始化之后放在代理对象的callback里
 * 5、testPrivate方法调用通过反射调用ValidationController代理对象，报空指针异常
 * CglibAopProxy.getProxy方法调用ObjenesisCglibAopProxy.createProxyClassAndInstance方法
 * createProxyClassAndInstance方法调用SpringObjenesis.newInstance方法生成代理对象ValidationController$$EnhancerBySpringCGLIB$$97f55215@54c1e5ca，不会生成ValidationController对象，代理对象拥有ValidationController的所有属性和方法,见下图
 * 代理对象属性ValidationService为null，所以执行validationService.test()报空指针异常
 * 如何避免？把testPrivate方法的访问修饰符private改成public、protected其中一个或去掉private
 *
 * @author libao.zheng
 * @date 2020/9/11 9:51 上午
 */
@RestController
@Validated
public class ValidationController {
    @Resource
    private ValidationService validationService;

    @GetMapping("testPrivate")
    private String testPrivate() {
        this.validationService.test();
        return "testPrivate";
    }

    @GetMapping("testPublic")
    public String testPublic() {
        this.validationService.test();
        return "testPublic";
    }
}
