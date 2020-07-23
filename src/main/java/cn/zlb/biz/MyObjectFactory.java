package cn.zlb.biz;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义factorybean
 *
 * @author libao.zheng
 * @date 2020/7/23 10:15 上午
 */
@Component
public class MyObjectFactory implements ObjectFactory<UserDO> {

    @Override
    public UserDO getObject() {
        return new UserDO(1002L, UUID.randomUUID().toString().replace("-", ""), "10086", "zlb@163.com");
    }
}
