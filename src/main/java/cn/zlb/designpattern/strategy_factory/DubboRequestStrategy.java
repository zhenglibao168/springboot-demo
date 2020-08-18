package cn.zlb.designpattern.strategy_factory;

import org.springframework.stereotype.Component;

/**
 * dubbo协议请求策略
 *
 * @author libao.zheng
 * @date 2020/8/18 10:47 上午
 */
@Component(ProtocolConstant.DUBBO_STRATEGY)
public class DubboRequestStrategy implements RequestStrategy {
    @Override
    public String request() {
        return "发送dubbo请求!";
    }
}
