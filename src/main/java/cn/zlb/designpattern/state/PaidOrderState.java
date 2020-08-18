package cn.zlb.designpattern.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 已付款状态
 *
 * @author libao.zheng
 * @date 2020/8/18 11:35 上午
 */
@Component
public class PaidOrderState implements OrderState {
    @Resource
    private CompletedOrderState completedOrderState;
    @Override
    public void updateState(OrderContext orderContext) {
        System.out.println("订单已付款!");
        orderContext.setOrderState(completedOrderState);
    }
}
