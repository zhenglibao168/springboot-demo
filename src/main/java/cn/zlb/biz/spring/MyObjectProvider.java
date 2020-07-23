package cn.zlb.biz.spring;

import cn.zlb.biz.UserDO;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义factorybean
 *
 * @author libao.zheng
 * @date 2020/7/23 10:15 上午
 */
@Component
public class MyObjectProvider implements ObjectProvider<UserDO> {

    @Override
    public UserDO getObject(Object... args) throws BeansException {
        return new UserDO(1003L, UUID.randomUUID().toString().replace("-", ""), "10086", "zlb@163.com");
    }

    @Override
    public UserDO getIfAvailable() throws BeansException {
        return null;
    }

    @Override
    public UserDO getIfUnique() throws BeansException {
        return null;
    }

    @Override
    public UserDO getObject() throws BeansException {
        return new UserDO(1003L, UUID.randomUUID().toString().replace("-", ""), "10086", "zlb@163.com");
    }
}
