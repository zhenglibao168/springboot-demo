package cn.zlb.designpattern.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 未付款状态
 *
 * @author libao.zheng
 * @date 2020/8/18 11:35 上午
 */
@Component
public class UnPaidOrderState implements OrderState {
    @Resource
    private PaidOrderState paidOrderState;
    @Override
    public void updateState(OrderContext orderContext) {
        System.out.println("订单未付款!");
        orderContext.setOrderState(paidOrderState);
    }
}
