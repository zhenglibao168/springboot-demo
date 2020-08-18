package cn.zlb.designpattern.strategy_factory;

import org.springframework.stereotype.Component;

/**
 * http协议请求策略
 *
 * @author libao.zheng
 * @date 2020/8/18 10:45 上午
 */
@Component(ProtocolConstant.HTTP_STRATEGY)
public class HttpRequestStrategy implements RequestStrategy {
    @Override
    public String request() {
        return "发送http请求!";
    }
}
