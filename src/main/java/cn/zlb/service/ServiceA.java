package cn.zlb.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author libao.zheng
 * @date 2020/12/11 5:26 下午
 */
@Service
public class ServiceA {
    @Resource
    private ServiceB serviceB;

    public ServiceB getServiceB() {
        return serviceB;
    }
}
