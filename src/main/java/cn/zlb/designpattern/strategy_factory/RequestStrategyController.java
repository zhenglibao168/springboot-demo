package cn.zlb.designpattern.strategy_factory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 1、策略模式
 * 2、spring依赖注入实现工厂模式
 *
 * @author libao.zheng
 * @date 2020/8/18 11:13 上午
 */
@RestController
public class RequestStrategyController {
    @Resource
    private RequestStrategyFactory requestStrategyFactory;

    @GetMapping("request")
    public String request(String httpStrategy) {
        //发送请求
        return requestStrategyFactory.getBy(httpStrategy).request();
    }
}
