package cn.zlb.design_pattern.strategy_factory;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 请求策略工厂
 *
 * @author libao.zheng
 * @date 2020/8/18 11:00 上午
 */
@Component
public class RequestStrategyFactory {
    @Resource
    //集合注入
    private Map<String, RequestStrategy> requestStrategyMap;

    /**
     * 根据策略类型获取策略bean
     *
     * @param strategyType
     * @return
     */
    public RequestStrategy getBy(String strategyType) {
        return requestStrategyMap.get(strategyType);
    }
}
