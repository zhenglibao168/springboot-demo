package cn.zlb.web;

import cn.zlb.biz.MyFactoryBean;
import cn.zlb.biz.UserDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * factorybean 控制器
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

    @GetMapping("fatorybean")
    public UserDO getFactoryBean() {
        return myFactoryBean.getObject();
    }

    @GetMapping("userbean")
    public UserDO getUserBean() {
        return userDO;
    }
}
