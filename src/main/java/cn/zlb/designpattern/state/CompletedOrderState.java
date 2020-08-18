package cn.zlb.designpattern.state;

import org.springframework.stereotype.Component;

/**
 * 已完成款状态
 * @author libao.zheng
 * @date 2020/8/18 11:35 上午
 */
@Component
public class CompletedOrderState implements OrderState {
    @Override
    public void updateState(OrderContext orderContext) {
        System.out.println("订单已完成!");
        orderContext.setOrderState(null);
    }
}
