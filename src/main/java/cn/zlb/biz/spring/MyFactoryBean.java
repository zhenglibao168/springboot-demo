package cn.zlb.biz.spring;

import cn.zlb.biz.domain.UserDO;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义factorybean
 *
 * @author libao.zheng
 * @date 2020/7/23 10:15 上午
 */
@Component
public class MyFactoryBean implements FactoryBean<UserDO> {

    @Override
    public UserDO getObject() {
        return new UserDO(1001L, UUID.randomUUID().toString().replace("-", ""), "10086", "zlb@163.com");
    }

    @Override
    public Class<?> getObjectType() {
        return UserDO.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
