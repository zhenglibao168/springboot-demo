package cn.zlb.web;

import cn.zlb.biz.domain.UserDO;
import cn.zlb.biz.spring.MyFactoryBean;
import cn.zlb.biz.spring.MyObjectFactory;
import cn.zlb.biz.spring.MyObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统内置FactoryBean
 * beanFactory.registerResolvableDependency(ServletRequest.class,newRequestObjectFactory());
 * beanFactory.registerResolvableDependency(ServletResponse.class,newResponseObjectFactory());
 * beanFactory.registerResolvableDependency(HttpSession.class,newSessionObjectFactory());
 * beanFactory.registerResolvableDependency(WebRequest.class,newWebRequestObjectFactory());
 *
 * @author libao.zheng
 * @date 2020/7/23 10:19 上午
 */
@RestController
public class FactoryBeanController {
    @Resource(name = "&myFactoryBean")
    private MyFactoryBean myFactoryBean;

    @Resource(name = "myFactoryBean")
    private UserDO userDO;

    @Resource
    private MyObjectFactory myObjectFactory;

    @Resource
    private MyObjectProvider myObjectProvider;

    @GetMapping("factorybean")
    public UserDO getFactoryBean() {
        return myFactoryBean.getObject();
    }

    @GetMapping("userbean")
    public UserDO getUserBean() {
        return userDO;
    }

    @GetMapping("objectfactory")
    public UserDO getObjectFactory() {
        return myObjectFactory.getObject();
    }

    @GetMapping("objectprovider")
    public UserDO getObjectProvider() {
        return myObjectProvider.getObject();
    }
}
