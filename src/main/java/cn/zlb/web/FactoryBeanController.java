package cn.zlb.web;

import cn.zlb.biz.MyFactoryBean;
import cn.zlb.biz.MyObjectFactory;
import cn.zlb.biz.MyObjectProvider;
import cn.zlb.biz.UserDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * beanFactory.registerResolvableDependency(ServletRequest.class, new RequestObjectFactory());
 * beanFactory.registerResolvableDependency(ServletResponse.class, new ResponseObjectFactory());
 * beanFactory.registerResolvableDependency(HttpSession.class, new SessionObjectFactory());
 * beanFactory.registerResolvableDependency(WebRequest.class, new WebRequestObjectFactory());
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
